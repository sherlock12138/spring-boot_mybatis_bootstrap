package com.gdut.dongjun;

import java.beans.PropertyVetoException;
import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.ClassUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	@Bean
	public DataSource dataSource() {

		com.mchange.v2.c3p0.ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/elecon?useUnicode=true&amp;charaterEncoding=utf-8");
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
