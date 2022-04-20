package relia.arsf.component.atom.table;

import relia.arsf.component.base.AComponent;
import relia.arsf.component.base.FXMLComponent;
import relia.arsf.component.taskpayer.ItemTaxePayerList;

import java.util.List;

import javafx.scene.control.TableView;


/**
 * T represent the type of the items in 
 * the table
 */

@AComponent
public class TableComponent<T> extends FXMLComponent<TableViewModel<T>> {

	public TableComponent(String name, List<Column> mapping_column_property) {
        super(
			name,
            "/atomes/table/table.fxml",
            new TableAtomView<T>( new TableViewModel<T>(mapping_column_property) )
        );
    }

	public TableView<ItemTaxePayerList> getTableview() {
		return ((TableAtomView) getView()).getTableview();
	}

}
