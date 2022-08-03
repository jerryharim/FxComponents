package mg.fxComponent.windowComponent;

import javafx.beans.property.*;
import javafx.scene.Node;
import mg.fxComponent.base.MVVMViewModel;
import mg.fxComponent.base.ViewModel;


@MVVMViewModel
public class WindowComponentVM extends ViewModel {
    private final BooleanProperty pressed_close_button = new SimpleBooleanProperty();
    private final ObjectProperty<Node> content = new SimpleObjectProperty<>();
    private final ObjectProperty<Node> current_popup = new SimpleObjectProperty<>();
    private final StringProperty username = new SimpleStringProperty();


    public void show_popup(Node node) {
        this.current_popup.set(node);
    }

    public void close_popup() {
        this.current_popup.set(null);
    }


    // getters

    public BooleanProperty pressed_close_button() {
        return pressed_close_button;
    }

    public ObjectProperty<Node> current_popup() {
        return current_popup;
    }

    public ObjectProperty<Node> content() {
        return content;
    }

    public StringProperty usernameProperty() {
        return username;
    }
}
