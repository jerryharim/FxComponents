package relia.arsf.component.base;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


/**
 * M represent a FieldViewModel, a super type of ViewModel for 
 * Field type component
 **/

public abstract class FieldView<M> extends View<M> {

	
	public FieldView(M viewModel) {
		super(viewModel);
	}



}
