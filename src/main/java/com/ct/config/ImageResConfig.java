package com.ct.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class ImageResConfig extends WebMvcConfigurationSupport {

    //图片存放的电脑磁盘路径
    private String FILE_PATH = "D:/file/canteenImages/upload/";

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //处理前端图片请求路径
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:" + FILE_PATH);//访问存放的电脑磁盘路径里的图片
        //registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
