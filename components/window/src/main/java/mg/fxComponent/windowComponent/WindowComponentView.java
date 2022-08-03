package mg.fxComponent.windowComponent;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import mg.fxComponent.base.MVVMView;
import mg.fxComponent.base.View;


@MVVMView
public class WindowComponentView extends View<WindowComponentVM> {
    @FXML private Button close_window_button,
            button_add,
            minimize_window_button,
            maximize_window_button;

    @FXML private Label lab_username, lab_deconnexion;

    @FXML private StackPane root;
    @FXML private Pane content;


    public WindowComponentView(WindowComponentVM viewModel) {
        super(viewModel);
    }

    @Override
    public void sync_with_view_model() {
        sync_username();

        sync_close_window_pressed_state();

        sync_content();
        sync_current_popup();
    }

    private void sync_username() {
        this.viewModel.usernameProperty().addListener((obs, old, actual_username) -> {
            this.lab_username.setText(actual_username);
        });
    }


    private void sync_close_window_pressed_state() {
        this.viewModel.pressed_close_button().bind(
                this.close_window_button.pressedProperty());
    }


    // root content

    private void sync_content() {
        this.viewModel.content().addListener((obs, old, content_node) -> {
            if (content_node != null) show_content(content_node);
        });
    }

    private void show_content(Node node) {
        HBox.setHgrow(node, Priority.ALWAYS);
        this.content.getChildren().setAll(node);
    }


    // popup

    private void sync_current_popup() {
        this.viewModel.current_popup().addListener((obs, old, current_popup) -> {
                if (current_popup != null) showPopup(current_popup);
                else close_popup();
        });
    }


	private void showPopup(Node current_popup) {
        this.root.getChildren().add(1, current_popup);
	}

	private void close_popup() {
        this.root.getChildren().remove(1);
	}



}
