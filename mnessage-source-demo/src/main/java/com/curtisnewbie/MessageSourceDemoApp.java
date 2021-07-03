package com.curtisnewbie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;

import java.util.Locale;

@SpringBootApplication
public class MessageSourceDemoApp {

    private static final Logger logger = LoggerFactory.getLogger(MessageSourceDemoApp.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MessageSourceDemoApp.class, args);
        MessageSource messageSource = context.getBean(MessageSource.class);
        String msgForCh = messageSource.getMessage("my-message", null, Locale.SIMPLIFIED_CHINESE);
        logger.info("my-message with locale ch: {}", msgForCh);
        String msgForUk = messageSource.getMessage("my-message", null, Locale.UK);
        logger.info("my-message with locale uk: {}", msgForUk);

        String custMsgForCh = messageSource.getMessage("custom-message", new Object[]{"yongj.zhuang"}, Locale.SIMPLIFIED_CHINESE);
        logger.info("custom-message with locale ch: {}", custMsgForCh);
        String custMsgForUk = messageSource.getMessage("custom-message", new Object[]{"yongj.zhuang"}, Locale.UK);
        logger.info("custom-message with locale uk: {}", custMsgForUk);

    }

}
