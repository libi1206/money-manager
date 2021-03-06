package com.libi.config;

import com.libi.service.impl.UserDetailServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.libi.constant.SecurityConst.*;
/**
 * @author libi
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailServiceImpl userDetailService;
    private Logger logger = Logger.getLogger(getClass());

    /**
     * 密码编码
     * @return
     */
    @Bean("passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    /**
     * 配置整个用户信息从哪里获得
     */
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService)
                //密码加密
                .passwordEncoder(passwordEncoder());
    }

    @Override
    /**
     * 安全配置的详细信息
     */
    protected void configure(final HttpSecurity http) throws Exception {
        http    //下面是详细的安全性调整
                .authorizeRequests()
                    //登录界面不限制，登出和查询用户界面需要登录才能访问
                    .antMatchers(LOGIN_URL).permitAll()
                    .antMatchers(EXCEPTION_URL+"/**").permitAll()
                    .antMatchers(LOGOUT_URL,LOGIN_URL+"/**").authenticated()
                    .antMatchers(ASSETS_URL+"/**").authenticated()
                    .antMatchers(FAMILY_URL+"/**").authenticated()
                    .antMatchers("/user/uploadHead").authenticated()

                //设置登陆请求的URL
                .and().formLogin()
                .loginProcessingUrl(LOGIN_URL)
                .successForwardUrl(LOGIN_SUCCESS_URL)
                .failureForwardUrl(LOGIN_FAIL_URL)
                .usernameParameter(USER_NAME_PARAMETER)
                .passwordParameter(PASSWORD_PARAMETER)
                //设置登出
                .and().logout().logoutUrl(LOGOUT_URL)
                .logoutSuccessUrl(LOGOUT_SUCCESS_URL)
                .deleteCookies("JSESSIONID")
                //设置拒绝时候的url
                .and().exceptionHandling().accessDeniedPage("/error/403")
                //设置未登录的操作
                .and().exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint() {
                    @Override
                    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        if (httpServletRequest.getCookies()!=null && httpServletRequest.getCookies().length > 0) {
                            logger.info("未登录的cookie:" + httpServletRequest.getCookies()[0].getName()+":"+httpServletRequest.getCookies()[0].getValue());
                        }
                        logger.info("未登录访问的URI："+httpServletRequest.getRequestURI()+" 方法："+httpServletRequest.getMethod());
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
                        String sb = "{\"code\":10002,\"message\":\"未登录\",\"data\":null}";
                        out.write(sb);
                        out.flush();
                        out.close();
                    }
                })
                //TODO 暂时关闭csrf
                .and().csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

}
