package com.example.ws.server.config;

import java.lang.reflect.InvocationTargetException;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.servlet.ServletContextListener;
import jakarta.servlet.http.HttpServlet;

@Configuration
public class WsConfig {

    @Bean
    public ServletListenerRegistrationBean<ServletContextListener> wsServletContextListenerRegistrationBean() {
        //var listener = (ServletContextListener)createInstance("com.sun.xml.ws.transport.http.servlet.WSServletContextListener");
        var listener = new com.sun.xml.ws.transport.http.servlet.WSServletContextListener();

        var reg = new ServletListenerRegistrationBean<ServletContextListener>();
        reg.setListener(listener);
        return reg;
    }

    @Bean
    public ServletRegistrationBean<HttpServlet> wsServletRegistrationBean() {
        //var servlet = (HttpServlet)createInstance("com.sun.xml.ws.transport.http.servlet.WSServlet");
        var servlet = new com.sun.xml.ws.transport.http.servlet.WSServlet();

        var reg = new ServletRegistrationBean<HttpServlet>();
        reg.setServlet(servlet);
        reg.addUrlMappings("/services/*");
        reg.setLoadOnStartup(1);
        return reg;
    }

    private Object createInstance(String className) {
        try {
            return Class.forName("com.sun.xml.ws.transport.http.servlet.WSServletContextListener").getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            throw new RuntimeException("create instance failed.", e);
        }
    }
}
