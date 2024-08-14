package cn.rich.lottery.domain.strategy.model.req;

import lombok.Getter;
import lombok.Setter;

/**
 * @author rich
 * @version 1.0
 * @create 2024/08/14
 */

@Getter
@Setter
public class DrawReq {
    // 用户ID
    private String uId;

    // 策略ID
    private Long strategyId;
}
