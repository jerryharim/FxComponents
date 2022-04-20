package relia.arsf.component.atom.filteredTable;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import relia.arsf.component.base.MVVMView;
import relia.arsf.component.base.View;


@MVVMView
public class FilteredTableView extends View<FilteredTableVM> {
    private final VBox root = new VBox();
	private final HBox head_box = new HBox();


    public FilteredTableView(FilteredTableVM viewModel) {
		super(viewModel);
        super.root_node = root;
		this.head_box.setAlignment(Pos.BASELINE_LEFT);

        configure();
	}


	private void configure() {
        this.root.setSpacing(24);
        this.root.setPadding(new Insets(24));
		this.root.getChildren().add(0, this.head_box);
	}


	@Override
	public void sync_with_view_model() {
        sync_children_components();
	}


	private void sync_children_components() {
        sync_textfield_component();
		sync_button();
        sync_tableview_component();
	}


	private void sync_button() {
        this.viewModel.button().addListener((obs,old, node) -> {
            if (node != null) {
				this.head_box.getChildren().add(1, node);
			}
        });
	}


	private void sync_textfield_component() {
        this.viewModel.textfield().addListener((obs,old, node) -> {
            if (node != null) {
				this.head_box.getChildren().add(0, node);
			}
        });
	}

	private void sync_tableview_component() {
        this.viewModel.filtered_table().addListener((obs,old, node) -> {
            if (node != null) this.root.getChildren().add(1, node);
        });
	}

}
