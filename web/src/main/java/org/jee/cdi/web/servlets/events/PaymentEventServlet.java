package org.jee.cdi.web.servlets.events;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.CharEncoding;

import org.jee.cdi.services.events.PaymentEvent;
import org.jee.cdi.services.events.PaymentEventConsumer;
import org.jee.cdi.services.events.PaymentEventProducer;

/**
 * @author Ruslan Isbarov <risbarov@technoserv.com>
 */
@WebServlet(urlPatterns = "/events")
public class PaymentEventServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Inject
	private PaymentEventProducer paymentEventProducer;

	@Inject
	private PaymentEventConsumer paymentEventConsumer;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		response.setContentType("text/plain");
		response.setCharacterEncoding(CharEncoding.UTF_8);

		PrintWriter writer = response.getWriter();

		paymentEventProducer.fireCreditEvent();
		paymentEventProducer.fireDebitEvent();

		for (PaymentEvent paymentEvent : paymentEventConsumer.getPaymentEvents()) {
			writer.println(paymentEvent);
		}

		writer.flush();
		writer.close();
	}

}
