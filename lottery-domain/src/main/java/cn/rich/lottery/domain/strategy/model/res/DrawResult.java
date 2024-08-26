package cn.rich.lottery.domain.strategy.model.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author rich
 * @version 1.0
 * @create 2024/08/14
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DrawResult {

    // 用户ID
    private Long uId;

    // 策略ID
    private Long strategyId;

    // 奖品ID
    private Long awardId;

    // 奖品名称
    private String awardName;
}
