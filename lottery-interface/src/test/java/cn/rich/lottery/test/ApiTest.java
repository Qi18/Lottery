package cn.rich.lottery.test;

import cn.rich.lottery.infrastructure.dao.IActivityDao;
import cn.rich.lottery.infrastructure.po.Activity;
import cn.rich.lottery.rpc.IActivityBooth;
import com.alibaba.fastjson.JSON;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.junit.Test;
import org.slf4j.Logger;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author: rich
 * @date: 2023/7/13 16:51
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    private final Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Resource
    IActivityDao activityDao;



    @Test
    public void test_insert() {
        Activity activity = new Activity();
        activity.setActivityId(100003L);
        activity.setActivityName("测试");
        activity.setActivityDesc("仅用于插入数据测试");
        activity.setBeginDateTime(new Date());
        activity.setEndDateTime(new Date());
        activity.setStockCount(100);
        activity.setTakeCount(10);
        activity.setState(0);
        activity.setCreator("rich");
        activityDao.insert(activity);
    }

    @Test
    public void test_select() {
        Activity activity = activityDao.queryActivityById(100003L);
        logger.info("测试：{}", JSON.toJSONString(activity));
    }


}
