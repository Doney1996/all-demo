package com.doney.advanced.spring;

import com.doney.advanced.jpa.primary.User;
import com.doney.advanced.jpa.second.repo.UserRepo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.*;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;


@Configuration
public class Bean1 implements InitializingBean, DisposableBean, Lifecycle,ApplicationListener<ApplicationStartedEvent>, ApplicationContextAware {

    @Autowired
    @Qualifier("UserRepo1")
    private com.doney.advanced.jpa.primary.repo.UserRepo primaryUserRepo;

    @Autowired
    @Qualifier("UserRepo2")
    private  UserRepo  secondUserRepo;


    @PostConstruct
    public void PostConstruct(){
        System.out.println("PostConstruct");
    }
    @PreDestroy
    public void PreDestroy(){
        System.out.println("PreDestroy");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    @Override
    public void start() {
        System.out.println("start");
    }

    @Override
    public void stop() {
        System.out.println("stop");
    }

    @Override
    public boolean isRunning() {
        System.out.println("isRunning");
        return false;
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        ConfigurableApplicationContext applicationContext = event.getApplicationContext();
        System.out.println("onApplicationEvent");
        System.out.println("springBoot 加载完毕");

        List<User> all = primaryUserRepo.findAll();

        List<com.doney.advanced.jpa.second.User> all1 = secondUserRepo.findAll();

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext");
    }
}
