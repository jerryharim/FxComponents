package relia.arsf.component.atom.text;

import javafx.scene.control.Label;
import relia.arsf.component.base.MVVMView;
import relia.arsf.component.base.View;


@MVVMView
public class TextView extends View<TextViewModel> {

    private final Label text = new Label();;

	public TextView(TextViewModel viewModel) {
		super(viewModel);
		super.root_node = text;
	}

	@Override
	public void sync_with_view_model() {
        sync_text();
		sync_type();
		sync_alignement();
	}

	private void sync_alignement() {
		this.text.alignmentProperty().bind(
				this.viewModel.alignment() );
	}


	private void sync_text() {
		this.text.setText( this.viewModel.getText() );
		this.viewModel.text().addListener((obs, old, new_text) -> {
			this.text.setText( new_text );
		});
	}


	private void sync_type() {
	    update_type( this.viewModel.type().get() );

		this.viewModel.type().addListener( (obs, old, type) -> {
			update_type(type);
		});
	}


	private void update_type(TextType type) {
		if (type.equals(TextType.EMPHASE)) to_emphase(); 
		else if (type.equals(TextType.TITLE)) to_title(); 
		else if (type.equals(TextType.BIG_TITLE)) to_big_title(); 
	}

	private void to_emphase() {
		this.text.setStyle("-fx-font-weight : bold; -fx-text-fill: #161616;");
	}

	private void to_title() {
		this.text.setStyle("-fx-font-weight: bold; -fx-text-fill: #161616; -fx-padding: 18px");

		// to uppercase
		this.text.setText( this.text.getText().toUpperCase() );
		this.text.textProperty().addListener((obs, old, new_text) -> {
			this.text.setText(new_text.toUpperCase());
		});
	}

	private void to_big_title() {
		this.text.setStyle("-fx-font-size: 36px; -fx-font-weight: medium; -fx-text-fill: #161616; ");

		// to uppercase
		this.text.setText( this.text.getText() );
		this.text.textProperty().addListener((obs, old, new_text) -> {
			this.text.setText(new_text.toUpperCase());
		});
	}

}


