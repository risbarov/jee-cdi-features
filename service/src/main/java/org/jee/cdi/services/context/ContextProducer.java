package org.jee.cdi.services.context;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Ruslan Isbarov <risbarov@technoserv.com>
 */
@RequestScoped
public class ContextProducer {

	@Inject
	private ServletContext servletContext;

	@Inject
	private HttpServletRequest request;

	@Produces
	@ContextPath
	@Dependent
	public String produceContextPath() {
		return servletContext.getContextPath();
	}

	@Produces
	@Cookies
	@RequestScoped
	public List<Cookie> produceCookies() {
		return Arrays.asList(request.getCookies());
	}

}
