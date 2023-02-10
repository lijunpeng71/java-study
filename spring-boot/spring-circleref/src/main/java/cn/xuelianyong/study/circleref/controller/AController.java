package cn.xuelianyong.study.circleref.controller;

import cn.xuelianyong.study.circleref.biz.ABiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijunpeng02
 * @date 2022年12月05日 22:34
 */
@RestController
@RequestMapping("/a")
public class AController {

    @Autowired
    private ABiz aBiz;

    @GetMapping("/index")
    public String index() {
        System.out.println(aBiz.toString());
        return "index";
    }
}
