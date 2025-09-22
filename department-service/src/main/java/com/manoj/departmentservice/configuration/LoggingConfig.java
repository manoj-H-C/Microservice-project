//package com.manoj.departmentservice.configuration;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.web.filter.CommonsRequestLoggingFilter;
//
//@Configuration
//public class LoggingConfig {
//
//    @Bean
//    public CommonsRequestLoggingFilter logFilter() {
//        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
//        filter.setIncludeQueryString(true);
//        filter.setIncludePayload(true);
//        filter.setMaxPayloadLength(10_000);
//        filter.setIncludeHeaders(true);
//        filter.setAfterMessagePrefix("REQUEST DATA : ");
//        return filter;
//    }
//
//    @Bean
//    public FilterRegistrationBean<CommonsRequestLoggingFilter> loggingFilter() {
//        FilterRegistrationBean<CommonsRequestLoggingFilter> registration = new FilterRegistrationBean<>();
//        registration.setFilter(logFilter());
//        registration.setOrder(Ordered.HIGHEST_PRECEDENCE); // very early
//        return registration;
//    }
//}