package com.libi.config;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * @author libi
 * 切面配置
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.libi"})
public class AspectConfig {
    @Bean
    public Advice advice() {
        return new Advice();
    }
}

@Aspect
class Advice{
    private Logger logger = Logger.getLogger(this.getClass());

    @Pointcut("execution(* com.libi.controller.*.*(..))" +
            "&& args(..,request)")
    public void controller(HttpServletRequest request) {

    }

    @Before("controller(request)")
    public void printIpAndUri(HttpServletRequest request) {
        logger.info(request.getMethod()+"访问URI:"+request.getRequestURI()+" SessionID:"+request.getSession().getId());
    }

}
