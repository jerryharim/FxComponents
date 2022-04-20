package relia.arsf.component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;


/**
 * In class-based programming, the factory method pattern 
 * is a creational pattern that uses factory methods to deal with 
 * the problem of creating objects without having to specify 
 * the exact class of the object that will be created.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Factory_method_pattern">Factory method pattern</a>
 **/

@Target(ElementType.TYPE)
public @interface AFactory {
}


