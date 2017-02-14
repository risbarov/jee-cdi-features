package org.jee.cdi.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Ruslan Isbarov <risbarov@technoserv.com>
 */
@WebFilter(urlPatterns = "/*")
public class CharacterEncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {

		if (StringUtils.startsWith(request.getContentType(), "text/")) {
			request.setCharacterEncoding(CharEncoding.UTF_8);
			response.setCharacterEncoding(CharEncoding.UTF_8);
		}

		chain.doFilter(request, response);
	}
}
