package relia.arsf.component.atom.title;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import relia.arsf.component.base.MVVMView;
import relia.arsf.component.base.View;


@MVVMView
public class TitleView extends View<TitleViewModel> {

    @FXML private Label text;

	public TitleView(TitleViewModel viewModel) {
		super(viewModel);
	}

	@Override
	public void sync_with_view_model() {
        sync_text();
	}

	private void sync_text() {
        this.viewModel.text().addListener((obs,old,text) -> {
            this.text.setText(text.toUpperCase());
        });
	}

}
