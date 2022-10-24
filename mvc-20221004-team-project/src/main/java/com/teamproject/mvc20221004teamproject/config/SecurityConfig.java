package com.teamproject.mvc20221004teamproject.config;

import com.teamproject.mvc20221004teamproject.securiry.AuthFailureHandler;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configurable
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

//        security 로그인 페이지 사용 안하겠다
        http.httpBasic().disable();

//        모든 요청이 들어오면
        http.authorizeRequests()

//              사용자가 지정한 주소에 요청이 들어오면
                .antMatchers("/mypage/index", "/order/cart")

//              인증을 걸쳐라 (위 url로 접속 하여도 로그인 페이지로 이동됨)
                .authenticated()


//              다른 모든 요청들은
                .anyRequest()

//              권한을 허용 하여라
                .permitAll()

//              그리고
                .and()

//              form태그를 이용한 로그인 지원
                .formLogin()

//              사용자가 따로 만든 로그인 페이지를 사용하려고 할때 설정
                .loginPage("/account/login")                //login page Get 요청
                .loginProcessingUrl("/account/login")       //login service Post요청

//              정상적으로 인증성공 했을 경우 이동하는 페이지 설정
                .defaultSuccessUrl("/main/index");
    }

}

