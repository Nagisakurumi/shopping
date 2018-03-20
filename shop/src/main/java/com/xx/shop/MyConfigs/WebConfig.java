package com.xx.shop.MyConfigs;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "web.config")
public class WebConfig {

    public String getUploadpath() {
        return uploadpath;
    }

    private String uploadpath;
}
