package relia.arsf.component.atom.button;

import relia.arsf.component.base.AComponent;
import relia.arsf.component.base.FXMLComponent;


@AComponent
public class ButtonComponent extends FXMLComponent<ButtonViewModel> {

	public ButtonComponent(String component_name) {
		this( component_name, "", ButtonType.SECONDARY );
    }

    public ButtonComponent(String component_name, String text) {
        this( component_name, text, ButtonType.SECONDARY );
    }

	public ButtonComponent(String component_name, String text, ButtonType button_type) {
        super(
			component_name,
            "/atomes/button/button.fxml",
            new ButtonView(new ButtonViewModel(text, button_type))
        );
    }

}
