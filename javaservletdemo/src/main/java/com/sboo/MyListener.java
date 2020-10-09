package com.sboo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        ApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
        event.getServletContext().setAttribute("applicationContext", context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }
}
