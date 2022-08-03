package relia.arsf.component.atom.textfield;

import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import relia.arsf.component.base.FieldViewModel;
import relia.arsf.component.base.checker.Checker;


public class TextFieldViewModel extends FieldViewModel {

	public TextFieldViewModel(String label) {
		super(label);
    }

	public TextFieldViewModel(String label, List<Checker> checkers) {
		super(label, checkers);
    }

}


