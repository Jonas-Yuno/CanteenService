package com.ct.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    //图片存放的电脑磁盘路径
    private String FILE_PATH = "D:/file/canteenImages/upload/";


//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/user/login", "/user/register", "/imserver/**", "/files/**", "/alipay/**",
//                        "/doc.html", "/webjars/**", "/swagger-resources/**","/upload/**","/image/**");
//
//    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //处理前端图片请求 http路径
        //配置拦截器访问静态资源
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + FILE_PATH);//访问存放的电脑磁盘路径里的图片
        registry.addResourceHandler("/image/**").addResourceLocations("classpath:/static/");
        //super.addResourceHandlers(registry);
    }

    public AuthInterceptor authInterceptor(){
        return new AuthInterceptor();
    }

}
