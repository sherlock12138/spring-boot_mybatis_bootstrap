package com.gdut.dongjun.config;

import org.directwebremoting.servlet.DwrServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DwrConfig {

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
		servletRegistrationBean.setServlet(new DwrServlet());
		servletRegistrationBean.setName("dwr-invoker");
		servletRegistrationBean.addUrlMappings("/dwr/*");
		servletRegistrationBean.addInitParameter("activeReverseAjaxEnabled", "true");
		servletRegistrationBean.addInitParameter("debug", "true");
		//servletRegistrationBean.addInitParameter("config-push", "/WEB_INF/dwr.xml");
		return servletRegistrationBean;
	}
}
