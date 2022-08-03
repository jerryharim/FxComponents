package relia.arsf.component.base;


/**
 * A component that can content one or many other components.
 * ViewModelType represent the type of the ViewModel.
 */

@AComponent
public abstract class ParentComponent<ViewModelType> extends Component<ViewModelType> {

    public ParentComponent(String name, View<ViewModelType> view) {
		super(name, view);
	}

    @Override
    public void initialize_component() {
        super.initialize_component();

        initialize_childrens();
        mount_childrens();
    }


	public abstract void initialize_childrens();

	public abstract void mount_childrens();

}
