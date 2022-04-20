package relia.arsf.component.molecule.box;

import relia.arsf.component.ComponentFactory;
import relia.arsf.component.atom.layout.LargeBox;
import relia.arsf.component.atom.layout.MediumBoxLeftRight;
import relia.arsf.component.atom.layout.SmallVBox;
import relia.arsf.component.atom.layout.TinyVBox;
import relia.arsf.component.atom.text.TextComponent;
import relia.arsf.component.atom.text.TextType;
import relia.arsf.component.base.AComponent;
import relia.arsf.component.base.ComponentMountException;


/**
 * A Tiny Box with a title
 * */

@AComponent
public class BoxWithTitle extends TinyVBox {

	private final MediumBoxLeftRight title_container 
		= ComponentFactory.create_medium_box_left_right();

	private final TextComponent title = ComponentFactory.create_text("", TextType.TITLE);

	private final LargeBox content_container = ComponentFactory.create_large_box();
	private final SmallVBox content = ComponentFactory.create_small_vbox();


	public BoxWithTitle(String name) { 
		this(name, "Give me a title");
	}


	public BoxWithTitle(String name, String title) {
		super(name);
		this.title.getViewModel().setText( title );
    }


    @Override
	public void initialize_component() {
		super.initialize_component();	

		this.title_container.initialize_component();
		this.title.initialize_component();

		this.content_container.initialize_component();
		this.content.initialize_component();

		
		try { 
			this.title_container.getViewModel().mount( this.title );
			getViewModel().mount( this.title_container );	

			this.content_container.getViewModel().mount( this.content );
			getViewModel().mount( this.content_container );	

		} catch (ComponentMountException e) {
			e.printStackTrace(); 
		}

		this.content_container.getView().getRoot_node().setStyle("-fx-background-color: white; -fx-background-radius: 5px");
	}


	@Override
	public void debug() {
		this.title.debug();
		this.content.debug();
		this.title_container.debug();
		this.content_container.debug();
	}


	// getters 
	
	public TextComponent getTitle() {
		return title;
	}


	public SmallVBox getContent() {
		return content;
	}

}
