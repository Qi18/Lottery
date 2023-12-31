package cn.rich.lottery.rpc.res;

import cn.rich.lottery.common.Result;
import cn.rich.lottery.rpc.dto.ActivityDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: rich
 * @date: 2023/7/12 16:13
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityRes implements Serializable {

    private Result result;

    private ActivityDto activityDto;
}
