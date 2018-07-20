package com.namlh.bookstore.main.config.permission;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;

/**
 * Created by app on 7/20/18.
 */
public class PermissionSecurityExpressionRoot extends SecurityExpressionRoot
        implements MethodSecurityExpressionOperations {


    private static final Logger logger = LoggerFactory.getLogger(PermissionSecurityExpressionRoot.class);

    private Authentication authentication;

    /**
     * Creates a new instance
     *
     * @param authentication the {@link Authentication} to use. Cannot be null.
     */
    public PermissionSecurityExpressionRoot(Authentication authentication) {
        super(authentication);
        this.authentication = authentication;
    }

    private Object filterObject;
    private Object returnObject;
    private Object target;

    @Override
    public void setFilterObject(Object filterObject) {
        this.filterObject = filterObject;
    }

    @Override
    public Object getFilterObject() {
        return filterObject;
    }

    @Override
    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    @Override
    public Object getReturnObject() {
        return returnObject;
    }

    public void setThis(Object target) {
        this.target = target;
    }

    @Override
    public Object getThis() {
        return target;
    }
}
