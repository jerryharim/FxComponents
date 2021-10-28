package mg.salesManagement.core;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mg.fxComponent.productItem.ProductItemComponent;
import mg.fxComponent.windowComponent.WindowComponent;

import java.util.ArrayList;
import java.util.List;


public class Main extends Application {
    int price = 1500;
    final String name = "Soupe chinoise";
    IntegerProperty qa = new SimpleIntegerProperty(100);
    IntegerProperty qs = new SimpleIntegerProperty();

    public void hellobaina(String baina) {
        System.out.println("hello world " + baina);
    }


    @Override
    public void start(Stage stage) throws Exception {

        // data
        Product chickenFried = new Product("Chicken Fried Steak & Eggs", 13, 10);
        Product bananaMacadamiaNutPancakes = new Product("Banana Macadamia Nut Pancakes", 11, 20);
        Product frenchToastCombo = new Product("French Toast Combo", 10, 30);

        final List<Product> products = new ArrayList<>();
        products.add(chickenFried);
        products.add(bananaMacadamiaNutPancakes);
        products.add(frenchToastCombo);


        // COMPONENTS --------------

        // window
        WindowComponent window = new WindowComponent();
        window.getViewModel().pressed_close_button().addListener((obs, old, pressed) -> {
            if (pressed) {
                Platform.exit();
            }
        });

        FlowPane product_container = new FlowPane(10, 10);

        products.forEach(product -> {
            ProductItemComponent productItemComponent = create_product(product);
            productItemComponent.load();
            productItemComponent.setUserData(product);
            product_container.getChildren().add(productItemComponent.getNode());

            productItemComponent.getViewModel().onRootContainerPressed().addListener((obs, old, pressed) -> {
                if (pressed) pressed_item_component(productItemComponent);
            });
        });


        VBox root = new VBox();
        window.load();
        window.getViewModel().content().set(product_container);

        root.getChildren().add(window.getNode());

        stage.setScene(new Scene(root));
        stage.show();
    }

    private void pressed_item_component(ProductItemComponent productItemComponent) {
        Product product = (Product) productItemComponent.getUserData();
        int new_qty_in_stock = product.getQtyInStock() - 1;
        product.setQtyInStock(new_qty_in_stock);

        update_display_stock(productItemComponent, new_qty_in_stock);
        increment_item_selected(productItemComponent);
        make_visible_counter(productItemComponent);
    }

    private void make_visible_counter(ProductItemComponent productItemComponent) {
        productItemComponent.getViewModel().quantity_selected_visibleProperty().set(true);
    }

    private void increment_item_selected(ProductItemComponent productItemComponent) {
        productItemComponent.getViewModel().quantity_selectedProperty().set(
                productItemComponent.getViewModel().quantity_selectedProperty().get() + 1
        );
    }

    private void update_display_stock(ProductItemComponent productItemComponent, int qty) {
        productItemComponent.getViewModel().quantity_availableProperty().set(""+qty+" remainings");
    }

    private ProductItemComponent create_product(Product product) {
        return new ProductItemComponent(
                product.getName(),
                product.getPrice()+" $",
                ""+ product.getQtyInStock(),
                0
        );
    }

    private void update_window_username(WindowComponent window) {
        String apayer = "Total to pay : " + (price * qs.get()) + " $";
        window.getViewModel().usernameProperty().set(apayer);
    }
}
