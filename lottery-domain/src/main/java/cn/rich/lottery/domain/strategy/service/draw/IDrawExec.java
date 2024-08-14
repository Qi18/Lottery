package cn.rich.lottery.domain.strategy.service.draw;

import cn.rich.lottery.domain.strategy.model.req.DrawReq;
import cn.rich.lottery.domain.strategy.model.res.DrawResult;

/**
 * @author rich
 * @version 1.0
 * @create 2024/08/04
 */
public interface IDrawExec {

    DrawResult doDraw(DrawReq drawReq);
}
