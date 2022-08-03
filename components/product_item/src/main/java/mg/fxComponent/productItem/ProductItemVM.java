package mg.fxComponent.productItem;

import javafx.beans.property.*;
import mg.fxComponent.base.MVVMView;
import mg.fxComponent.base.ViewModel;


@MVVMView
public class ProductItemVM extends ViewModel {
    private final StringProperty name;
    private final StringProperty price;
    private final StringProperty quantity_available;
    private final IntegerProperty quantity_selected;
    private BooleanProperty quantity_selected_visible;
    private final BooleanProperty root_container_pressed = new SimpleBooleanProperty();


    public ProductItemVM(
            String name, String price, String quantity_available) {

        this(name, price, quantity_available, 0, false);
    }

    public ProductItemVM(
            String name, String price, String quantity_available, int quantity_selected) {

        this(name, price, quantity_available, quantity_selected, false);
    }

    public ProductItemVM(
            String name, String price, String quantity_available, int quantity_selected, boolean quantity_visible) {

        this.name = new SimpleStringProperty(name);
        this.price = new SimpleStringProperty(price);
        this.quantity_available = new SimpleStringProperty(quantity_available);
        this.quantity_selected = new SimpleIntegerProperty(quantity_selected);
        this.quantity_selected_visible = new SimpleBooleanProperty(quantity_visible);
    }


    // getters

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty priceProperty() {
        return price;
    }

    public StringProperty quantity_availableProperty() {
        return quantity_available;
    }

    public IntegerProperty quantity_selectedProperty() {
        return quantity_selected;
    }

    public BooleanProperty onRootContainerPressed() {
        return root_container_pressed;
    }

    public BooleanProperty quantity_selected_visibleProperty() {
        return quantity_selected_visible;
    }
}
