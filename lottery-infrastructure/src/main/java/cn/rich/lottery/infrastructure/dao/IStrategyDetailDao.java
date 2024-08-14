package cn.rich.lottery.infrastructure.dao;

import cn.rich.lottery.infrastructure.po.StrategyDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author rich
 * @version 1.0
 * @create 2024/08/05
 */
@Mapper
public interface IStrategyDetailDao {
    List<StrategyDetail> queryStrategyDetailList(Long strategyId);
}
