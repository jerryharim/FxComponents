package relia.arsf.component.atom.layout;

import javafx.geometry.Insets;
import relia.arsf.component.base.AComponent;


/**
 * A Large Box with a 24px 18px of padding
 * and 0px of spacing and can contain 
 * one or many children.
 */

@AComponent
public class LargeBox extends VerticalLayoutComponent {

	public LargeBox(String name) {
		super(name);
	}
	

	@Override
	public void initialize_component() {
		super.initialize_component();

		getViewModel().padding().set(new Insets(24, 18, 24, 18));
	}

}
