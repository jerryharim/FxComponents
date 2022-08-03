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
		stage.setTitle("FxComponents test");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
