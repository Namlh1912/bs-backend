package com.namlh.bookstore.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by app on 7/9/18.
 */
@SpringBootApplication(scanBasePackages = { "com.namlh.bookstore.main" })
public class BookstoreApplication {

    public static void main(String [] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }
}
