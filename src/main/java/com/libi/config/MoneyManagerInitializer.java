package com.libi.config;

import org.apache.log4j.Logger;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.libi.constant.DataBaseConst.*;

/**
 * @author libi
 */
public class MoneyManagerInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    private Logger logger = Logger.getLogger(getClass());

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 在这里设置Multi-Part的详细配置
     * 也可以使用web.xml来配置
     * @param registration
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement(FILE_LOCATION,MAX_FILE_SIZE,MAX_REQUEST_SIZE,FILE_SIZE_THRESHOLD)
        );
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
                logger.info(request.getMethod()+"访问URI:"+request.getRequestURI()+" SessionID:"+request.getSession().getId());
                filterChain.doFilter(request,response);
            }
        }};
    }
}
