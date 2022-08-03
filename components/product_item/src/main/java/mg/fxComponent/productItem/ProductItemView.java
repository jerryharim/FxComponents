package mg.fxComponent.productItem;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import mg.fxComponent.base.EasyBinding;
import mg.fxComponent.base.View;


public class ProductItemView extends View<ProductItemVM> {
    @FXML private ImageView img_product;
    @FXML private Label lab_name;
    @FXML private Label lab_rest;
    @FXML private Label lab_price;
    @FXML private Label lab_count;
    @FXML private StackPane counter_container;
    @FXML private AnchorPane root_container;

    public ProductItemView(ProductItemVM viewModel) {
        super(viewModel);
    }

    @Override
    public void sync_with_view_model() {
        sync_name();
        sync_rest();
        sync_price();
        sync_count();
        sync_counter_container_visibilty();
        sync_root_container_clicked();
    }

    private void sync_counter_container_visibilty() {
        this.counter_container.visibleProperty().bind(
                this.viewModel.quantity_selected_visibleProperty());
    }

    private void sync_root_container_clicked() {
        this.root_container.pressedProperty().addListener((obs, old, pressed) -> {
            this.viewModel.onRootContainerPressed().set(pressed);
        });
    }

    private void sync_name() {
        EasyBinding.bindLab(this.lab_name, this.viewModel.nameProperty());
    }

    private void sync_rest() {
        EasyBinding.bindLab(this.lab_rest, this.viewModel.quantity_availableProperty());
    }

    private void sync_price() {
        EasyBinding.bindLab(this.lab_price, this.viewModel.priceProperty());
    }

    private void sync_count() {
        EasyBinding.bindLab(this.lab_count, this.viewModel.quantity_selectedProperty());
    }

}
