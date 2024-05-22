package conciertonuevo.anotaciones;

import java.lang.annotation.Documented;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

@Component
@Documented
public @interface MeteteEnElArmario {
	@AliasFor(annotation = Component.class)
	String value() default "";
}
