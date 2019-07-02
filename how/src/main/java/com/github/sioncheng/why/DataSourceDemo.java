package com.github.sioncheng.why;


import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class DataSourceDemo {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("data-source-demo.xml");


        showBeans(applicationContext);
    }

    @Bean(destroyMethod = "close")
    public DataSource dataSource() throws Exception {
        Properties properties = new Properties();

        return BasicDataSourceFactory.createDataSource(properties);
    }

    private static void showBeans(ApplicationContext context) {
        System.out.println(Arrays.asList(context.getBeanDefinitionNames()));
    }
}
