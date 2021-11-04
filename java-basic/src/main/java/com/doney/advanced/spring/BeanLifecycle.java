package com.doney.advanced.spring;

import com.alicp.jetcache.anno.support.ConfigMap;
import com.alicp.jetcache.autoconfigure.JetCacheAutoConfiguration;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


/**
 * Spring 各个会掉接口的执行顺序
 * <br>org.springframework.beans.factory.InitializingBean
 * <br>org.springframework.beans.factory.DisposableBean
 * <br>org.springframework.context.Lifecycle
 * <br>org.springframework.context.ApplicationListener <T>
 * <br>org.springframework.context.ApplicationContextAware
 *
 */
@Configuration
@SpringBootApplication( scanBasePackages = "com.doney.advanced.spring" , exclude = {DataSourceAutoConfiguration.class, JetCacheAutoConfiguration.class})
public class BeanLifecycle implements InitializingBean, DisposableBean, Lifecycle,ApplicationListener<ApplicationStartedEvent>, ApplicationContextAware {

    public static String InitializingBeanAfterPropertiesSet = "InitializingBean#AfterPropertiesSet";

    public static String DisposableBeanDestroy = "DisposableBean#Destroy";

    public static String LifecycleStart = "Lifecycle#Start";
    public static String LifecycleStop = "Lifecycle#Stop";
    public static String LifecycleIsRunning = "Lifecycle#IsRunning";

    public static String ApplicationContextAwareSetApplicationContext = "ApplicationContextAware#SetApplicationContext";

    public static String ApplicationListenerApplicationStartedEvent = "ApplicationListener#ApplicationStartedEvent";

    public static String PostConstruct = "PostConstruct";
    public static String PreDestroy = "PreDestroy";


    public static void main(String[] args) {
        SpringApplication.run(BeanLifecycle.class, args);
    }

    @PostConstruct
    public void PostConstruct(){
        print(PostConstruct);
    }

    @PreDestroy
    public void PreDestroy(){
        print(PreDestroy);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        print(InitializingBeanAfterPropertiesSet);
    }

    @Override
    public void destroy() throws Exception {
       print(DisposableBeanDestroy);
    }

    @Override
    public void start() {
        print(LifecycleStart);
    }

    @Override
    public void stop() {
       print(LifecycleStop);
    }

    @Override
    public boolean isRunning() {
        print(LifecycleIsRunning);
        return true;
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        print(ApplicationListenerApplicationStartedEvent);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        print(ApplicationContextAwareSetApplicationContext);
    }

    private void print(String str){
        System.out.println(str);
    }
}
