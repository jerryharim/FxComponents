package relia.arsf.component.organism.editablebox;

import java.util.Optional;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import relia.arsf.component.atom.layout.SmallVBox;
import relia.arsf.component.atom.layout.TinyVBox;
import relia.arsf.component.atom.button.ButtonComponent;
import relia.arsf.component.atom.button.ButtonType;
import relia.arsf.component.base.*;
import relia.arsf.component.molecule.titlewithadd.TitlePlusComponent;


/**
 * A box with a title. the content can be changed using
 * an add button plus.
 */

@AComponent
public class EditableBoxComponent extends SmallVBox implements DirectChildrens {

	private final TitlePlusComponent title_container = new TitlePlusComponent("Title container editable box component");

	private final TinyVBox items_container = new TinyVBox("Items container editable box component");
	private final ObservableList<Item> items = FXCollections.observableArrayList();
	private final ObjectProperty<ButtonComponent> selected_item = new SimpleObjectProperty<>();


    public EditableBoxComponent(String name) {
		super(name);
	}


	@Override
	public void initialize_component() {
		super.initialize_component();

		initialize_childrens();
		listen_childrens_events();
		try {
			mount_childrens();
		} catch (ComponentMountException e) {
			e.printStackTrace();
		}
	}
	


	@Override
	public void initialize_childrens() {
		this.title_container.initialize_component();
		this.items_container.initialize_component();
	}

	@Override
	public void mount_childrens() throws ComponentMountException {
		getViewModel().mount( this.title_container );
		getViewModel().mount( this.items_container );
	}


	private void listen_childrens_events() {
		listen_items();
		listen_selected_item();
	}


	private void listen_items() {
		this.items.addListener( (ListChangeListener<Item>) change -> {
			while (change.next()) {
				if (change.wasAdded()) change.getAddedSubList().forEach( item -> {
					try {
						add_in_items_container(item);
					} catch (ComponentMountException e) {
						e.printStackTrace();
					}
				});
				else if (change.wasRemoved()) change.getRemoved().forEach(this::remove_from_items_container);
			}
		});
	}


	public void add_in_items_container( Item item ) throws ComponentMountException {
		ButtonComponent item_view = create_button_transparent(item);

		item_view.getViewModel().clicked().addListener((obs,old,clicked) -> {
			if (clicked) this.selected_item.set( item_view );
		});

		this.items_container.getViewModel().mount( item_view );
	}


	private ButtonComponent create_button_transparent(Item item) {
		ButtonComponent item_view = new ButtonComponent(
				"Button item",
				item.getText(),
				ButtonType.TRANSPARENT
		);
		item_view.initialize_component();

		item_view.getViewModel().width().set( Double.MAX_VALUE );
		item_view.getViewModel().user_data().set( item );
		return item_view;
	}


	private void listen_selected_item() {
		this.selected_item.addListener((obs, last_selected_item, selected_item) -> {
			if (last_selected_item != null) deselect_item( last_selected_item );
			if (selected_item != null) select_item( selected_item );
		});
	}


	/**
	 * Remove node who have this item as user data 
	 * from items_container children 
	 */
	private void remove_from_items_container( Item item ) {
		Optional<Component<?>> item_component = find_children_with_item(item);
		if( item_component.isPresent() ) remove_children( item_component.get() );
	}

	private Optional<Component<?>> find_children_with_item(Item item) {
		return this.items_container.getViewModel().getChildrens()
			.stream()
			.filter( node -> node.getUserData().equals(item) )
			.findFirst();
	}

	/**
	 * Remove children (a Component) from items 
	 * container component
	 */
	private void remove_children(Component<?> component) {
		this.items_container.getViewModel()
		.getChildrens()
		.remove( component );
	}


	/**
	 * Change the given ButtonComponent type to 
	 * ButtonType.SECONDARY
	 */
	private void select_item( ButtonComponent button_component ) {
		button_component.getViewModel().setButton_type( ButtonType.SECONDARY );
	}

	
	/**
	 * Change the given ButtonComponent type to 
	 * ButtonType.TRANSPARENT
	 */
	private void deselect_item( ButtonComponent button_component ) {

		if (this.selected_item.get() != null)  
			button_component.getViewModel().setButton_type( ButtonType.TRANSPARENT );

	}


	// getters

	public TinyVBox getItems_container() {
		return items_container;
	}

	public TitlePlusComponent getTitle_container() {
		return title_container;
	}

	public ObservableList<Item> getItems() {
		return items;
	}

	public ObjectProperty<ButtonComponent> selected_item() {
		return selected_item;
	}

}


