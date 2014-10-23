package com.gangw.myapp.config;

import javax.servlet.Filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/**
 *更新依赖 – 我们已经在前一篇文章中用Maven进行了示范
进行Spring Security配置 – 这个例子中，我们采用WebSecurityConfigurerAdapter
确保Spring Security配置已经被加载了 – 我们采用AbstractAnnotationConfigDispatcherServletInitializer
配置springSecurityFilterChain – 我们采用AbstractSecurityWebApplicationInitializer
 *
 */
@Configuration 
public class DispatcherServletInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	public DispatcherServletInitializer() {
		System.out.println("DispatcherServletInitializer.DispatcherServletInitializer()");
	}
	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[]{MultiHttpSecurityConfig.class,ServiceConfig.class,DaoConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class<?>[]{MvcWebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		return new Filter[]{characterEncodingFilter};
	}

}

/*下一步就是保证ApplicationContext包含我们刚刚定义的HelloWebSecurityConfiguration。有几种方法都可行，我们这里使用Spring的AbstractAnnotationConfigDispatcherServletInitializer：

public class SpringWebMvcInitializer extends
AbstractAnnotationConfigDispatcherServletInitializer {
@Override
protected Class[] getRootConfigClasses() {
return new Class[] { HelloWebSecurityConfiguration.class };
}
...
}
Spring Security通常在web.xml中包含下面几行代码进行初始化：

<!-- Creates the Spring Container shared by all Servlets and Filters -->
<listener>
  <listener-class>
    org.springframework.web.context.ContextLoaderListener
  </listener-class>
</listener>
<!-- Load all Spring XML configuration including our security.xml file -->
<context-param>
  <param-name>contextConfigLocation</param-name>
  <param-value>/WEB-INF/spring.xml</param-value>
</context-param>
*/