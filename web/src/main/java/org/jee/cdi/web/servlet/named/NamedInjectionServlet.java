package org.jee.cdi.web.servlet.named;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.CharEncoding;

import org.jee.cdi.service.named.NamedBean;
import org.jee.cdi.service.named.NamedBean1;
import org.jee.cdi.service.named.NamedBean2;

/**
 * @author Ruslan Isbarov <risbarov@technoserv.com>
 */
@WebServlet(urlPatterns = "/named")
public class NamedInjectionServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Inject
	@NamedBean1
	private NamedBean namedBean1;

	@Inject
	@NamedBean2
	private NamedBean namedBean2;

	@Inject
	@Named("namedBean3")
	private NamedBean namedBean3;

	@Inject
	@Named("namedBean4")
	private NamedBean namedBean4;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		response.setContentType("text/plain");
		response.setCharacterEncoding(CharEncoding.UTF_8);

		PrintWriter writer = response.getWriter();

		writer.println("Invoke qualifier named bean 1 result: " + namedBean1.getDescription());
		writer.println("Invoke qualifier named bean 2 result: " + namedBean2.getDescription());
		writer.println();
		writer.println("Invoke string named bean 3 result: " + namedBean3.getDescription());
		writer.println("Invoke string named bean 4 result: " + namedBean4.getDescription());

		writer.flush();
		writer.close();
	}

}
