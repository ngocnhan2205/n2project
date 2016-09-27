package com.n2.portal.configuration.core;

import com.n2.portal.configuration.database.HibernateConfiguration;
import com.n2.portal.configuration.security.AuthorizationServerConfiguration;
import com.n2.portal.configuration.security.MethodSecurityConfig;
import com.n2.portal.configuration.security.OAuth2SecurityConfiguration;
import com.n2.portal.configuration.security.ResourceServerConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by dhnhan on 9/26/2016.
 */
@Configuration
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackages = "com.n2.portal")
@Import({HibernateConfiguration.class,
        AuthorizationServerConfiguration.class,
        MethodSecurityConfig.class,
        OAuth2SecurityConfiguration.class,
        ResourceServerConfiguration.class})
public class N2Configuration {
}