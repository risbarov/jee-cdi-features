package org.jee.cdi.services.events;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Named;

/**
 * @author Ruslan Isbarov <risbarov@technoserv.com>
 */
@Named
@ApplicationScoped
public class PaymentEventConsumer {

	private List<PaymentEvent> paymentEvents = new ArrayList<>();

	public void observeCreditEvent(@Observes @Credit PaymentEvent paymentEvent) {
		paymentEvents.add(paymentEvent);
	}

	public void observeDebitEvent(@Observes @Debit PaymentEvent paymentEvent) {
		paymentEvents.add(paymentEvent);
	}

	public List<PaymentEvent> getPaymentEvents() {
		return paymentEvents;
	}

}
