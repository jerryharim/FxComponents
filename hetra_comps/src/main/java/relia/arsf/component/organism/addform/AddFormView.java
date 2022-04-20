package relia.arsf.component.organism.addform;

import java.util.stream.Collectors;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import relia.arsf.component.base.Component;
import relia.arsf.component.base.MVVMView;
import relia.arsf.component.base.View;


@MVVMView
public class AddFormView extends View<AddFormViewModel> {
    @FXML private Label title;
    @FXML private VBox body_container;
    @FXML private Button button_cancel, button_add;


    public AddFormView(AddFormViewModel viewModel) {
        super(viewModel);
    }


    @Override
    public void sync_with_view_model() {
		sync_title();
		sync_button_cancel();
		sync_button_add();
		sync_childrens();
		sync_button_add_text();
		sync_button_cancel_text();
    }


	private void sync_button_cancel_text() {
		this.button_cancel.textProperty().bind(
			this.viewModel.button_cancel_text());
	}


	private void sync_button_add_text() {
		this.button_add.textProperty().bind(
			this.viewModel.button_add_text());
	}


	private void sync_childrens() {
		this.viewModel.getChildrens().addListener((ListChangeListener<Component<?>>) change -> {
			update_childrens();
		});
	}


	private void update_childrens() {
		this.body_container.getChildren().setAll(
			this.viewModel.getChildrens().stream().map( component -> {
				return component.getView().getRoot_node();
			})
			.collect(Collectors.toList())
		);
	}


	private void sync_button_add() {
		this.button_add.pressedProperty().addListener((obs,old,pressed) -> {
			this.viewModel.setPressed_add_button( pressed );
		});
	}


	private void sync_button_cancel() {
		this.button_cancel.pressedProperty().addListener((obs,old,pressed) -> {
			this.viewModel.setPressed_cancel_button( pressed );
		});
	}


	private void sync_title() {
		this.title.textProperty().bind(
			this.viewModel.title() );
	}

}
