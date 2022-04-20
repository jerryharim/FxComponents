package relia.arsf.component.atom.button;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import relia.arsf.component.base.ViewModel;


public class ButtonViewModel extends ViewModel {

	private final BooleanProperty clicked = new SimpleBooleanProperty();
    private final StringProperty text = new SimpleStringProperty();
	private final DoubleProperty width = new SimpleDoubleProperty(100);
	private final ObjectProperty<ButtonType> button_type = new SimpleObjectProperty<>(ButtonType.SECONDARY);

	
    public ButtonViewModel() {
	}

    public ButtonViewModel(String text, ButtonType button_type) {
		this.text.set( text );
		this.button_type.set( button_type );
	}

    public void on_action() {
        this.clicked.set(true);
        this.clicked.set(false);
    }


    // getters and setters
	
	public void setType(ButtonType type) {
		this.button_type.set(type);
	}
	
	public void setText(String text) {
		this.text.set(text);
	}
    
    public StringProperty text() {
		return text;
	}
    
    public BooleanProperty clicked() {
		return clicked;
	}

	public void setWidth(double width) {
		this.width.set(width);
	}

	public DoubleProperty width() {
		return this.width;
	}

	public ObjectProperty<ButtonType> button_type() {
		return button_type;
	}

	public void setButton_type( ButtonType button_type ) {
		this.button_type.set( button_type );
	}
	 

}


