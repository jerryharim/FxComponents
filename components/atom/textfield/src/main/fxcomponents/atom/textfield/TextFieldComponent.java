package relia.arsf.component.atom.textfield;

import java.util.List;

import relia.arsf.component.base.AComponent;
import relia.arsf.component.base.FXMLComponent;
import relia.arsf.component.base.checker.Checker;


@AComponent
public class TextFieldComponent extends FXMLComponent<TextFieldViewModel> {

    public TextFieldComponent(String name, String label) {
		super( 
			name,
            "/atomes/textfield/text_field.fxml", 
            new TextFieldView( new TextFieldViewModel(label) )
        );
	}

    public TextFieldComponent(String name, String label, List<Checker> checkers) {
		super( 
			name,
            "/atomes/textfield/text_field.fxml", 
            new TextFieldView( new TextFieldViewModel(label, checkers) )
        );
	}

    public boolean check() {
		return getViewModel().check();
    }


}


