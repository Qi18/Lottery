package cn.rich.lottery.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author rich
 * @version 1.0
 * @create 2024/08/05
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StrategyDetail {
    // 自增ID
    private Long id;

    // 策略ID
    private Long strategyId;

    // 奖品ID
    private Long awardId;

    // 奖品数量
    private String awardCount;

    // 中奖概率
    private BigDecimal awardRate;

    // 创建时间
    private String createTime;

    // 修改时间
    private String updateTime;
}
