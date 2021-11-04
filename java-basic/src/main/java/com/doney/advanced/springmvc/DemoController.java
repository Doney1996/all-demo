package com.doney.advanced.springmvc;

import com.doney.advanced.exception.AppException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
@RequestMapping("/test")
public class DemoController implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {


        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) ((ConfigurableApplicationContext) applicationContext).getBeanFactory();

        // 通过BeanDefinitionBuilder创建bean定义
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
                .genericBeanDefinition(A.class);

        // 设置属性userAcctDAO,此属性引用已经定义的bean:userAcctDAO
//        beanDefinitionBuilder
//                .addPropertyReference("name", "weixiao");


        // 注册bean
        defaultListableBeanFactory.registerBeanDefinition("bean-id",
                beanDefinitionBuilder.getRawBeanDefinition());


    }

    @GetMapping("g1")
    public String g1(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (Objects.isNull(user) || StringUtils.isEmpty(user))
            throw new IllegalArgumentException("没有登录");
        return "hello world";
    }

    @GetMapping("login")
    public String login(HttpServletRequest request, String username) {
        HttpSession session = request.getSession();
        session.setAttribute("user", username);
        return "success";
    }

    @GetMapping("exception")
    public Object get() {
        throw new AppException("测试全局异常！");
    }

}

class A {
    public String name = "jsck";
}
