package cn.rich.lottery.interfaces;

import cn.rich.lottery.common.Constants;
import cn.rich.lottery.common.Result;
import cn.rich.lottery.infrastructure.dao.IActivityDao;
import cn.rich.lottery.infrastructure.po.Activity;
import cn.rich.lottery.rpc.IActivityBooth;
import cn.rich.lottery.rpc.dto.ActivityDto;
import cn.rich.lottery.rpc.req.ActivityReq;
import cn.rich.lottery.rpc.res.ActivityRes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: rich
 * @date: 2023/7/12 16:16
 * @description:
 */
@Service
public class ActivityBooth implements IActivityBooth {

    @Resource
    private IActivityDao activityDao;

    @Override
    public ActivityRes queryActivityById(ActivityReq activityReq) {
        Activity activity = activityDao.queryActivityById(activityReq.getActivityId());

        ActivityDto activityDto = new ActivityDto();
        activityDto.builder().activityId(activity.getActivityId())
                .activityName(activity.getActivityName())
                .activityDesc(activity.getActivityDesc())
                .beginDateTime(activity.getBeginDateTime())
                .endDateTime(activity.getEndDateTime())
                .stockCount(activity.getStockCount())
                .takeCount(activity.getTakeCount()).build();
        return new ActivityRes(new Result(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo()), activityDto);
    }
}
