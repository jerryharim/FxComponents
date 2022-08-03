package relia.arsf.component.base;


@AComponent
public class FXMLSimpleComponent<M> extends FXMLComponent<M> {

	public FXMLSimpleComponent(String name, String view_path, View<M> view) {
		super(name, view_path, view);
	}

}
