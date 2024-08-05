package cn.rich.lottery.infrastructure.dao;

import cn.rich.lottery.infrastructure.po.StrategyDetail;

import java.util.List;

/**
 * @author rich
 * @version 1.0
 * @create 2024/08/05
 */
public interface IStrategyDetailDao {
    List<StrategyDetail> queryStrategyDetailList(Long strategyId);
}
