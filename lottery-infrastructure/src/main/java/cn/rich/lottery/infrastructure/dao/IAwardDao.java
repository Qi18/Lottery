package cn.rich.lottery.infrastructure.dao;

import cn.rich.lottery.infrastructure.po.Award;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author rich
 * @version 1.0
 * @create 2024/08/05
 */

@Mapper
public interface IAwardDao {

    Award queryAwardInfo(String awardId);
}

