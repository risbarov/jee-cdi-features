package org.jee.cdi.services.events;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Ruslan Isbarov <risbarov@technoserv.com>
 */
public class PaymentEvent implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	public PaymentType paymentType;

	public BigDecimal value;

	public Date date;

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static PaymentEvent newInstance(PaymentType paymentType, BigDecimal value, Date date) {
		PaymentEvent paymentEvent = new PaymentEvent();
		paymentEvent.setPaymentType(paymentType);
		paymentEvent.setValue(value);
		paymentEvent.setDate(date);

		return paymentEvent;
	}

	@Override
	public String toString() {
		return String.format("PaymentEvent[paymentType = %s, value = %s, date = %s]", paymentType, value, date);
	}

}
