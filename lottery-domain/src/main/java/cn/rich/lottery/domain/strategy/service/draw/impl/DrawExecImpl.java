package cn.rich.lottery.domain.strategy.service.draw.impl;

import cn.rich.lottery.domain.strategy.model.req.DrawReq;
import cn.rich.lottery.domain.strategy.model.res.DrawResult;
import cn.rich.lottery.domain.strategy.service.draw.DrawBase;
import cn.rich.lottery.domain.strategy.service.draw.IDrawExec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author rich
 * @version 1.0
 * @create 2024/08/14
 */
@Service("drawExec")
@Slf4j
public class DrawExecImpl extends DrawBase implements IDrawExec {


    @Override
    public DrawResult doDraw(DrawReq drawReq) {
        log.info("");
        return null;
    }
}
