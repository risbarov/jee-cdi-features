package org.jee.cdi.service.binding;

import javax.enterprise.context.ApplicationScoped;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author Ruslan Isbarov <risbarov@technoserv.com>
 */
@ApplicationScoped
@Hash(value = HashType.SHA512, description = "SHA512 hash implementation")
public class SHA512Generator implements HashGenerator {

	@Override
	public String calculate(String plain) {
		return DigestUtils.sha512Hex(plain);
	}

}
