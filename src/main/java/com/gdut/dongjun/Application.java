package com.gdut.dongjun;

import java.beans.PropertyVetoException;
import java.io.IOException;

import javax.sql.DataSource;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.jdbc.JdbcRealm.SaltStyle;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(Application.class);

		// .child(Application.class)
	}

	/**
	 * 
	 * @Title: dataSource
	 * @Description: TODO
	 * @param @return
	 * @return DataSource
	 * @throws
	 */
	@Bean
	public DataSource dataSource() {

		com.mchange.v2.c3p0.ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/ele?useUnicode=true&amp;charaterEncoding=utf-8");
		ds.setUser("root");
		ds.setPassword("33132212");
		try {
			ds.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ds.setAcquireIncrement(5);
		ds.setInitialPoolSize(10);
		ds.setMinPoolSize(5);
		ds.setMaxPoolSize(60);
		ds.setMaxIdleTime(120);
		return ds;
	}

	/**
	 * 
	 * @Title: sessionFactory
	 * @Description: TODO
	 * @param @return
	 * @return SqlSessionFactoryBean
	 * @throws
	 */
	@Bean
	public SqlSessionFactoryBean sessionFactory() {

		SqlSessionFactoryBean sFactoryBean = new SqlSessionFactoryBean();
		sFactoryBean.setDataSource(dataSource());

		String packageSearchPath = "classpath*:com/gdut/dongjun/domain/dao/**/*.xml";
		Resource[] resources = null;
		try {
			resources = new PathMatchingResourcePatternResolver()
					.getResources(packageSearchPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sFactoryBean.setMapperLocations(resources);
		sFactoryBean.setTypeAliasesPackage("com.gdut.dongjun.domain.po");

		return sFactoryBean;
	}

	/**
	 * 
	 * @Title: sessionTemplate
	 * @Description: TODO
	 * @param @return
	 * @return SqlSessionTemplate
	 * @throws
	 */
	@Bean(name = "msg_sqlSessionTemplate")
	public SqlSessionTemplate sessionTemplate() {

		SqlSessionTemplate sst = null;
		try {
			sst = new SqlSessionTemplate(sessionFactory().getObject());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sst;
	}

	/**
	 * 
	 * @Title: characterEncodingFilter
	 * @Description: TODO
	 * @param @return
	 * @return CharacterEncodingFilter
	 * @throws
	 */
	@Bean
	public CharacterEncodingFilter characterEncodingFilter() {

		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		return filter;
	}

	/**
	 * 
	 * @Title: registerCharacterEncodingFilter
	 * @Description: TODO
	 * @param @return
	 * @return FilterRegistrationBean
	 * @throws
	 */
	@Bean
	public FilterRegistrationBean registerCharacterEncodingFilter() {

		FilterRegistrationBean chafil = new FilterRegistrationBean();
		chafil.setFilter(characterEncodingFilter());
		chafil.addUrlPatterns("/*");
		return chafil;
	}

	/**
	 * 
	 * @Title: environmentLoaderListener
	 * @Description: TODO
	 * @param @return
	 * @return EnvironmentLoaderListener
	 * @throws
	 */
	// @Bean
	// public EnvironmentLoaderListener environmentLoaderListener() {
	//
	// return new EnvironmentLoaderListener();
	// }

	/**
	 * 
	 * @Title: shiroFilterFactoryBean
	 * @Description: TODO
	 * @param @return
	 * @return ShiroFilterFactoryBean
	 * @throws
	 */
	// @Bean(name = "shiroFilter")
	// public ShiroFilter shiroFilter() {
	//
	// // Map<String, Filter> filters = new HashMap<>();
	// ShiroFilter shiroFilter = new ShiroFilter();
	//
	// shiroFilter.setSecurityManager(defaultWebSecurityManager());
	// shiroFilter.setFilterConfig();
	//

	// // shiroFilterFactoryBean.setFilterChainDefinitions("/n = authc,");
	// // // shiroFilterFactoryBean.setFilters(filters);
	// //
	// shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager());
	// return shiroFilterFactoryBean;
	// }

	/**
	 * @throws ServletException
	 * 
	 * @Title: delegatingFilterProxy
	 * @Description: TODO
	 * @param @return
	 * @return DelegatingFilterProxy
	 * @throws
	 */
	// @Bean
	// public DelegatingFilterProxy delegatingFilterProxy() throws
	// ServletException {
	//
	// DelegatingFilterProxy proxy = new DelegatingFilterProxy();
	// proxy.setTargetFilterLifecycle(true);
	// proxy.init(new FilterConfig() {
	//
	// @Override
	// public ServletContext getServletContext() {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public Enumeration<String> getInitParameterNames() {
	// // TODO Auto-generated method stub
	// return "targetFilterLifecycle";
	// }
	//
	// @Override
	// public String getInitParameter(String name) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public String getFilterName() {
	// // TODO Auto-generated method stub
	// return null;
	// }
	// });
	// proxy.setBeanName("shiroFilter");
	// return proxy;
	// }

	/**
	 * 
	 * @Title: registerShiroFilter
	 * @Description: TODO
	 * @param @return
	 * @return FilterRegistrationBean
	 * @throws
	 */
	// @Bean
	// public FilterRegistrationBean registerShiroFilter() {
	//
	// FilterRegistrationBean chafil = new FilterRegistrationBean();
	// chafil.setFilter(delegatingFilterProxy());
	// chafil.addUrlPatterns("/*");
	// return chafil;
	// }
//	@Bean
//	public EnvironmentLoaderListener listen() {
//
//		return new EnvironmentLoaderListener();
//	}

	// **************************************************************
	// web.xml shiro filter config end

	/**
	 * 
	 * @Title: defaultAdvisorAutoProxyCreator
	 * @Description: TODO
	 * @param @return
	 * @return DefaultAdvisorAutoProxyCreator
	 * @throws
	 */
	@Bean
	@DependsOn("lifecycleBeanPostProcessor")
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {

		return new DefaultAdvisorAutoProxyCreator();
	}

	/**
	 * 
	 * @Title: lifecycleBeanPostProcessor
	 * @Description: TODO
	 * @param @return
	 * @return LifecycleBeanPostProcessor
	 * @throws
	 */
	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {

		return new LifecycleBeanPostProcessor();
	}

	/**
	 * 
	 * @Title: AuthorizationAttributeSourceAdvisor
	 * @Description: TODO
	 * @param @return
	 * @return AuthorizationAttributeSourceAdvisor
	 * @throws
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor AuthorizationAttributeSourceAdvisor() {

		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(defaultWebSecurityManager());
		return advisor;
	}

	/**
	 * 
	 * @Title: ShiroFilterFactoryBean
	 * @Description: TODO
	 * @param @return
	 * @return ShiroFilterFactoryBean
	 * @throws
	 */
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean ShiroFilterFactoryBean() {

		ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
		factoryBean.setSecurityManager(defaultWebSecurityManager());
		factoryBean
				.setFilterChainDefinitions("/dongjun/* = authc");
//
		factoryBean.setLoginUrl("/dongjun/login");
//		factoryBean.setSuccessUrl("index");
//		factoryBean.setUnauthorizedUrl("unauthorized");
		return factoryBean;
	}

	/**
	 * 
	 * @Title: defaultWebSecurityManager
	 * @Description: TODO
	 * @param @return
	 * @return DefaultWebSecurityManager
	 * @throws
	 */
	@Bean
	public DefaultWebSecurityManager defaultWebSecurityManager() {

		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(jdbcAuthenticationRealm());
		return manager;
	}

	/**
	 * 
	 * @Title: jdbcAuthenticationRealm
	 * @Description: TODO
	 * @param @return
	 * @return JdbcRealm
	 * @throws
	 */
	@Bean
	public JdbcRealm jdbcAuthenticationRealm() {

		JdbcRealm realm = new JdbcRealm();

		HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
		SimpleCredentialsMatcher matcher = new SimpleCredentialsMatcher();

		credentialsMatcher.setHashAlgorithmName("SHA-256");
		realm.setDataSource(dataSource());
		realm.setCredentialsMatcher(matcher);
		realm.setAuthenticationCacheName("shiro.authorizationCache");
		realm.setAuthenticationQuery("select password from user where name = ?");
		realm.setSaltStyle(SaltStyle.NO_SALT);
		realm.setUserRolesQuery("select r.role from role r, user_role ur,user u where u.name = ? and ur.role_id = r.id and ur.user_id = u.id");
		realm.setPermissionsQuery("select p.permission from role r,role_permission rp, permission p where r.role = ? and rp.role_id = r.id and rp.permission_id = p.id");
		realm.setPermissionsLookupEnabled(true);
		return realm;
	}

	public static void main(String[] args) throws Exception {

		SpringApplication.run(Application.class, args);

	}

	// @Bean
	// public String test() {
	//
	// com.mchange.v2.c3p0.ComboPooledDataSource ds = new
	// ComboPooledDataSource();
	// ds.setJdbcUrl("jdbc\\:mysql\\://localhost\\:3306/elecon");
	// ds.setUser("root");
	// ds.setPassword("33132212");
	// try {
	// ds.setDriverClass("com.mysql.jdbc.Driver");
	// } catch (PropertyVetoException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// ds.setAcquireIncrement(5);
	// ds.setInitialPoolSize(10);
	// ds.setMinPoolSize(5);
	// ds.setMaxPoolSize(60);
	// ds.setMaxIdleTime(120);
	// return "";
	// }

	// @Bean
	// public FilterRegistrationBean registration() {
	// Filter filter = new
	// org.springframework.web.filter.DelegatingFilterProxy();
	// try {
	// filter.init(new FilterConfig() {
	//
	// @Override
	// public ServletContext getServletContext() {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public Enumeration<String> getInitParameterNames() {
	// // TODO Auto-generated method stub
	// Vector<String> vector = new Vector<String>();
	// vector.add("targetFilterLifecycle");
	// Enumeration<String> enumeration = vector.elements();
	// return enumeration;
	// }
	//
	// @Override
	// public String getInitParameter(String name) {
	// // TODO Auto-generated method stub
	//
	// if (name.equals("targetFilterLifecycle"))
	// return "true";
	// else
	// return null;
	// }
	//
	// @Override
	// public String getFilterName() {
	// // TODO Auto-generated method stub
	// return "shiroFilter";
	// }
	// });
	// } catch (ServletException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// FilterRegistrationBean registration = new FilterRegistrationBean(filter);
	// registration.setEnabled(true);
	// return registration;
	// }

}
