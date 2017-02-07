package org.jee.cdi.service.binding;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;
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
public @interface Hash {

	// Чтобы не создавать одинаковые аннотации, можно расширять аннотации полями.
	// Weld будет учитывать значения полей при выборе реализации в точке инъекции.

	HashType value() default HashType.MD5;

	// Поля, помеченные аннотацией @Nonbinding, при выборе реализации учитываться не будут.
	@Nonbinding
	String description() default "";

}
