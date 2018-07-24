package com.namlh.bookstore.main.config.security;

import com.namlh.bookstore.utils.Params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static com.namlh.bookstore.utils.Params.PL_PASSWORD;
import static com.namlh.bookstore.utils.Params.PL_USERNAME;

/**
 * Created by app on 7/24/18.
 */
public class AdminSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

    private static final String SIGN_IN_ADMIN_PATH = Params.ADMIN_PATH + Params.LOGIN_PATH;
    private static final String SIGN_OUT_ADMIN_PATH = Params.ADMIN_PATH + Params.LOGOUT_PATH;

    @Autowired
    private AuthSuccessHandler authSuccessHandler;

    @Autowired
    private AuthFailureHandler authFailureHandler;

    @Autowired
    private SignOutSuccessHandler logoutSuccessHandler;

    public AdminSecurityConfigurationAdapter() {
        super();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .antMatcher(Params.ADMIN_PATH)
                .authorizeRequests()
                .anyRequest()
                .access("@permissionChecker.checkCurrentUserIsAdmin()")

                .and()
                .formLogin()
                .loginProcessingUrl(SIGN_IN_ADMIN_PATH)
                .usernameParameter(PL_USERNAME)
                .passwordParameter(PL_PASSWORD)
                .successHandler(authSuccessHandler)
                .failureHandler(authFailureHandler)

                .and()
                .logout()
                .deleteCookies("JSESSIONID", "SESSION")
                .permitAll()
                .logoutRequestMatcher(
                        new AntPathRequestMatcher(SIGN_OUT_ADMIN_PATH, "GET"))
                .logoutSuccessHandler(logoutSuccessHandler)

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
