package relia.arsf.component.molecule.verticalmenu;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import relia.arsf.component.base.MVVMViewModel;
import relia.arsf.component.base.ViewModel;


/**
 * T represent the type of element used in menu list
 */ 

@MVVMViewModel
public class VerticalMenuViewModel extends ViewModel {
    private final ObjectProperty<MenuItem> selected_menu;
    
    public VerticalMenuViewModel() {
        this.selected_menu = new SimpleObjectProperty<MenuItem>();
    }


    /**
     * Select first item in the menu list if not empty
     */ 
	private void select_first_menu_item() {
	}

    public void select_menu_item(MenuItem menuItem) {
		this.selected_menu.set(menuItem);
    }

    // getters
   
    public ObjectProperty<MenuItem> selected_menu_item() {
        return this.selected_menu; 
    }


    
}


