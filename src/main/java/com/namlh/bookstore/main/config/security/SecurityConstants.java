package com.namlh.bookstore.main.config.security;

/**
 * Created by app on 7/13/18.
 */
public class SecurityConstants {

    public static final String SECRET = "BookStoreNamlh";
    public static final long EXPIRATION_TIME = 864_000_000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    public static final String SIGN_UP_URL = "/user/sign-up";
    public static final String SIGN_IN_URL = "/user/login";
}
