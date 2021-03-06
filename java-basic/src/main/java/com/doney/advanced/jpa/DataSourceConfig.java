package com.doney.advanced.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Objects;

/**
 * 使用Jpa 配置连个数据源
 */
@Configuration
public class DataSourceConfig{

//    @Bean("primaryDatasource")
//    @ConfigurationProperties(prefix = "spring.datasource")
//    @Primary
//    public DataSource primaryDataSource() { return DataSourceBuilder.create().build(); }

    @Bean("secondDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource secondDataSource() {
        return DataSourceBuilder.create().build();
    }



}

@Configuration
@EntityScan(basePackages = "com.doney.advanced.jpa.primary")
//1、实体扫描
//2、实体管理ref
//3、事务管理
@EnableJpaRepositories(
        basePackages = "com.doney.advanced.jpa.primary.repo",
        entityManagerFactoryRef = "firstEntityManagerFactoryBean",
        transactionManagerRef = "firstTransactionManager")
@EnableTransactionManagement
class PrimaryDataSourceConfig {
    //第一个数据源，可以不加Qualifier
    @Autowired
    private  DataSource dataSource;

    //jpa其他参数配置
    private final JpaProperties jpaProperties;


    //实体管理工厂builder
    private final EntityManagerFactoryBuilder factoryBuilder;

    public PrimaryDataSourceConfig(JpaProperties jpaProperties, EntityManagerFactoryBuilder factoryBuilder) {
        this.jpaProperties = jpaProperties;
        this.factoryBuilder = factoryBuilder;
    }


    /**
     * 配置第一个实体管理工厂的bean
     * @return /
     */
    @Bean(name = "firstEntityManagerFactoryBean")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        return factoryBuilder.dataSource(dataSource)
                //这一行的目的是加入jpa的其他配置参数比如（ddl-auto: update等）
                //当然这个参数配置可以在事务配置的时候也可以
                .properties(jpaProperties.getProperties())
                .packages("com.doney.advanced.jpa.primary")
                .persistenceUnit("firstPersistenceUnit")
                .build();
    }

    /**
     * EntityManager不过解释，用过jpa的应该都了解
     * @return /
     */
    @Bean(name = "firstEntityManager")
    @Primary
    public EntityManager entityManager() {
        return Objects.requireNonNull(entityManagerFactoryBean().getObject()).createEntityManager();
    }

    /**
     * jpa事务管理
     * @return /
     */
    @Bean(name = "firstTransactionManager")
    @Primary
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return jpaTransactionManager;
    }
}

@Configuration
@EntityScan(basePackages = "com.doney.advanced.jpa.primary")
//1、实体扫描
//2、实体管理ref
//3、事务管理
@EnableJpaRepositories(
        basePackages = "com.doney.advanced.jpa.second.repo",
        entityManagerFactoryRef = "secondEntityManagerFactoryBean",
        transactionManagerRef = "secondTransactionManager")
@EnableTransactionManagement
class SecondDataSourceConfig {
    //第一个数据源，可以不加Qualifier
    private final DataSource dataSource;

    //jpa其他参数配置
    private final JpaProperties jpaProperties;


    //实体管理工厂builder
    private final EntityManagerFactoryBuilder factoryBuilder;

    public SecondDataSourceConfig(@Qualifier("secondDatasource") DataSource dataSource, JpaProperties jpaProperties, EntityManagerFactoryBuilder factoryBuilder) {
        this.dataSource = dataSource;
        this.jpaProperties = jpaProperties;
        this.factoryBuilder = factoryBuilder;
    }


    /**
     * 配置第一个实体管理工厂的bean
     * @return /
     */
    @Bean(name = "secondEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        return factoryBuilder.dataSource(dataSource)
                //这一行的目的是加入jpa的其他配置参数比如（ddl-auto: update等）
                //当然这个参数配置可以在事务配置的时候也可以
                .properties(jpaProperties.getProperties())
                .packages("com.doney.advanced.jpa.Second")
                .persistenceUnit("secondPersistenceUnit")
                .build();
    }

    /**
     * EntityManager不过解释，用过jpa的应该都了解
     * @return /
     */
    @Bean(name = "secondEntityManager")
    public EntityManager entityManager() {
        return Objects.requireNonNull(entityManagerFactoryBean().getObject()).createEntityManager();
    }

    /**
     * jpa事务管理
     * @return /
     */
    @Bean(name = "secondTransactionManager")
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return jpaTransactionManager;
    }
}


