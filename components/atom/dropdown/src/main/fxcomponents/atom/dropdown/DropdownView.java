package relia.arsf.component.atom.dropdown;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import relia.arsf.component.base.Item;
import relia.arsf.component.base.MVVMView;
import relia.arsf.component.base.View;


@MVVMView	
public class DropdownView extends View<DropdownViewModel> {
	@FXML private Label label;
	@FXML private ComboBox<Item> combobox;


	public DropdownView(DropdownViewModel viewModel) {
		super(viewModel);
	}


	@Override
	public void sync_with_view_model() {
		sync_label();
		sync_items();	
		sync_selected_item();
	}


	private void sync_label() {
		this.label.textProperty().bind( this.viewModel.label() );
	}


	private void sync_items() {
		this.combobox.setItems( this.viewModel.getItems() );
	}


	private void sync_selected_item() {
		// from view
		this.combobox.getSelectionModel().selectedItemProperty().addListener(
			(obs, old, selected_item) -> {
			    System.out.println("[TEST] from view - combox gox selected item changed to " + selected_item);
				this.viewModel.setSelected_item( selected_item );
			}
		);

		// from view model
		this.viewModel.selected_item().addListener((obs,old, selected_item) -> {
			if (selected_item != null)
				this.combobox.getSelectionModel().select( selected_item );
		});
	}

	
}
