package mg.fxComponent.base;

import java.util.HashMap;

public class ComponentRoute extends HashMap<Object, Component> {

    public void add(Object componentName, Component component) {
        put(componentName, component);
    }

    /**
     * Load components, synchronize states and initialize_route default states
     */
    public void load_components() {
        values().forEach(component -> {
            component.load();
            component.getView().sync_with_view_model();
        });
    }

}
