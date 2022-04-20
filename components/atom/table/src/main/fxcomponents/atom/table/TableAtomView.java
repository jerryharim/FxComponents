package relia.arsf.component.atom.table;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import relia.arsf.component.base.View;


/**
 * T represent the type of the table items
 */ 

public class TableAtomView<T> extends View<TableViewModel<T>> {
	@FXML private TableView<T> tableview;

    public TableAtomView(TableViewModel<T> viewModel) {
		super(viewModel);
	}


	@Override
	public void sync_with_view_model() {
        generate_columns();
        sync_items();
        listen_tableview_selected_item();
	}



	private void sync_items() {
        this.viewModel.getItems().addListener((ListChangeListener<T>) change -> {
            // not a good idea but it work
            // of course if the size of the items is small
            update_table_items();
        });
	}

	private void update_table_items() {
        this.tableview.setItems( this.viewModel.getItems() );
	}

    private void listen_tableview_selected_item() {
        this.tableview.getSelectionModel().selectedItemProperty().addListener((obs, old, selected) -> {
            this.viewModel.selected_item().set(selected);
        });
	}


	/**
     * The type of the column is same as the TableView 
     * and the type of the content is an Object
     */ 
	private void generate_columns() {
        this.tableview.getColumns().clear();

        this.viewModel.getMapping_column_property().forEach( (column) -> {
            this.tableview.getColumns().add( create_column(column) );
        });
	}


	private TableColumn<T, Object> create_column(Column column) {

		TableColumn<T, Object> table_column = new TableColumn<>();
        table_column.setText( column.getColumn_name() );
		table_column.setCellValueFactory( new PropertyValueFactory<>(column.getProperty_name()) );

		return table_column;

	}

    public TableView<T> getTableview() {
		return tableview;
	}

}




