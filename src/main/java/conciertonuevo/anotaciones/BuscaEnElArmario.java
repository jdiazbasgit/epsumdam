package conciertonuevo.anotaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

@Autowired
public @interface BuscaEnElArmario {
	@AliasFor(annotation = Component.class)
	String value() default "";
}
