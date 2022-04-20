package relia.arsf.component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * The singleton pattern is a software design pattern that 
 * restricts the instantiation of a class to one "single" 
 * instance. This is useful when exactly one object is needed 
 * to coordinate actions across the system. 
 *
 * @see <a href="https://en.wikipedia.org/wiki/Singleton_pattern">Singleton pattern</a>
 */

@Target(ElementType.METHOD)
public @interface ASingleton {

}
