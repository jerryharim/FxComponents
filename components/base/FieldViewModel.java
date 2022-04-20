package relia.arsf.component.base;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import relia.arsf.component.base.checker.Checker;


@MVVMViewModel
public abstract class FieldViewModel extends ViewModel {

	protected final StringProperty label = new SimpleStringProperty("");;
    private final StringProperty value = new SimpleStringProperty("");
	protected final StringProperty error_message = new SimpleStringProperty("");;
	protected final List<Checker> checkers = new ArrayList<>();
	protected final ObservableList<String> errors = FXCollections.observableArrayList();


	public FieldViewModel(String label) {
		this(label, new ArrayList<>());
	}

	public FieldViewModel(String label, List<Checker> checkers) {
		this.label.set(label);
		this.checkers.addAll(checkers);

		remove_errors_on_modification();
	}


	private void remove_errors_on_modification() {
		this.value.addListener( val -> {
			this.errors.clear();
		});
	}

	/**
	 * Verify the field value
	 * and populate error_message with 
	 * the Checker message.
	 *
	 * @return true if all ok otherwise false;
	 * */
	public boolean check() {
		this.errors.clear();

		this.checkers.forEach( checker -> {
			checker.check( getValue() );	

			if (!checker.isPassed()) 
				this.errors.add( checker.getError_message() );
		});

		return this.errors.isEmpty();
	}



	// getters and setters
	
	public StringProperty label() {
		return this.label;
	}

	public String getLabel() {
		return label.get();
	}

    public void setLabel(String label) {
        this.label.set( label );
    }


	public StringProperty error_messageProperty() {
		return error_message;
	}

	public String getError_message() {
		return error_message.get();
	}

	public void setError_message(String error_message) {
		this.error_message.set(error_message);
	}


	public ObservableList<String> getErrors() {
		return this.errors;
	}

	public String getValue() {
		return this.value.get();
	}

    public StringProperty value() {
		return value;
	}

    public void setValue(String value) {
        this.value.set(value);
    }

	public List<Checker> getCheckers() {
		return this.checkers;
	}

}
