package cn.xuelianyong.study.circleref.crane;

import cn.hutool.json.JSONUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ATaskCenterInitCrane implements ApplicationContextAware, InitializingBean, DisposableBean {
    protected ApplicationContext applicationContext;

    public ATaskCenterInitCrane() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, AbstractJob> taskCenterBeanMap = this.applicationContext.getBeansOfType(AbstractJob.class);
        System.out.println(JSONUtil.toJsonStr(taskCenterBeanMap));
    }

    @Override
    public void destroy() throws Exception {
    }
}
