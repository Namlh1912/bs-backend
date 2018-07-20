package com.namlh.bookstore.main.config.permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * Created by app on 7/20/18.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfiguration extends GlobalMethodSecurityConfiguration {

    @Autowired
    private ApplicationContext context;

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        PermissionMethodSecurityExpressionHandler handler =
                new PermissionMethodSecurityExpressionHandler();
        handler.setPermissionEvaluator(new CustomPermissionEvaluator());
        handler.setApplicationContext(context);
        return handler;
    }
}
