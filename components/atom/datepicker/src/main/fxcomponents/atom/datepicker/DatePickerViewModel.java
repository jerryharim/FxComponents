package relia.arsf.component.atom.datepicker;

import java.time.LocalDate;
import java.util.List;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import relia.arsf.component.base.FieldViewModel;
import relia.arsf.component.base.checker.Checker;


public class DatePickerViewModel extends FieldViewModel {
	private final ObjectProperty<LocalDate> date = new SimpleObjectProperty<>();

	public DatePickerViewModel(String label) {
		super(label);
	}

	public DatePickerViewModel(String label, List<Checker> checkers) {
		super(label, checkers);
	}


	// getters and setters
	

    public ObjectProperty<LocalDate> dateProperty() {
		return date;
	}

	public LocalDate getDate() {
		return this.date.get();
	}

    public void setDate(LocalDate date) {
		this.date.set( date );
    }


}

