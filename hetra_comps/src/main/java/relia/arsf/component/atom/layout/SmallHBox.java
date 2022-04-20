package relia.arsf.component.atom.layout;


/**
 * A Horizontal layout with a padding of 0
 * and a spacing of 18px
 */

public class SmallHBox extends HorizontalLayoutComponent {

	public SmallHBox(String name) {
		super(name);
	}

	@Override
	public void initialize_component() {
		super.initialize_component();
		getViewModel().spacing().set(18);
	}

}

