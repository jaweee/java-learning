package com.jaweee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2022/5/29 21:31
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
@Configuration(proxyBeanMethods = false)
public class WebConfig {

    /**
     * 第一种个性化配置
     * @return
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            /**
             * Help with configuring {@link HandlerMapping} path matching options such as
             * whether to use parsed {@code PathPatterns} or String pattern matching
             * with {@code PathMatcher}, whether to match trailing slashes, and more.
             *
             * @param configurer
             * @see PathMatchConfigurer
             * @since 4.0.3
             */
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                // 不移除分号，这样才能使用matrixvariable
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }
        };
    }

//    第二种实现方式，在配置类中实现下面这个接口的configurePathMatch方法
//    implements WebMvcConfigurer
//
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        UrlPathHelper urlPathHelper = new UrlPathHelper();
//        //
//        urlPathHelper.setRemoveSemicolonContent(false);
//        configurer.setUrlPathHelper(urlPathHelper);
//    }
}
