package relia.arsf.component.base;

/**
 * Super type for all kind of component
 */ 

@AComponent
public abstract class Component<ViewModelType> {

    protected String name;
    protected final View<ViewModelType> view;
    protected Object user_data;

    public Component(String name, View<ViewModelType> view) {
		this.name = name;
        this.view = view;
        this.view.setComponent(this);
    }

	/**
	 * Synchronize the view associate with the 
	 * view model of this component.
	 * Here we don't do direct action like 
	 * mounting or configuring components children, ...
	 * */
    public void initialize_component() {
        this.view.sync_with_view_model();
        change_component_state_to_ready();
    }

    public void change_component_state_to_ready() {
        ((ViewModel) this.view.viewModel).state.set(ComponentState.READY);
        if (this.name.equals("Splash screen"))
            System.out.println("[i] INFO : state " +this.name+ ": " + ((ViewModel) this.view.viewModel).state.get());
	}


	public void debug() {
		getView().getRoot_node().setStyle("-fx-border-color: red");
	}


    // getters

	public View<ViewModelType> getView() {
        return this.view;
    }

    public ViewModelType getViewModel() {
        return this.view.getViewModel();
    }

    public void setUserData(Object object) {
        this.user_data = object;
    }

    public Object getUserData() {
        return user_data;
    }

	/**
	 * Retrun the name of the component
	 */
	public String getName() {
		return this.name; 
	}

	@Override
	public String toString() {
		return getName();
	}
}
