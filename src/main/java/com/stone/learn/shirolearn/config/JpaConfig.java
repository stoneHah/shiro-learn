package com.stone.learn.shirolearn.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.stone.learn.shirolearn.datasource.DruidProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus配置
 *
 * @author stylefeng
 * @Date 2017/5/20 21:58
 */
@Configuration
//@EnableTransactionManagement
public class JpaConfig {

    @Autowired
    DruidProperties druidProperties;


    /**
     * 另一个数据源
     */
    private DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }

    /**
     * 单数据源连接池配置
     */
    @Bean
    public DruidDataSource singleDatasource() {
        return dataSource();
    }

}
