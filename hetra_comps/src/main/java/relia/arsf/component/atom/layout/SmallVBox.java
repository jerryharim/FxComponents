package relia.arsf.component.atom.layout;

import relia.arsf.component.atom.layout.VerticalLayoutComponent;


/**
 * A vertical layout with a padding of 0
 * and a spacing of 18px
 */

public class SmallVBox extends VerticalLayoutComponent {

	public SmallVBox(String name) {
		super(name);
	}

	@Override
	public void initialize_component() {
		super.initialize_component();

		getViewModel().spacing().set(18);
	}

}

