package com.gangw.myapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.acls.AclPermissionCacheOptimizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
@Configuration
@DependsOn("aclServiceConfig")
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled=true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration{
	
	public MethodSecurityConfig() {
		System.out.println("GlobalMethodSecurityConfig.MethodSecurityConfig()");
	}
	@Autowired
	DaoConfig daoConfig;
	
	
	@Autowired
	AclServiceConfig aclServiceConfig;
	// ~ Method SECURITY DEFINITONS=========================================================
	
//	@Autowired(required = false)
//	public void setPermissionEvaluator(
//			List<PermissionEvaluator> permissionEvaluators) {
//		super.setPermissionEvaluator(permissionEvaluators);
//	}

	@Override
	protected MethodSecurityExpressionHandler createExpressionHandler() {
		return methodSecurityExpressionHandler();
	}
	
	
	@Bean(name="expressionHandler")
	public DefaultMethodSecurityExpressionHandler methodSecurityExpressionHandler() {
		DefaultMethodSecurityExpressionHandler methodSecurityExpressionHandler = new DefaultMethodSecurityExpressionHandler();
		methodSecurityExpressionHandler.setPermissionCacheOptimizer(new AclPermissionCacheOptimizer(aclServiceConfig.jdbcMutableAclService()));
		return methodSecurityExpressionHandler;
	}
	
	
	
	

	// ~ ACL SERVICE DEFINITONS=============================================================

	
}
