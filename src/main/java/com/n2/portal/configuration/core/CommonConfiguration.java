package com.n2.portal.configuration.core;

import com.n2.portal.core.MessageI18N;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by buibichngoc on 1/2/2017.
 */
@Configuration
public class CommonConfiguration {

    @Bean
    public MessageI18N messageI18N() {
        return new MessageI18N();
    }
}
