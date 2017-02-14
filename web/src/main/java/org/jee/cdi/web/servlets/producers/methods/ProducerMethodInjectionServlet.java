package org.jee.cdi.web.servlets.producers.methods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.CharEncoding;

import org.jee.cdi.services.producers.methods.Random;
import org.jee.cdi.services.producers.methods.RandomBean;
import org.jee.cdi.services.producers.methods.RandomDouble;

/**
 * @author Ruslan Isbarov <risbarov@technoserv.com>
 */
@WebServlet(urlPatterns = "/producers/methods")
public class ProducerMethodInjectionServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Inject
	@Random
	private RandomBean randomBean;

	@Inject
	@RandomDouble
	private Instance<Double> randomDoubleProducer;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		response.setContentType("text/plain");
		response.setCharacterEncoding(CharEncoding.UTF_8);

		PrintWriter writer = response.getWriter();

		writer.println(
			String.format(
				"Injected bean: [%s, %2$td.%2$tm.%2$tY %2$tH:%2$tM:%2$tS]",
				randomBean.getName(),
				randomBean.getCreateDate().getTime()
			)
		);
		writer.println("Injected value: " + randomDoubleProducer.get());
		writer.flush();
		writer.close();
	}

}
