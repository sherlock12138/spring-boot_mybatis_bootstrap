package com.gdut.dongjun.util;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class FilterUtils {

	private static ApplicationContext ctx = null;
	
	public static Object getBeans(HttpServletRequest req, String name) {
		if (ctx == null) {
			ctx = WebApplicationContextUtils
					.getRequiredWebApplicationContext(req.getSession()
							.getServletContext());
		}
		return ctx.getBean(name);
	}
}
