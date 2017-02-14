package org.jee.cdi.services.events;

import java.math.BigDecimal;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Ruslan Isbarov <risbarov@technoserv.com>
 */
@Named
@ApplicationScoped
public class PaymentEventProducer {

	@Inject
	@Credit
	private Event<PaymentEvent> creditEvent;

	@Inject
	@Debit
	private Event<PaymentEvent> debitEvent;

	public void fireCreditEvent() {
		creditEvent.fire(PaymentEvent.newInstance(PaymentType.Credit, BigDecimal.TEN, new Date()));
	}

	public void fireDebitEvent() {
		creditEvent.fire(PaymentEvent.newInstance(PaymentType.Debit, BigDecimal.ONE, new Date()));
	}

}
