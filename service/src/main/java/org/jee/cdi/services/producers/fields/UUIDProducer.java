package org.jee.cdi.services.producers.fields;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

/**
 * @author Ruslan Isbarov <risbarov@technoserv.com>
 */
@RequestScoped
public class UUIDProducer {

	@Produces
	@UUID
	private String uuid;

	@PostConstruct
	public void init() {
		uuid = java.util.UUID.randomUUID().toString();
	}

}
