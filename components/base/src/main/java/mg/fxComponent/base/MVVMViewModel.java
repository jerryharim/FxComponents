package mg.fxComponent.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * MVVMViewModel of pattern MVVM.
 * Un view model gere la logique de son vue.
 * Transmet les actions de gestion de fenetre au ViewOrchestrator.
 *
 */
@Target(ElementType.TYPE)
public @interface MVVMViewModel {
}
