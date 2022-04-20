package mg.fxComponent.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Synchronisation avec le model du vue
 */
@Target(ElementType.METHOD)
public @interface ViewModelSynchronisation {
}
