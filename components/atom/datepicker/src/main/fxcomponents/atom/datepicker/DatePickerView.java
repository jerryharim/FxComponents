package relia.arsf.component.atom.datepicker;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import relia.arsf.component.base.FieldView;
import relia.arsf.component.base.MVVMView;


@MVVMView
public class DatePickerView extends FieldView<DatePickerViewModel> {
	@FXML private DatePicker datepicker;
	@FXML private Label label, label_error;

	public DatePickerView(DatePickerViewModel viewModel) {
		super(viewModel);
	}

	@Override
	public void sync_with_view_model() {
        update_field_label();
		sync_label();
		sync_error();
		sync_value();			
	}

	private void sync_label() {
		this.label.textProperty().bind( this.viewModel.label() );
	}

	private void sync_value() {
		// from view
		
		this.datepicker.valueProperty().addListener((obs,old,value) -> {
			this.viewModel.setDate(value);
			this.viewModel.setValue(value.toString());
			System.out.println("value " + value.toString());
		});

		// from view model
		this.viewModel.dateProperty().addListener((obs,old,value) -> {
			this.datepicker.setValue( value );
		});
	}

	public void update_field_label() {
        this.label.textProperty().bind( 
			this.viewModel.label() );
	}

	public void sync_error() {
		this.viewModel.getErrors().addListener(
				(ListChangeListener<String>) change -> {
			show_errors();
		});
	}

	public void show_errors() {
		this.label_error.setStyle("-fx-text-fill: red");
		
		if ((this.viewModel).getErrors().isEmpty()) {
			this.label_error.setText("");

		} else {
			this.viewModel.getErrors().forEach(System.out::println);
			this.label_error.setText( this.viewModel.getErrors().get(0));	
		}
	}

}

