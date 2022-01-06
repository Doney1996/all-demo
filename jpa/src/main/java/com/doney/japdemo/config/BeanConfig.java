package com.doney.japdemo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class BeanConfig {


    //还不知道怎么初始化这个
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan("com");
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.session_factory.interceptor","org.hibernate.EmptyInterceptor");
        sessionFactoryBean.setHibernateProperties(hibernateProperties);
        return sessionFactoryBean;
    }



}
