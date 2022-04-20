package relia.arsf.component.atom.layout;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import relia.arsf.component.base.Component;
import relia.arsf.component.base.ComponentMountException;
import relia.arsf.component.base.ComponentState;
import relia.arsf.component.base.ViewModel;


/**
 * A layout is a component that can contain other
 * with a specific padding and spacing
 */
public abstract class LayoutViewModel extends ViewModel {

    protected final ObservableList<Component<?>> childrens = FXCollections.observableArrayList();

    private final ObjectProperty<Insets> padding = new SimpleObjectProperty<>(new Insets(0));
    private final IntegerProperty spacing = new SimpleIntegerProperty();


    /**
     * Use this to add children for more
     * control
     * */
    public void mount(Component<?> component) throws ComponentMountException {
        if (component == null) {
            throw new ComponentMountException("You must specify a non null Component");

        } else if ( is_not_ready(component)) {
            throw new ComponentMountException(
                    String.format("NOT READY : '%s', please initialize synchronisation between " +
                                    "view and veiw model of the component\n",
                            component,
                            this
                    )
            );

        } else this.childrens.add(component);
    }


    // properties

    private boolean is_not_ready(Component<?> component) {
        return ((ViewModel) component.getViewModel())
                .getState() != ComponentState.READY;
    }

    public ObservableList<Component<?>> getChildrens() {
        return childrens;
    }


    // properties

    public ObjectProperty<Insets> padding() {
        return padding;
    }

    public IntegerProperty spacing() {
        return spacing;
    }

}
