package com.digiboy.erp.web.filter;

import org.slf4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.digiboy.erp.utils.StreamUtil.enumerationAsStream;

public class HttpRequestLoggingFilter implements Filter {

    private final Logger logger;

    public HttpRequestLoggingFilter(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        logger.info("----------------------------------------------------");
        logger.info("requestURI: {}", req.getRequestURI());
        enumerationAsStream(req.getHeaderNames()).forEach(header -> {
            logger.info("{}: {}", header, req.getHeader(header));
        });
        logger.info("----------------------------------------------------");

        chain.doFilter(request, response);
    }
}
