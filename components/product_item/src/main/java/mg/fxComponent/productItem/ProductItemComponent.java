package mg.fxComponent.productItem;


import mg.fxComponent.base.Component;

public class ProductItemComponent extends Component<ProductItemVM> {

    public ProductItemComponent(
            String name,
            String price,
            String quantity_available,
            int quantity_selected) {

        super( "/fxml/product_item.fxml",
                new ProductItemView(
                        new ProductItemVM(
                                name,
                                price,
                                quantity_available,
                                quantity_selected
                        )
                )
        );
    }

}
