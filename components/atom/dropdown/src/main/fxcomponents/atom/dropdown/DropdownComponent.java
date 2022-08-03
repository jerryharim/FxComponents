package relia.arsf.component.atom.dropdown;

import relia.arsf.component.base.AComponent;
import relia.arsf.component.base.Component;
import relia.arsf.component.base.FXMLComponent;


@AComponent
public class DropdownComponent extends FXMLComponent<DropdownViewModel> {

	public DropdownComponent(String name) {
		super(
			name, 
			"/atomes/dropdown/dropdown.fxml",
			new DropdownView(new DropdownViewModel())
		);
	}

	public DropdownComponent(String name, String label) {
		super(
				name,
				"/atomes/dropdown/dropdown.fxml",
				new DropdownView(new DropdownViewModel(label))
		);
	}

}
