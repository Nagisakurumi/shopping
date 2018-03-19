package com.xx.shop;
import com.github.pagehelper.PageHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Properties;

@SpringBootApplication
@ComponentScan(basePackages = {"com.xx"})
public class shopapplication {
    public static void main(String [] args)
    {
        SpringApplication.run(shopapplication.class, args);
    }
}
