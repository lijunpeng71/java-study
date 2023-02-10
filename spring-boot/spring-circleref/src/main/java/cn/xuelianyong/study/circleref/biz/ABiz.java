package cn.xuelianyong.study.circleref.biz;

import cn.xuelianyong.study.circleref.repository.PicRepositoryImpl;
import cn.xuelianyong.study.circleref.service.AService;
import cn.xuelianyong.study.circleref.service.BService;
import cn.xuelianyong.study.circleref.service.CService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lijunpeng02
 * @date 2022年12月05日 21:59
 */
@Service
public class ABiz {


    @Autowired
    private PicRepositoryImpl picRepository;

    @Autowired
    private AService aService;

    @Autowired
    private BService bService;

    @Autowired
    private CService cService;
}
