package com.n2.portal.utils;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by buibichngoc on 1/2/2017.
 */
public class MessageI18N {
    private Properties properties;
    private static final String FILE_MESSAGE = "message-vn.properties";
    private static Logger log = Logger.getLogger(MessageI18N.class);

    public MessageI18N() {
        this.properties = new Properties();
        try {
            log.info("MessageI18N load file messge " + FILE_MESSAGE);
            this.properties.load(MessageI18N.class.getClassLoader().getResourceAsStream(FILE_MESSAGE));
        } catch (IOException e) {
            log.error("MessageI18N load file failed " + e.getMessage());
        }
    }

    public String getKey(String key) {
        return this.properties.getProperty(key);
    }
}
