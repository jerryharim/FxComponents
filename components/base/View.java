package relia.arsf.component.base;

import javafx.scene.Node;


/**
 * Super class for all view 
 * @param <M> : M represent a ViewModel Class
 */

@MVVMView
public abstract class View<M> {
    protected M viewModel;
    protected Node root_node;
    private Component<?> component;

    public View(M viewModel) {
        this.viewModel = viewModel;
    }
    

    /**
     * Used to synchronize view Nodes property 
     * with the view model
     */ 
    public abstract void sync_with_view_model();


    // getters

    public M getViewModel() {
        return viewModel;
    }

    public Node getRoot_node() {
        if ( ((ViewModel) this.viewModel).getState().equals(ComponentState.NOT_YET_READY) ) {
            System.err.println(String.format("[ERROR] '%s' is not ready, you must initialize it",
                    getComponent().getName()));
            System.exit(1);
        }
        return this.root_node;
    }

    public Component<?> getComponent() {
        return component;
    }

    public void setComponent(Component<?> component) {
        this.component = component;
    }

}
