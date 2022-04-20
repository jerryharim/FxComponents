package relia.arsf.component;


public class WindowManager {

    public static void close_popup(ComponentFactory component_factory) {
		component_factory.getWindow_component().getViewModel().close_popup();
    }
	
}
