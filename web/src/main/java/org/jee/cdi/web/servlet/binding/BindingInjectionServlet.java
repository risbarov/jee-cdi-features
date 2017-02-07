package org.jee.cdi.web.servlet.binding;

import java.io.IOException;
import java.io.PrintWriter;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.CharEncoding;

import org.jee.cdi.service.binding.Hash;
import org.jee.cdi.service.binding.HashGenerator;
import org.jee.cdi.service.binding.HashType;

/**
 * @author Ruslan Isbarov <risbarov@technoserv.com>
 */
@WebServlet(urlPatterns = "/binding")
public class BindingInjectionServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Inject
	@Hash(HashType.MD5)
	private HashGenerator md5Generator;

	@Inject
	@Hash(HashType.SHA512)
	private HashGenerator sha512Generator;

	@Inject
	@Any
	private Instance<HashGenerator> hashGenerators;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		response.setContentType("text/plain");
		response.setCharacterEncoding(CharEncoding.UTF_8);

		PrintWriter writer = response.getWriter();

		writer.println("MD5: " + md5Generator.calculate(getClass().getName()));
		writer.println("SHA512: " + sha512Generator.calculate(getClass().getName()));
		writer.println();
		writer.println("Available hash generators:");

		hashGenerators.forEach(writer::println);

		writer.flush();
		writer.close();
	}

}
