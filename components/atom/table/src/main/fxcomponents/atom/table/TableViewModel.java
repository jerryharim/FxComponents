package relia.arsf.component.atom.table;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import relia.arsf.component.base.MVVMViewModel;
import relia.arsf.component.base.ViewModel;


@MVVMViewModel
public class TableViewModel<ItemType> extends ViewModel {
	private final List<Column> mapping_column_property;
    private final ObservableList<ItemType> items = FXCollections.observableArrayList();
    private final ObjectProperty<ItemType> selected_item = new SimpleObjectProperty<>();


    public TableViewModel(List<Column> mapping_column_property) {
        if (mapping_column_property == null)
            this.mapping_column_property = new ArrayList<>();
        else this.mapping_column_property = mapping_column_property;
    }


    public void set_columns( List<Column> mapping_column_property ) {
        this.mapping_column_property.clear();
        this.mapping_column_property.addAll( mapping_column_property );
    }


	public void set_items(List<ItemType> items) {
        this.items.setAll(items);
    }

    
    // getters
    
	public List<Column> getMapping_column_property() {
		return mapping_column_property;
	}

    public ObservableList<ItemType> getItems() {
		return items;
	}
    
    public ObjectProperty<ItemType> selected_item() {
		return selected_item;
	}

}


