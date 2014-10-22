package com.gangw.myapp.dele;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import com.gangw.myapp.config.MultiHttpSecurityConfig;

/*AbstractSecurity WebApplicationInitializer

最后一步，我们需要对springSecurityFilterChain定义映射路径。我们很容易通过继承AbstractSecurityWebApplicationInitializer实现，并可以有选择的通过覆盖方法来定制映射。

下面是最基本的配置，它可以接受默认的映射路径，springSecurityFilterChain具有以下的特性：

springSecurityFilterChain映射到了””
springSecurityFilterChain使用ERROR和REQUEST分派类型(dispatch type)
springSecurityFilterChain插入到其它已经配置的servlet过滤器映射(servlet Filter mapping)之前
*/

//public class SecurityWebAppIntializer extends AbstractSecurityWebApplicationInitializer {
//
//	
//	public SecurityWebAppIntializer() {
//		super(MultiHttpSecurityConfig.class);
//		System.out
//				.println("SecurityWebAppIntializer.SecurityWebAppIntializer()");
//	}
//
//}
//上面的代码等同于将这几行代码放在web.xml中：
/**<filter>
	<filter-name>springSecurityFilterChain</filter-name>
	<filter-class>
	  org.springframework.web.filter.DelegatingFilterProxy
	</filter-class>
	</filter>
	<filter-mapping>
	
	<filter-name>springSecurityFilterChain</filter-name>
	<url-pattern>*</url-pattern>
	<dispatcher>ERROR</dispatcher>
	<dispatcher>REQUEST</dispatcher>
	</filter-mapping>
*/