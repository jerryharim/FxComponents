package relia.arsf.component.atom.text;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import relia.arsf.component.base.MVVMViewModel;
import relia.arsf.component.base.ViewModel;



@MVVMViewModel
public class TextViewModel extends ViewModel {

    private final StringProperty text = new SimpleStringProperty();
	private final ObjectProperty<TextType> type = new SimpleObjectProperty<>(TextType.SIMPLE);
	private final ObjectProperty<Pos> alignment = new SimpleObjectProperty<>(Pos.BOTTOM_LEFT);


	public TextViewModel() { }

	public TextViewModel(String text, TextType type) {
		this.text.set( text );
		this.type.set( type );
	}


	public void setAlignement(Pos alignment) {
		this.alignment.set( alignment );
	}


	// getters and setters
	
	public String getText() {
		return this.text().get();
	}
	
	public TextType getType() {
		return type.get();
	}

	public void setType(TextType type) {
		this.type.set(type);
	}

	public ObjectProperty<TextType> type() {
		return type;
	}

	public void setText(String text) {
		this.text.set( text );
	}

    public StringProperty text() {
        return this.text;
    }

	public ObjectProperty<Pos> alignment() {
		return alignment;
	}
}
