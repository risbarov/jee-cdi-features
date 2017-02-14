package org.jee.cdi.services.producers.methods;

import java.util.Date;

/**
 * @author Ruslan Isbarov <risbarov@technoserv.com>
 */
public class RandomBean {

	private String name;

	private Date createDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
