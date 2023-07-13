package cn.rich.lottery.rpc.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: rich
 * @date: 2023/7/12 16:13
 * @description:
 */
@Data
public class ActivityReq implements Serializable {

    private Long activityId;
}
