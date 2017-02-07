package org.jee.cdi.service.binding;

import javax.enterprise.context.ApplicationScoped;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author Ruslan Isbarov <risbarov@technoserv.com>
 */
@ApplicationScoped
@Hash(value = HashType.MD5, description = "MD5 hash implementation")
public class MD5Generator implements HashGenerator {

	@Override
	public String calculate(String plain) {
		return DigestUtils.md5Hex(plain);
	}

}
