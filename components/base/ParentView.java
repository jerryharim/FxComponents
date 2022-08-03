package relia.arsf.component.base;

import javafx.scene.Parent;

/**
 * ViewModelType represent the type of the ViewModel.
 * Parent type represent the type of the main container
 * of this parent view.
 */ 

public abstract class ParentView<ViewModelType, ParentType> extends View<ViewModelType> {
    protected ParentType root_container;

    public ParentView(ViewModelType viewModel, ParentType container) {
		super(viewModel);
        this.root_container = container;
        this.root_node = (Parent) this.root_container;

        configure_container();
	}

    public abstract void configure_container(); 

}
