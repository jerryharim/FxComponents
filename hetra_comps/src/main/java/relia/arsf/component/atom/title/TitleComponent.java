package relia.arsf.component.atom.title;

import relia.arsf.component.base.AComponent;
import relia.arsf.component.base.FXMLComponent;


@AComponent
public class TitleComponent extends FXMLComponent<TitleViewModel> {

    public TitleComponent(String name) {
		super(
			name,
            "/atomes/title/title.fxml",
            new TitleView(new TitleViewModel())
        );
	}

}
