package org.jee.cdi.service.named;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

/**
 * @author Ruslan Isbarov <risbarov@technoserv.com>
 */
@NamedBean2
@SessionScoped
public class NamedBeanImpl2 implements NamedBean, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Override
	public String getDescription() {
		return String.format("Bean %s with hash %d", getClass().getSimpleName(), hashCode());
	}

}
