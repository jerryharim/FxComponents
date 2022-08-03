package relia.arsf.component.base.checker;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;


/**
 * Check errors
 * */
public abstract class Checker {

	protected final BooleanProperty passed = new SimpleBooleanProperty();
	protected final String error_message;


	public Checker(String error_message) {
		this.error_message = error_message;
	}

	
	public void check(String message) {
		if (correct(message)) this.passed.set(true);
		else this.passed.set(false);
	}

	
	public abstract boolean correct(String message);


	// getters
	

	public boolean isPassed() {
		return this.passed.get();
	}

	public BooleanProperty passedProperty() {
		return passed;
	}

	public String getError_message() {
		return error_message;
	}



}
