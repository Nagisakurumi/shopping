package com.xx.shop;
import com.github.pagehelper.PageHelper;
import com.xx.shop.service.Impl.RedisServiceImpl;
import com.xx.shop.service.RedisService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Properties;

@SpringBootApplication
@MapperScan(basePackages = { "com.xx.shop.dao" }, sqlSessionFactoryRef = "sqlSessionFactory")
public class shopapplication {


    private static RedisService<Object> redisService = new RedisServiceImpl<Object>();

    public static void main(String [] args)
    {
        SpringApplication.run(shopapplication.class, args);

        redisService.put("test", "value", -1);
        System.out.println(redisService.get("test"));
    }
}
