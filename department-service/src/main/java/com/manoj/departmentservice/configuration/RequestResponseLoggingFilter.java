//package com.manoj.departmentservice.configuration;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//import org.springframework.web.util.ContentCachingRequestWrapper;
//import org.springframework.web.util.ContentCachingResponseWrapper;
//
//import java.io.IOException;
//
//@Component
//public class RequestResponseLoggingFilter extends OncePerRequestFilter {
//
//    Logger log = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain)
//            throws ServletException, IOException {
//
//        ContentCachingRequestWrapper reqWrapper = new ContentCachingRequestWrapper(request);
//        ContentCachingResponseWrapper resWrapper = new ContentCachingResponseWrapper(response);
//
//        filterChain.doFilter(reqWrapper, resWrapper);
//
//        String body = new String(reqWrapper.getContentAsByteArray(), reqWrapper.getCharacterEncoding());
//        String resp = new String(resWrapper.getContentAsByteArray(), resWrapper.getCharacterEncoding());
//
//        log.info("REQUEST: {} {} Body: {}", request.getMethod(), request.getRequestURI(), body);
//        log.info("RESPONSE: {} Body: {}", response.getStatus(), resp);
//
//        resWrapper.copyBodyToResponse(); // ensure client still gets the body
//    }
//}
