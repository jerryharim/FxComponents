package relia.arsf.component.base;


/**
 * A ParentComponent is a Component that
 * have on or more Component childrens
 */ 

@AComponent
public abstract class FXMLParentComponent<M> extends FXMLComponent<M> {

	public FXMLParentComponent(String name, String view_path, View<M> view) {
		super(name, view_path, view);
	}


	@Override
	public void initialize_component() {
	    initialize_childrens();
        mount_childrens();
	}

	public abstract void initialize_childrens();

	public abstract void mount_childrens();

}
