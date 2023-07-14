package cn.rich.lottery.interfaces;

import cn.rich.lottery.common.Constants;
import cn.rich.lottery.common.Result;
import cn.rich.lottery.infrastructure.dao.IActivityDao;
import cn.rich.lottery.infrastructure.po.Activity;
import cn.rich.lottery.rpc.IActivityBooth;
import cn.rich.lottery.rpc.dto.ActivityDto;
import cn.rich.lottery.rpc.req.ActivityReq;
import cn.rich.lottery.rpc.res.ActivityRes;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @author: rich
 * @date: 2023/7/12 16:16
 * @description:
 */
@Service
@Slf4j
public class ActivityBooth implements IActivityBooth {

    @Resource
    private IActivityDao activityDao;

    @Override
    public ActivityRes queryActivityById(ActivityReq activityReq) {
        Activity activity = activityDao.queryActivityById(activityReq.getActivityId());
        log.info("activityReq" + activityReq.toString());

        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityId(activity.getActivityId());
        activityDto.setActivityName(activity.getActivityName());
        activityDto.setActivityDesc(activity.getActivityDesc());
        activityDto.setBeginDateTime(activity.getBeginDateTime());
        activityDto.setEndDateTime(activity.getEndDateTime());
        activityDto.setStockCount(activity.getStockCount());
        activityDto.setTakeCount(activity.getTakeCount());
        log.info("activityDto" + activityDto.toString());
        return new ActivityRes(new Result(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo()), activityDto);
    }
}
