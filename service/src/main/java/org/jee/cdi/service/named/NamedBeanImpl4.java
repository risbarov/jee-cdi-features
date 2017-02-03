package org.jee.cdi.service.named;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * @author Ruslan Isbarov <risbarov@technoserv.com>
 */
@Named("namedBean4")
@SessionScoped
public class NamedBeanImpl4 implements NamedBean, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Override
	public String getDescription() {
		return String.format("Bean %s with hash %d", getClass().getSimpleName(), hashCode());
	}

}
