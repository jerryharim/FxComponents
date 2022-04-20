package relia.arsf.component.molecule.textfieldbutton;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import relia.arsf.component.atom.layout.TinyHBox;
import relia.arsf.component.atom.button.ButtonComponent;
import relia.arsf.component.atom.button.ButtonType;
import relia.arsf.component.atom.textfield.TextFieldComponent;
import relia.arsf.component.base.AComponent;
import relia.arsf.component.base.ComponentMountException;


/**
 * A component that contain 
 * a textfield and a button
 * */
@AComponent
public class TextfieldButtonComponent extends TinyHBox {
	private final TextFieldComponent textfield = new TextFieldComponent("textfield", "Label");	
	private final ButtonComponent button = new ButtonComponent("button", "Button", ButtonType.SECONDARY);

	public TextfieldButtonComponent(String component_name) {
		super(component_name);
	}


	@Override
	public void initialize_component() {
		super.initialize_component();					

		initialize_textfield();

		this.button.initialize_component();

		try {
			getViewModel().mount( this.textfield );
			getViewModel().mount( this.button );
		} catch (ComponentMountException e) {
			e.printStackTrace();
		}
	}


	private void initialize_textfield() {
		this.textfield.initialize_component();

		// to maximize width
		((Pane) this.textfield.getView().getRoot_node()).setMaxWidth( Double.MAX_VALUE );
		HBox.setHgrow(this.textfield.getView().getRoot_node(), Priority.ALWAYS);
	}


	// getters and setters
	
	public TextFieldComponent getTextfield() {
		return textfield;
	}


	public ButtonComponent getButton() {
		return button;
	}

	
}
