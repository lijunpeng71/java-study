package cn.xuelianyong.study.nuxt.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lijunpeng02
 * @date 2023年02月10日 19:45
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public Map<String, Object> login() {
        Map<String, Object> resultMap = new HashMap<>(3);
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", "登录成功");
        return resultMap;
    }
}
