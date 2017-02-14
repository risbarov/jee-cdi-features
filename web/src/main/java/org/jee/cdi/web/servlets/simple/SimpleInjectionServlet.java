package org.jee.cdi.web.servlets.simple;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.CharEncoding;

import org.jee.cdi.services.simple.SimpleApplicationScopedBean;
import org.jee.cdi.services.simple.SimpleRequestScopedBean;

/**
 * @author Ruslan Isbarov <risbarov@technoserv.com>
 */
@WebServlet(urlPatterns = "/simple")
public class SimpleInjectionServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Inject
	private SimpleRequestScopedBean simpleRequestScopedBean;

	@Inject
	private SimpleApplicationScopedBean simpleApplicationScopedBean;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		response.setContentType("text/plain");
		response.setCharacterEncoding(CharEncoding.UTF_8);

		PrintWriter writer = response.getWriter();

		writer.println("Invoke request scoped bean result: " + simpleRequestScopedBean.getDescription());
		writer.println("Invoke application scoped bean result: " + simpleApplicationScopedBean.getDescription());
		writer.flush();
		writer.close();
	}

}
