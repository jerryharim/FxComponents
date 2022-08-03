package relia.arsf.component.base;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 * Used as item of any list of items.
 */

public class Item {

	private final StringProperty text = new SimpleStringProperty();	
	private final ObjectProperty<Object> user_data = new SimpleObjectProperty<>();

	
	public Item() {
		this( null, null );
	}

	public Item(String text) {
		this( text, null );
	}

	public Item(String text, Object user_data) {
		setText( text );
		setUser_data( user_data );
	}

	// getters and setters

	public StringProperty text() {
		return text;
	}

	public ObjectProperty<Object> user_data() {
		return user_data;
	}

	public String getText() {
		return this.text.get();
	}

	public Object getUser_data() {
		return this.user_data().get();
	}

	public void setUser_data(Object user_data) {
		this.user_data.set( user_data );
	}

	public void setText(String text) {
		this.text.set( text );
	}

	@Override
	public String toString() {
		return this.text.get();
	}

}
