package relia.arsf.component.atom.filteredTable;

import relia.arsf.component.atom.table.Column;
import relia.arsf.component.base.AComponent;
import relia.arsf.component.base.ParentComponent;
import relia.arsf.component.atom.button.ButtonComponent;
import relia.arsf.component.atom.button.ButtonType;
import relia.arsf.component.atom.table.TableComponent;
import relia.arsf.component.atom.textfield.TextFieldComponent;

import java.util.List;


/**
 * T Represent the type of the items
 * in the table component
 */

@AComponent
public class FilteredTableComponent<T> extends ParentComponent<FilteredTableVM> {

    private final TextFieldComponent textfield_component;
	private final ButtonComponent button;

	private final TableComponent<T> table_component;

    public FilteredTableComponent(String name, List<Column> mapping_column_property) {
        super( name, new FilteredTableView(new FilteredTableVM()) );

        this.textfield_component = new TextFieldComponent("textfield find", "Find");
        this.table_component = new TableComponent<T>("Table component", mapping_column_property);
		this.button = new ButtonComponent("button", "Ajouter", ButtonType.PRIMARY);
    }


	@Override
	public void initialize_childrens() {
        this.textfield_component.initialize_component();
        this.table_component.initialize_component();
        this.button.initialize_component();
	}

	@Override
	public void mount_childrens() {
        getViewModel().mount_textfield_component(this.textfield_component.getView().getRoot_node());
        getViewModel().mount_button(this.button.getView().getRoot_node());
        getViewModel().mount_table_component(this.table_component.getView().getRoot_node());
	}


    // getters
    
    public TextFieldComponent getTextfield_component() {
        return textfield_component;
    }

    public TableComponent<T> getTable_component() {
        return table_component;
    }

}
