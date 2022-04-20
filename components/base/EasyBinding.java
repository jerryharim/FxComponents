package relia.arsf.component.base;

import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.*;
import javafx.util.converter.NumberStringConverter;

import java.time.LocalDate;


/**
 * A easy way to use binding
 */
public abstract class EasyBinding {
    /**
     * Bind a label text property with another StringProperty
     * @param label
     * @param bindWith
     */
    public static void bindLab(Label label, StringProperty bindWith) {
        label.textProperty().bind( bindWith );
    }

    /**
     * Bind a label text property with a IntegerProperty
     * @param label
     * @param bindWith
     */
    public static void bindLab(Label label, IntegerProperty bindWith) {
        label.textProperty().bind( Bindings.concat(bindWith) );
    }

    /**
     * Bind bidirectional a TextField text property with and IntegerProperty
     * @param textfield
     * @param bindWith
     */
    public static void bindBidirecText(TextField textfield, IntegerProperty bindWith) {
        Bindings.bindBidirectional(
                textfield.textProperty(),
                bindWith,
                new NumberStringConverter()
        );
    }

    /**
     * Bind bidirectional a TextField text property with and StringProperty
     * @param textfield
     * @param bindWith
     */
    public static void bindBidirecText(TextField textfield, StringProperty bindWith) {
        Bindings.bindBidirectional(
                textfield.textProperty(),
                bindWith
        );
    }

    /**
     * Bind bidirectional a DatePicker text property with and ObjectProperty<LocalDate>
     * @param datePicker
     * @param bindWith
     */
    public static void bindBidirecTf(DatePicker datePicker, ObjectProperty<LocalDate> bindWith) {
        Bindings.bindBidirectional(
                datePicker.valueProperty(),
                bindWith
        );
    }

    /**
     * Bind bidirectional a PasswordField text property with and StringProperty
     * @param passwordField
     * @param bindWith
     */
    public static void bindBidirecPf(PasswordField passwordField, StringProperty bindWith) {
        Bindings.bindBidirectional(
                passwordField.textProperty(),
                bindWith
        );
    }

    /**
     * Bind a label text property with a IntegerProperty
     * @param button
     * @param bindWith
     */
    public static void bindDisable(Button button, BooleanProperty bindWith) {
        button.disableProperty().bind( bindWith );
    }

    /**
     * Bind a label text property with a IntegerProperty
     * @param toggle
     * @param bindWith
     */
    public static void bindDisable(ToggleButton toggle, BooleanProperty bindWith) {
        toggle.disableProperty().bind( bindWith );
    }

    /**
     * Bind pressed state of the button with given BooleanProperty
     * @param button
     * @param bindWith
     */
    public static void bindPressed(Button button, BooleanProperty bindWith) {
        bindWith.bind(button.pressedProperty());
    }

    /**
     * Bind pressed state of the toggle button with given BooleanProperty
     * @param button
     * @param bindWith
     */
    public static void bindPressed(ToggleButton button, BooleanProperty bindWith) {
        bindWith.bind(button.pressedProperty());
    }

    /**
     * Bind visibility of the textfield with the specified BooleanProperty
     * @param textfield
     * @param bindWith
     */
    public static void bindVisibility(TextField textfield, BooleanProperty bindWith) {
        textfield.visibleProperty().bind(bindWith);
    }
}
