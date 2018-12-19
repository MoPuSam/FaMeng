package com.oulam.entry;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;


/**
 * 程序入口
 */
@Component
@Configuration
@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
//自动引入当前包下的service,component....
@ComponentScan("com.oulam")//扫描 @Controller、@Service 注解；
@SpringBootApplication
@EnableScheduling   //启动定时任务
@MapperScan("com.oulam.dao")//将项目中对应的mapper类的路径加进来就可以了
@EntityScan(basePackages = "com.oulam.bean")//扫描 @Entity 注解；
public class Entry {
    private static final Logger log = LoggerFactory.getLogger(Entry.class);

    public static void main(String[] args) {
        log.info("Start ScheduleApplicationWithAnnotation.. ");
        SpringApplication.run(Entry.class, args);
    }

}
