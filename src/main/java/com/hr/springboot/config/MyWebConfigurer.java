package com.hr.springboot.config;

import com.hr.springboot.interceptor.LoginInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootConfiguration
public class MyWebConfigurer implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor getLoginIntercepter() {
        return new LoginInterceptor();
    }

//    删了删了
//    @Override
//    public void addInterceptors(InterceptorRegistry registry){
//        //添加 自定义拦截器
//        registry.addInterceptor(getLoginIntercepter())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/index.html") //拦截除index.html外的请求，
//                .excludePathPatterns("/api/login")
//                .excludePathPatterns("/api/register")
//                .excludePathPatterns("/api/logout");
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*这个 URL 的前缀是我们自己构建的，还需要把它跟我们设置的图片资源文件夹，即 D:/img 对应起来。*/
        registry.addResourceHandler("/file/**").addResourceLocations("file:" + "d:/img/");
    }

    /**
     * 跨域配置
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("http://localhost:8080")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowedHeaders("*");
    }
}
