package cn.xuelianyong.study.circleref.service;

import cn.xuelianyong.study.circleref.repository.PicRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lijunpeng02
 * @date 2022年12月05日 19:29
 */
@Service
public class AService {

    @Autowired
    private PicRepositoryImpl picRepository;
}
