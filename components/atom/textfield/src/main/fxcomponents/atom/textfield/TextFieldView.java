package relia.arsf.component.atom.textfield;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import relia.arsf.component.base.MVVMView;
import relia.arsf.component.base.View;


@MVVMView
public class TextFieldView extends View<TextFieldViewModel> {
    @FXML private TextField text_field;
	@FXML private Label label_error, label_textfield;    


	public TextFieldView(TextFieldViewModel viewModel) {
		super(viewModel);
	}


	@Override
	public void sync_with_view_model() {
        update_field_label();
		sync_error();
        sync_textfield();
	}


	private void sync_textfield() {
        // text biderectionnal binding if we can change both side value
        // bidirectional binding of textfield text property
        
        this.text_field.textProperty().addListener((obs,old,text) -> {
            this.viewModel.setValue( text );       
        });

        // text binding here
        this.viewModel.value().addListener((obs, old, value) -> {
            this.text_field.setText(value);
        });
	}


	/**
	 * Show first error
	 * */
	public void show_errors() {
		this.label_error.setStyle("-fx-text-fill: red");
		
		if ((this.viewModel).getErrors().isEmpty()) {
			this.label_error.setText("");

		} else {
			this.viewModel.getErrors().forEach(System.out::println);
			this.label_error.setText( this.viewModel.getErrors().get(0));	
		}
	}


	public void sync_error() {
		this.viewModel.getErrors().addListener(
				(ListChangeListener<String>) change -> {
			show_errors();
		});
	}


	public void update_field_label() {
        this.label_textfield.setText(this.viewModel.getLabel());

		this.viewModel.label().addListener((obs,old,value)-> {
			this.label_textfield.setText(value);	
		});
	}



}


