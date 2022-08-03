package relia.arsf.component.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;


/**
 * A component is a piece of a reusable view.
 * Used to access easly to the View and the ViewModel.
 * It's like a factory that create the View instance and 
 * the ViewModel associate with this.
 */

@Target(ElementType.TYPE)
public @interface AComponent {
}
