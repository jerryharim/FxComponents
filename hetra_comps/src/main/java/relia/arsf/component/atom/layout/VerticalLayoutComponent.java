package relia.arsf.component.atom.layout;

import relia.arsf.component.base.AComponent;
import relia.arsf.component.base.Component;


/**
 * A vertical layout, it use
 * VBox to contain their childrens
 */

@AComponent
public class VerticalLayoutComponent extends Component<VerticalLayoutViewModel> {

	public VerticalLayoutComponent(String name) {
		super( name, new VerticalLayoutView(new VerticalLayoutViewModel()) );
	}

}
