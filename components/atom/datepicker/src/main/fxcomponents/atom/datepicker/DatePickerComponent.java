package relia.arsf.component.atom.datepicker;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import relia.arsf.component.base.AComponent;
import relia.arsf.component.base.FXMLComponent;
import relia.arsf.component.base.View;
import relia.arsf.component.base.checker.Checker;


@AComponent
public class DatePickerComponent extends FXMLComponent<DatePickerViewModel> {


	public DatePickerComponent( String component_name, String label ) {

		super(
			component_name, 
			"/atomes/datepicker/datepicker.fxml",
			new DatePickerView(new DatePickerViewModel(label))
		);
	}

    public DatePickerComponent(String component_name, String label, List<Checker> checkers) {
		super(
			component_name, 
			"/atomes/datepicker/datepicker.fxml",
			new DatePickerView(new DatePickerViewModel(label, checkers))
		);
    }
	
	
	public boolean check() {
		return getViewModel().check();
	}

}
