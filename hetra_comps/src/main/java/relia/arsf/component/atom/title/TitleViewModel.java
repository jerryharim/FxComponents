package relia.arsf.component.atom.title;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import relia.arsf.component.base.MVVMViewModel;
import relia.arsf.component.base.ViewModel;


@MVVMViewModel
public class TitleViewModel extends ViewModel {

    private final StringProperty text = new SimpleStringProperty();


	// getters and setters
	
	public String getText() {
		return this.text().get();
	}
	
	public void setText(String text) {
		this.text.set( text );
	}

    public StringProperty text() {
        return this.text;
    }

}
