package relia.arsf.component.atom.layout;

import relia.arsf.component.base.AComponent;
import relia.arsf.component.base.Component;


/**
 * A Horizontal layout, it use
 * HBox to contain their childrens
 */

@AComponent
public class HorizontalLayoutComponent extends Component<HorizontalLayoutViewModel> {

	public HorizontalLayoutComponent(String name) {
		super( name, new HorizontalLayoutView(new HorizontalLayoutViewModel()) );
	}

}
