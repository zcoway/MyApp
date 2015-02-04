package com.gangw.myapp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.AnnotationTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * Dao配置类，主要用于配置DAO层相关的组件
 * @author 甘国威
 */
//@ImportResource(value = { "classpath:myApp-dao.xml" })
//@PropertySource("classpath:/com/gangw/myapp/config/dao.properties")

@Configuration
@ComponentScan(basePackages = {"com.gangw.myapp.dao"})
public class DaoConfig {
	
//	@Autowired
//  Environment env;
	
	

	
	//----------------------配置事物----------------------------------------------
	
	
	/**
	 * <tx:tags/> as simply defining TransactionProxyFactoryBean beans 
	 * <tx:advice
	 */
	@Bean
	public TransactionInterceptor transactionInterceptor(){
		TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
		transactionInterceptor.setTransactionManager(hibernateTransactionManager());
		transactionInterceptor.setTransactionAttributeSource( new AnnotationTransactionAttributeSource());
		return transactionInterceptor;
	}
	
	@Bean
	@DependsOn("jndiObjectFactoryBean")
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		return advisorAutoProxyCreator;
	}
	
	@Bean
	public AspectJExpressionPointcut aspectJExpressionPointcut(){
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
//		pointcut.setExpression(env.getProperty("serviceExpressionPoint"));
		pointcut.setExpression("execution(* com.gangw.myapp.service..*Impl.*(..))");
		return pointcut;
	}
	
	@Bean
	public DefaultPointcutAdvisor defaultPointcutAdvisor(){
		DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
		advisor.setPointcut(aspectJExpressionPointcut());
		advisor.setAdvice(transactionInterceptor());
		return advisor;
	}
	
	@Bean(name="transactionManager")
	public HibernateTransactionManager hibernateTransactionManager(){
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(localSessionFactoryBean().getObject());
		return txManager;
	}
	
	//-------------------------------------
	//DataSource bean
	@Bean
	public JndiObjectFactoryBean jndiObjectFactoryBean(){
		JndiObjectFactoryBean jndi = new JndiObjectFactoryBean();
		jndi.setJndiName("java:comp/env/jdbc/cfds");
		return jndi;
	}
	//SessionFactoryBean bean 负责创建SessionFactory
	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean(){
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		Properties pros = sessionFactory.getHibernateProperties();
		pros.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
		pros.put("hibernate.show_sql", true);
		pros.put("hibernate.format_sql",true);
		sessionFactory.setDataSource((DataSource)jndiObjectFactoryBean().getObject());
		return sessionFactory;
	}
	
	@Bean
	public HibernateTemplate hibernateTemplate(){
		return new HibernateTemplate(localSessionFactoryBean().getObject());
	}
	
}
