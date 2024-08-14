package cn.rich.lottery.domain.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author rich
 * @version 1.0
 * @create 2024/08/14
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AwardRateInfo {

    private Long awardId;

    private BigDecimal awardRate;
}
