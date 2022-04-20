package relia.arsf.component.organism.addform;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import relia.arsf.component.base.Component;
import relia.arsf.component.base.MVVMViewModel;
import relia.arsf.component.base.ViewModel;


@MVVMViewModel
public class AddFormViewModel extends ViewModel {
	private final StringProperty title = new SimpleStringProperty();
	private final BooleanProperty pressed_cancel_button = new SimpleBooleanProperty();
	private final BooleanProperty pressed_add_button = new SimpleBooleanProperty();
	private final ObservableList<Component<?>> childrens = FXCollections.observableArrayList();
	private final StringProperty button_add_text = new SimpleStringProperty();
	private final StringProperty button_cancel_text = new SimpleStringProperty();


	// getters and setters
	
	
	public BooleanProperty pressed_cancel_button() {
		return pressed_cancel_button;
	}


	public ObservableList<Component<?>> getChildrens() {
		return childrens;
	}


	public BooleanProperty pressed_add_button() {
		return pressed_add_button;
	}
	
	
    public void setPressed_cancel_button(Boolean pressed) {
		this.pressed_cancel_button.set( pressed );
    }


    public void setPressed_add_button(Boolean pressed) {
		this.pressed_add_button.set( pressed );
    }
	
	
	public StringProperty title() {
		return title;
	}

	public String getTitle() {
		return title.get();
	}

	public void setTitle(String title) {
		this.title.set( title );
	}


	public StringProperty button_add_text() {
		return button_add_text;
	}

	public StringProperty button_cancel_text() {
		return button_cancel_text;
	}

	public String getButton_add_text() {
		return button_add_text.get();
	}


	public String getButton_cancel_text() {
		return button_cancel_text.get();
	}


}
