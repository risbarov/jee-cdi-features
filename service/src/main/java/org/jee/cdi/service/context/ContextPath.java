package org.jee.cdi.service.context;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * @author Ruslan Isbarov <risbarov@technoserv.com>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ TYPE, METHOD, FIELD })
@Qualifier
public @interface ContextPath {

}
