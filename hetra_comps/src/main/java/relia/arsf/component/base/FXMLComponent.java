package relia.arsf.component.base;

import java.io.IOException;

import javafx.fxml.FXMLLoader;


/**
 * FXML component. M represent a ViewModel.
 * A component regroupe a View, Path of the view and
 * the instance of the node.
 *
 * Will be obsolte because the method and the synchronsation 
 * is done by the FXMLView who extend View
 */

@AComponent
public class FXMLComponent<M> extends Component<M> {

    protected final String view_path;

    public FXMLComponent(String component_name, String view_path, View<M> view) {
        super(component_name, view);
        this.view_path = view_path;
    }


	@Override
	public void initialize_component() {
        load_fxml();
        super.initialize_component();
	}


    /**
     * Load the fxml and
     * synchronise View (the controller in this case)
     * with the ViewModel.
     */
    public void load_fxml() {

        FXMLLoader fxml_loader = new FXMLLoader(getClass().getResource(this.view_path));
        fxml_loader.setController(this.view);

        try {
            super.view.root_node = fxml_loader.load();

        } catch (IllegalStateException e) {
            System.err.printf("[ERROR] Location '%s' is not set%n", this.view_path);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

