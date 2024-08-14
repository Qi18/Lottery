package cn.rich.lottery.domain.strategy.repository;

import cn.rich.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.rich.lottery.infrastructure.po.Award;

/**
 * @author rich
 * @version 1.0
 * @create 2024/08/02
 */
public interface IStrategyRepository {

    StrategyRich queryStrategyRichById(Long strategyId);

    Award queryAwardInfoById(Long awardId);
}
