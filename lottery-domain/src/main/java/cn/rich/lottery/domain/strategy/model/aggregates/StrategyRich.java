package cn.rich.lottery.domain.strategy.model.aggregates;

import lombok.*;

import java.util.List;

import cn.rich.lottery.infrastructure.po.Strategy;
import cn.rich.lottery.infrastructure.po.StrategyDetail;


/**
 * @author rich
 * @version 1.0
 * @create 2024/08/14
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StrategyRich {

    private Long strategyId;

    private Strategy strategy;

    private List<StrategyDetail> strategyDetails;
}
