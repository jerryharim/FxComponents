package relia.arsf.component.atom.layout;

import javafx.geometry.Insets;
import relia.arsf.component.atom.layout.VerticalLayoutComponent;
import relia.arsf.component.base.AComponent;


/**
 * A vertical layout with a padding of 24px 12px 
 * and a spacing of 24px
 */

@AComponent
public class MediumVBox extends VerticalLayoutComponent {

	public MediumVBox(String name) {
		super(name);
	}

	@Override
	public void initialize_component() {
		super.initialize_component();

		getViewModel().padding().set(new Insets(24, 12, 24, 12));
		getViewModel().spacing().set(24);
	}

}
