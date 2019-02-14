package com.libi.config;

import com.libi.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.SQLOutput;

import static com.libi.constant.SecurityConst.*;
/**
 * @author libi
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailServiceImpl userDetailService;

    @Override
    /**
     * 配置整个用户信息从哪里获得
     */
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //TODO 这里使用了内存记录用户的操作，记得修改为数据库操作
        auth.userDetailsService(userDetailService)
                //密码加密 TODO 没有加密
                .passwordEncoder(new PasswordEncoder() {
                    public String encode(CharSequence charSequence) {
                        System.out.println("编码:"+charSequence.toString());
                        return charSequence.toString();
                    }

                    public boolean matches(CharSequence charSequence, String s) {
                        System.out.println("s:"+s);
                        System.out.println("c:"+charSequence.toString());
                        return s.equals(charSequence.toString());
                    }
                });
    }

    @Override
    /**
     * 安全配置的详细信息
     */
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //下面是详细的安全性调整，TODO 还没有完成
                .anyRequest().permitAll()
                //设置登陆请求的URL
                .and().formLogin().loginPage(LOGIN_URL)
                .loginProcessingUrl(LOGIN_URL)
                .successForwardUrl(LOGIN_SUCCESS_URL)
                .failureForwardUrl(LOGIN_FAIL_URL)
                .usernameParameter(USER_NAME_PARAMETER)
                .passwordParameter(PASSWORD_PARAMETER)
                //设置登出
                .and().logout().logoutUrl(LOGOUT_URL)
                .logoutSuccessUrl(LOGOUT_SUCCESS_URL)
                .deleteCookies()
                //TODO 暂时关闭csrf
                .and().csrf().disable();
    }
}
