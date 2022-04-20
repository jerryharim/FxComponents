package relia.arsf.component.atom.dropdown;

import java.util.List;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import relia.arsf.component.base.Item;
import relia.arsf.component.base.MVVMViewModel;
import relia.arsf.component.base.ViewModel;


@MVVMViewModel
public class DropdownViewModel extends ViewModel {
	private final StringProperty label = new SimpleStringProperty();
	private final ObservableList<Item> items = FXCollections.observableArrayList();	
	private final ObjectProperty<Item> selected_item = new SimpleObjectProperty<>();


	public DropdownViewModel() { }

	public DropdownViewModel(String label) {
		this.label.set( label );
	}


	// getters and setters

	public ObservableList<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items.setAll(items);
	}

	public ObjectProperty<Item> selected_item() {
		return selected_item;
	}

	public Item geSelected_item() {
		return selected_item.get();
	}

	public void setSelected_item(Item item) {
		selected_item.set(item);
	}

	public StringProperty label() {
		return label;
	}

	public String getLabel() {
		return this.label.get();
	}
	 
}
