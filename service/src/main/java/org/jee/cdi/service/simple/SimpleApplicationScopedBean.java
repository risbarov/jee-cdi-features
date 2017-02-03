package org.jee.cdi.service.simple;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author Ruslan Isbarov <risbarov@technoserv.com>
 */
@ApplicationScoped
public class SimpleApplicationScopedBean {

	public String getDescription() {
		return String.format("Bean %s with hash %d", getClass().getSimpleName(), hashCode());
	}

}
