package relia.arsf.component.atom.layout;

import javafx.geometry.Insets;
import relia.arsf.component.atom.layout.VerticalLayoutComponent;
import relia.arsf.component.base.AComponent;


/**
 * A vertical layout with a padding of 0px
 * and a spacing of 30px
 */

@AComponent
public class LargeVBox extends VerticalLayoutComponent {

	public LargeVBox(String component_name) {
		super(component_name);
	}

	@Override
	public void initialize_component() {
		super.initialize_component();

		getViewModel().padding().set(new Insets(0));
		getViewModel().spacing().set(30);
	}

}
