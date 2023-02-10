package cn.xuelianyong.study.circleref.crane;

import cn.xuelianyong.study.circleref.biz.ABiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lijunpeng02
 * @date 2022年12月05日 21:51
 */
@Component
public class ACraneJob extends AbstractJob {

    @Autowired
    private ABiz aBiz;
}
