package relia.arsf.component.molecule.titlewithadd;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import relia.arsf.component.base.View;


public class TitlePlusView extends View<TitlePlusViewModel> {
    private final HBox root = new HBox(); 

    public TitlePlusView(TitlePlusViewModel viewModel) {
		super(viewModel);
        super.root_node = this.root;
        this.root.setAlignment(Pos.CENTER_LEFT);
	}

	@Override
	public void sync_with_view_model() {
	}


    public void mount_button_plus(Node node) {
        this.root.getChildren().add(1, node);
    }

    public void mount_title(Node node) {
        VBox container = new VBox();
        container.setMaxWidth( Double.MAX_VALUE );
        HBox.setHgrow(container, Priority.ALWAYS);

        container.getChildren().add(node);
        this.root.getChildren().add(0, container);
    }
}
