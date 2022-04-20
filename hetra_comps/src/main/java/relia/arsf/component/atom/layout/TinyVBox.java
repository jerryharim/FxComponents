package relia.arsf.component.atom.layout;

import relia.arsf.component.atom.layout.VerticalLayoutComponent;


/**
 * A vertical layout with a padding of 0
 * and a spacing of 6px
 */

public class TinyVBox extends VerticalLayoutComponent {

	public TinyVBox(String component_name) {
		super(component_name);
	}

	@Override
	public void initialize_component() {
		super.initialize_component();

		getViewModel().spacing().set(6);
	}

}

