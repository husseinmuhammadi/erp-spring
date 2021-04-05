package com.digiboy.erp.web.config;

import com.digiboy.erp.web.filter.HttpRequestLoggingFilter;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {

    private final Logger logger;

    public WebConfiguration(Logger logger) {
        this.logger = logger;
    }

    @Bean
    public FilterRegistrationBean<HttpRequestLoggingFilter> loggingFilter(){
        FilterRegistrationBean<HttpRequestLoggingFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new HttpRequestLoggingFilter(logger));
        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }
}
