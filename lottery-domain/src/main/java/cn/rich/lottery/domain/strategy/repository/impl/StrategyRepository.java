package cn.rich.lottery.domain.strategy.repository.impl;

import cn.rich.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.rich.lottery.domain.strategy.repository.IStrategyRepository;
import cn.rich.lottery.infrastructure.dao.IAwardDao;
import cn.rich.lottery.infrastructure.dao.IStrategyDao;
import cn.rich.lottery.infrastructure.dao.IStrategyDetailDao;
import cn.rich.lottery.infrastructure.po.Award;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author rich
 * @version 1.0
 * @create 2024/08/02
 */
@Component
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Resource
    private IAwardDao awardDao;


    @Override
    public StrategyRich queryStrategyRichById(Long strategyId) {
        return StrategyRich.builder().strategyId(strategyId).strategy(strategyDao.queryStrategy(strategyId))
                .strategyDetails(strategyDetailDao.queryStrategyDetailList(strategyId)).build();
    }

    @Override
    public Award queryAwardInfoById(Long awardId) {
        return awardDao.queryAwardInfo(awardId);
    }
}
