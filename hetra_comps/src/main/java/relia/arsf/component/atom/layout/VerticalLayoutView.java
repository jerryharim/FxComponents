package relia.arsf.component.atom.layout;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.VBox;
import relia.arsf.component.base.Component;
import relia.arsf.component.base.ParentView;



public class VerticalLayoutView extends ParentView<VerticalLayoutViewModel, VBox> {

	public VerticalLayoutView(VerticalLayoutViewModel viewModel) {
		super(viewModel, new VBox());
	}

	@Override
	public void configure_container() {
	}

	@Override
	public void sync_with_view_model() {
		sync_configurations();
		sync_childrens();	
	}

	private void sync_configurations() {
		sync_padding();
		sync_spacing();
	}

	private void sync_padding() {
		this.root_container.paddingProperty().bind(this.viewModel.padding());
	}

	private void sync_spacing() {
		this.root_container.spacingProperty().bind(this.viewModel.spacing());
	}


	private void sync_childrens() {
		this.viewModel.getChildrens().addListener((ListChangeListener<Component<?>>) change -> {
			while (change.next()) {
				if (change.wasAdded()) change.getAddedSubList().forEach(this::add_children);
				else if (change.wasRemoved()) change.getRemoved().forEach(this::remove_children);
			}
		});
	}

	private void add_children(Component<?> children) {
		this.root_container.getChildren().add( children.getView().getRoot_node() );
	}

	private void remove_children(Component<?> children) {
		this.root_container.getChildren().remove( children.getView().getRoot_node() );
	}

}
