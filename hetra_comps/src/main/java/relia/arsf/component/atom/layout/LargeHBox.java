package relia.arsf.component.atom.layout;

import javafx.geometry.Insets;
import relia.arsf.component.atom.layout.HorizontalLayoutComponent;
import relia.arsf.component.base.AComponent;


/**
 * A Horizontal layout with a padding of 0px 
 * and a spacing of 30px
 */

@AComponent
public class LargeHBox extends HorizontalLayoutComponent {

	public LargeHBox(String component_name) {
		super(component_name);
	}


	@Override
	public void initialize_component() {
		super.initialize_component();

		getViewModel().padding().set(new Insets(0));
		getViewModel().spacing().set(30);
	}

}