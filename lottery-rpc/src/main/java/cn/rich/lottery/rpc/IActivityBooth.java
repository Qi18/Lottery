package cn.rich.lottery.rpc;

import cn.rich.lottery.rpc.req.ActivityReq;
import cn.rich.lottery.rpc.res.ActivityRes;

/**
 * @author: rich
 * @date: 2023/7/12 16:13
 * @description:
 */
public interface IActivityBooth {

    ActivityRes queryActivityById(ActivityReq activityReq);
}
