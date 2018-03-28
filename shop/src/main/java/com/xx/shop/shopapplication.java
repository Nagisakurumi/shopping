package com.xx.shop;
import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Properties;

@SpringBootApplication
@MapperScan(basePackages = { "com.xx.shop.dao" }, sqlSessionFactoryRef = "sqlSessionFactory")
public class shopapplication {
    public static void main(String [] args)
    {
        SpringApplication.run(shopapplication.class, args);
    }
}
