package com.xx.shop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.xx"})
public class shopapplication {
    public static void main(String [] args)
    {
        SpringApplication.run(shopapplication.class, args);
    }
}
