package cn.rich.lottery.infrastructure.dao;

import cn.rich.lottery.infrastructure.po.Activity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: rich
 * @date: 2023/7/12 16:22
 * @description:
 */

@Mapper
public interface IActivityDao {

    void insert(Activity req);

    Activity queryActivityById(Long activityId);
}
