package org.jee.cdi.web.servlet.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.List;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.CharEncoding;

import org.jee.cdi.service.context.ContextPath;
import org.jee.cdi.service.context.Cookies;

/**
 * @author Ruslan Isbarov <risbarov@technoserv.com>
 */
@WebServlet(urlPatterns = "/context")
public class ContextInjectionServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Inject
	private ServletContext servletContext;

	@Inject
	private Principal principal;

	@Inject
	private HttpSession httpSession;

	@Inject
	@ContextPath
	private Instance<String> contextPathProvider;

	@Inject
	@Cookies
	private List<Cookie> cookies;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		response.setContentType("text/plain");
		response.setCharacterEncoding(CharEncoding.UTF_8);

		PrintWriter writer = response.getWriter();

		writer.println("Servlet context: " + servletContext.getServerInfo());
		writer.println("User principal: " + principal.getName());
		writer.println("HTTP session: " + httpSession.getId());
		writer.println("Context path: " + contextPathProvider.get());

		cookies.forEach(
			cookie -> writer.println(String.format("Cookie: %s = %s", cookie.getName(), cookie.getValue()))
		);

		writer.flush();
		writer.close();
	}

}
