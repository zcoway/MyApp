package com.gangw.myapp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
@Configuration
public class DaoConfig {
	
	
	@Bean
	public JndiObjectFactoryBean jndiObjectFactoryBean(){
		JndiObjectFactoryBean jndi = new JndiObjectFactoryBean();
		jndi.setJndiName("java:comp/env/jdbc/cfds");
		return jndi;
	}
	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean(){
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		Properties pros = sessionFactory.getHibernateProperties();
		pros.put("hibernate.show_sql", true);
		pros.put("hibernate.format_sql", true);
		sessionFactory.setDataSource((DataSource)jndiObjectFactoryBean().getObject());
		return sessionFactory;
	} 
	@Bean
	public HibernateTemplate hibernateTemplate(){
		return new HibernateTemplate(localSessionFactoryBean().getObject());
	}
}
