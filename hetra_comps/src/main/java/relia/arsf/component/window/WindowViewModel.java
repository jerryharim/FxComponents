package relia.arsf.component.window;

import javafx.beans.property.*;
import relia.arsf.component.base.Component;
import relia.arsf.component.base.MVVMViewModel;
import relia.arsf.component.base.ViewModel;
import relia.arsf.component.page.splash.SplashComponent;


@MVVMViewModel
public class WindowViewModel extends ViewModel {
    private final BooleanProperty pressed_close_button = new SimpleBooleanProperty();
    private final BooleanProperty pressed_minimize_button = new SimpleBooleanProperty();
    private final BooleanProperty pressed_maximize_button = new SimpleBooleanProperty();

    private final StringProperty window_title = new SimpleStringProperty("");
    private final StringProperty username = new SimpleStringProperty("");

    private final ObjectProperty<Component<?>> content_center = new SimpleObjectProperty<>();
    private final ObjectProperty<Component<?>> content_left = new SimpleObjectProperty<>();
    private final ObjectProperty<Component<?>> content_right = new SimpleObjectProperty<>();
    private final ObjectProperty<Component<?>> current_popup = new SimpleObjectProperty<>();
    private boolean full_opaque;


    // popups
    
    public void show_popup(Component<?> component) {
        this.current_popup.set(component);
    }

    public void show_popup(SplashComponent splash, boolean full_opaque) {
        this.full_opaque = full_opaque;
        show_popup( splash );
    }

    public ObjectProperty<Component<?>> content_right() {
		return content_right;
	}

	public void close_popup() {
        this.current_popup.set(null);
    }


    // window actions

    public void press_maximize_window_button() {
        this.pressed_maximize_button.set(true);
    }

    public void press_minimize_window_button() {
        this.pressed_minimize_button.set(true);
    }

    public void press_close_window_button() {
        this.pressed_close_button.set(true);
    }

    // change content

    public void change_content_center( Component<?> component ) {
        this.content_center.set( component );
    }

    public void change_content_left( Component<?> component ) {
        this.content_left.set( component );
    }


    // getters

    public BooleanProperty pressed_close_button() {
        return pressed_close_button;
    }

    public BooleanProperty pressed_minimize_button() {
        return pressed_minimize_button;
    }

    public BooleanProperty pressed_maximize_button() {
        return pressed_maximize_button;
    }

    public ObjectProperty<Component<?>> current_popup() {
        return current_popup;
    }

    public ObjectProperty<Component<?>> content_center() {
        return content_center;
    }

    public ObjectProperty<Component<?>> content_left() {
        return content_left;
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty window_title_Property() {
        return window_title;
    }

    public void set_window_title(String title) {
        this.window_title.set(title);
    }

    public boolean isFull_opaque() {
        return full_opaque;
    }
}


