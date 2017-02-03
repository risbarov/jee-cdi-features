package org.jee.cdi.service.producers;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;

/**
 * @author Ruslan Isbarov <risbarov@technoserv.com>
 */
@SessionScoped
public class RandomProducer implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Produces
	@Random
	public RandomBean produceRandomBean() {
		RandomBean randomBean = new RandomBean();
		randomBean.setName("RandomBean");
		randomBean.setCreateDate(new Date());

		return randomBean;
	}

	@Produces
	@RandomDouble
	public double produceRandomDouble() {
		return Math.random();
	}

}
