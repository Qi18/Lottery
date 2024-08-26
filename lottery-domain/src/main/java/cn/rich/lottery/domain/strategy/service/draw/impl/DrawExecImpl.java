package cn.rich.lottery.domain.strategy.service.draw.impl;

import cn.rich.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.rich.lottery.domain.strategy.model.req.DrawReq;
import cn.rich.lottery.domain.strategy.model.res.DrawResult;
import cn.rich.lottery.domain.strategy.model.vo.AwardRateInfo;
import cn.rich.lottery.domain.strategy.repository.IStrategyRepository;
import cn.rich.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.rich.lottery.domain.strategy.service.draw.DrawBase;
import cn.rich.lottery.domain.strategy.service.draw.IDrawExec;
import cn.rich.lottery.infrastructure.po.Award;
import cn.rich.lottery.infrastructure.po.Strategy;
import cn.rich.lottery.infrastructure.po.StrategyDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author rich
 * @version 1.0
 * @create 2024/08/14
 */
@Service("drawExec")
@Slf4j
public class DrawExecImpl extends DrawBase implements IDrawExec {

    @Resource
    private IDrawAlgorithm defaultRateRandomDrawAlgorithm;

    @Resource
    private IDrawAlgorithm singleRateRandomDrawAlgorithm;

    @Resource
    private IStrategyRepository strategyRepository;

    protected static Map<Integer, IDrawAlgorithm> drawAlgorithmMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        drawAlgorithmMap.put(1, defaultRateRandomDrawAlgorithm);
        drawAlgorithmMap.put(2, singleRateRandomDrawAlgorithm);
    }

    public void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetailList) {
        // 目前统一使用复合抽奖算法
        if (1 != strategyMode) return;
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategyMode);

        // 初始化过的不再初始化
        boolean existRateTuple = drawAlgorithm.isExistRateTuple(strategyId);
        if (existRateTuple) return;

        List<AwardRateInfo> awardRateInfoList = new ArrayList<>(strategyDetailList.size());
        for (StrategyDetail strategyDetail : strategyDetailList) {
            awardRateInfoList.add(new AwardRateInfo(strategyDetail.getAwardId(), strategyDetail.getAwardRate()));
        }

        drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);

    }


    @Override
    public DrawResult doDraw(DrawReq drawReq) {
        log.info("执行策略抽奖开始，strategyId：{}", drawReq.getStrategyId());

        // 获取抽奖策略配置数据
        StrategyRich strategyRich = strategyRepository.queryStrategyRichById(drawReq.getStrategyId());
        Strategy strategy = strategyRich.getStrategy();
        List<StrategyDetail> strategyDetailList = strategyRich.getStrategyDetails();

        // 校验和初始化数据
        checkAndInitRateData(drawReq.getStrategyId(), strategy.getStrategyMode(), strategyDetailList);

        // 根据策略方式抽奖
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategy.getStrategyMode());
        Long awardId = drawAlgorithm.randomDraw(drawReq.getStrategyId(), new ArrayList<>());

        // 获取奖品信息
        Award award = strategyRepository.queryAwardInfoById(awardId);

        log.info("执行策略抽奖完成，中奖用户：{} 奖品ID：{} 奖品名称：{}", drawReq.getUId(), awardId, award.getAwardName());

        // 封装结果
        return new DrawResult(drawReq.getUId(), drawReq.getStrategyId(), awardId, award.getAwardName());
    }
}
