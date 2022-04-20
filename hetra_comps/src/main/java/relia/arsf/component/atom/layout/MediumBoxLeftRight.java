package relia.arsf.component.atom.layout;

import javafx.geometry.Insets;
import relia.arsf.component.base.AComponent;


/**
 * A Medium Box with a 0px 18px of padding,
 * 0px of spacing and can contain 
 * only one children
 */

@AComponent
public class MediumBoxLeftRight extends VerticalLayoutComponent {

	
	public MediumBoxLeftRight(String name) {
		super(name);
	}


	@Override
	public void initialize_component() {
		super.initialize_component();

		getViewModel().padding().set(new Insets(0, 18, 0, 18));
	}
}
