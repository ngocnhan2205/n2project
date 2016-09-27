package com.n2.portal;

import com.n2.portal.configuration.core.N2Configuration;
import com.n2.portal.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by dhnhan on 9/27/2016.
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(N2Configuration.class);
        UserService userService = config.getBean(UserService.class);
        System.out.println(userService.findBySso("admin"));
    }
}
