package com.namlh.bookstore.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by app on 7/13/18.
 */
@Configuration
public class ApiHandlerConfiguration extends WebMvcConfigurerAdapter {

    @Resource
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    @PostConstruct
    public void init() {
        List<HandlerMethodReturnValueHandler> handlers =
                new ArrayList<>(requestMappingHandlerAdapter.getReturnValueHandlers());
        handlers.add(0, observableReturnValueHandler());
        requestMappingHandlerAdapter.setReturnValueHandlers(handlers);
    }

    @Bean
    public HandlerMethodReturnValueHandler observableReturnValueHandler() {
        return new ObservableReturnValueHandler();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .exposedHeaders("Authorization")
                .allowCredentials(false).maxAge(7200);
    }
}
