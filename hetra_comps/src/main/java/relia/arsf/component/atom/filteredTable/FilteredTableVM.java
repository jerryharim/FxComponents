package relia.arsf.component.atom.filteredTable;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import relia.arsf.component.base.MVVMViewModel;
import relia.arsf.component.base.ViewModel;

                  
@MVVMViewModel
public class FilteredTableVM extends ViewModel {
	private final ObjectProperty<Node> textfield = new SimpleObjectProperty<>();
    private final ObjectProperty<Node> button = new SimpleObjectProperty<>();
    private final ObjectProperty<Node> filtered_table = new SimpleObjectProperty<>();


	public void mount_button(Node node) {
		this.button.set(node);
	}

    public void mount_textfield_component(Node node) {
        this.textfield.set(node);
    }

    public void mount_table_component(Node node) {
        this.filtered_table.set(node);
    }


    // getters
    
    public ObjectProperty<Node> textfield() {
        return textfield;
    }

    public ObjectProperty<Node> filtered_table() {
        return filtered_table;
    }

    public ObjectProperty<Node> button() {
		return button;
	}


}
