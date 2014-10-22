package com.gangw.myapp.dele;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	//用于配置Authentication，比如LDAP, Database连接，以及用户和角色的查询方法。
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {}
    
    //用于配置URL的保护形式，和login页面。
    @Override
    public void configure(HttpSecurity http) throws Exception {}
   
    //用于配置类似防火墙，放行某些URL。
    @Override
    public void configure(WebSecurity web) throws Exception {
    	super.configure(web);
    }
}
