package org.jee.cdi.services.named;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

/**
 * @author Ruslan Isbarov <risbarov@technoserv.com>
 */
@NamedBean1
@SessionScoped
public class NamedBeanImpl1 implements NamedBean, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Override
	public String getDescription() {
		return String.format("Bean %s with hash %d", getClass().getSimpleName(), hashCode());
	}

}
