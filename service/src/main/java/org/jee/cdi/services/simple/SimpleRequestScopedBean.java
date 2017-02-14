package org.jee.cdi.services.simple;

import javax.enterprise.context.RequestScoped;

/**
 * @author Ruslan Isbarov <risbarov@technoserv.com>
 */
@RequestScoped
public class SimpleRequestScopedBean {

	public String getDescription() {
		return String.format("Bean %s with hash %d", getClass().getSimpleName(), hashCode());
	}

}
