package com.gangw.myapp.dele;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 进行Spring Security配置 – 这个例子中，我们采用WebSecurityConfigurerAdapter 确保Spring
 * Security配置已经被加载了 – 我们采用AbstractAnnotationConfigDispatcherServletInitializer
 * 配置springSecurityFilterChain – 我们采用AbstractSecurityWebApplicationInitializer
 */

//@Configuration
//@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	public CustomWebSecurityConfigurerAdapter() {
		System.out
				.println("CustomWebSecurityConfigurer.CustomWebSecurityConfigurer()");
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("user") // #1
				.password("password").roles("USER").and().withUser("admin") // #2
				.password("password").roles("ADMIN", "USER");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**"); // #3
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/signup", "/about").permitAll() // #4
				.antMatchers("/admin/**").hasRole("ADMIN") // #6
				.anyRequest().authenticated() // #7
				.and().formLogin() // #8
				.loginPage("/login") // #9
				.permitAll(); // #5
	}
}

/**
 * 功能:

	#1 可以在内存中的验证(memory authentication)叫作”user”的用户
	#2 可以在内存中的验证(memory authentication)叫作”admin”的管理员用户
	#3 忽略任何以”/resources/”开头的请求，这和在XML配置http@security=none的效果一样
	#4 任何人(包括没有经过验证的)都可以访问”/signup”和”/about”
	#5 任何人(包括没有经过验证的)都可以访问”/login”和”/login?error”。permitAll()是指用户可以访问formLogin()相关的任何URL。
	#6 “/admin/”开头的URL必须要是管理员用户，譬如”admin”用户
	#7 所有其他的URL都需要用户进行验证
	#8 使用Java配置默认值设置了基于表单的验证。使用POST提交到”/login”时，需要用”username”和”password”进行验证。
	#9 注明了登陆页面，意味着用GET访问”/login”时，显示登陆页面
*/






//上面的代碼相當於在以下xml的配置，不过有几个特殊配置：

/*
 * Spring Security会生成一个登陆页面，验证失败页面和登出成功页面 login-processing-url仅仅处理HTTP POST
 * login-page仅仅通过HTTP GET进入 <http use-expressions="true"> <intercept-url
 * pattern="/**" access="authenticated"/> <logout
 * logout-success-url="/login?logout" logout-url="/logout" /> <form-login
 * authentication-failure-url="/login?error" login-page="/login"
 * login-processing-url="/login" password-parameter="password"
 * username-parameter="username" /> </http> <authentication-manager>
 * <authentication-provider> <user-service> <user name="user"
 * password="password" authorities="ROLE_USER"/> </user-service>
 * </authentication-provider> </authentication-manager>
 */
