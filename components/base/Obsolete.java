package relia.arsf.component.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;


/**
 * Indicate that a code is obsolte and 
 * it will be removed
 */ 
@Target(ElementType.TYPE)
public @interface Obsolete {
    String reason();
}
