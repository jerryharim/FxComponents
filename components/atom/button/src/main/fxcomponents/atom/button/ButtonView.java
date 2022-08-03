package relia.arsf.component.atom.button;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import relia.arsf.component.base.View;


public class ButtonView extends View<ButtonViewModel> {
    @FXML private Button button;

    public ButtonView(ButtonViewModel viewModel) {
		super(viewModel);
	}

	@Override
	public void sync_with_view_model() {
        sync_text();
		sync_width();
		sync_button_type();
        sync_click();
	}

	private void sync_width() {
		this.button.prefWidthProperty().bind(
			this.viewModel.width() );
	}

	private void sync_button_type() {
		button_type_updated( this.viewModel.button_type().get() );

		this.viewModel.button_type().addListener((obs, last_button_type, button_type) -> {
			if (button_type != null) button_type_updated( button_type );
		});
	}

	private void button_type_updated(ButtonType button_type) {
		// use switch instead
		if( button_type.equals(ButtonType.MINI) ) convert_to_button_mini();
		if( button_type.equals(ButtonType.SECONDARY) ) convert_to_button_secondary();
		else if( button_type.equals(ButtonType.PRIMARY) ) convert_to_primary_button(); 
		else if( button_type.equals(ButtonType.TRANSPARENT) ) convert_to_transparent_button();
		else if( button_type.equals(ButtonType.BORDER_ONLY) ) convert_to_border_only_button();
	}

	private void convert_to_button_mini() {
    	reset_type_style();
	}

	private void convert_to_border_only_button() {
		reset_type_style();
		this.button.getStyleClass().add("button-border-only");
	}

	private void convert_to_button_secondary() {
		reset_type_style();
        this.button.getStyleClass().add("button-secondary");
	}

	private void convert_to_primary_button() {
		reset_type_style();
        this.button.getStyleClass().add("button-primary");
	}
	private void convert_to_transparent_button() {
		reset_type_style();
        this.button.getStyleClass().add("button-transparent");
	}

	private void reset_type_style() {
        this.button.getStyleClass().remove("button-primary");
        this.button.getStyleClass().remove("button-transparent");
        this.button.getStyleClass().remove("button-secondary");
		this.button.getStyleClass().remove("button-border-only");
	}



	private void sync_text() {
        this.button.textProperty().set(this.viewModel.text().get());
		this.viewModel.text().addListener((obs,old,text) -> {
			this.button.setText( text );
		});
	}

	private void sync_click() {
        this.button.setOnAction( event -> {
            this.viewModel.on_action();
        });
	}

}




