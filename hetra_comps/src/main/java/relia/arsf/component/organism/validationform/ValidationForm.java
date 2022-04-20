package relia.arsf.component.organism.validationform;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import relia.arsf.component.ComponentFactory;
import relia.arsf.component.atom.button.ButtonComponent;
import relia.arsf.component.atom.button.ButtonType;
import relia.arsf.component.atom.layout.LargeBox;
import relia.arsf.component.atom.layout.LargeVBox;
import relia.arsf.component.atom.layout.TinyHBox;
import relia.arsf.component.atom.layout.TinyVBox;
import relia.arsf.component.atom.text.TextComponent;
import relia.arsf.component.atom.text.TextType;
import relia.arsf.component.base.AComponent;
import relia.arsf.component.base.ComponentMountException;


/**
 * A form with title, button ok/cancel and some fields which
 * will be provided by other class
 */

@AComponent
public class ValidationForm extends LargeBox {

	// main container
	private final LargeVBox main_container = new LargeVBox("Main container box");

    private final TextComponent title_component = ComponentFactory.create_text(
            "Give me a title", TextType.TITLE);

    private final TinyVBox fields_container = ComponentFactory.create_tiny_vbox();

    private final ButtonComponent button_ok = ComponentFactory.create_button(
            "Valider", ButtonType.PRIMARY );
    private final ButtonComponent button_cancel = ComponentFactory.create_button(
            "Annuler", ButtonType.SECONDARY );

    private final TinyHBox button_container = ComponentFactory.create_tiny_hbox();


    public ValidationForm(String name) {
        super(name);
    }


    @Override
    public void initialize_component() {
        super.initialize_component();
        ((VBox) this.getView().getRoot_node()).setAlignment(Pos.TOP_CENTER);

		this.main_container.initialize_component();

        this.title_component.initialize_component();
        this.title_component.getViewModel().setAlignement( Pos.CENTER );

        this.fields_container.initialize_component();

        this.button_ok.initialize_component();
        this.button_cancel.initialize_component();
        this.button_container.initialize_component();
        ((HBox) this.button_container.getView().getRoot_node()).setAlignment( Pos.CENTER );


        try { mount_childrens(); }
        catch (ComponentMountException e) {
            e.printStackTrace();
        }
    }

    private void mount_childrens() throws ComponentMountException {
		getViewModel().mount( this.main_container );

		this.main_container.getViewModel().mount( this.title_component );
        this.main_container.getViewModel().mount( this.fields_container );
        this.main_container.getViewModel().mount( this.button_container );
        this.button_container.getViewModel().mount( this.button_cancel );
        this.button_container.getViewModel().mount( this.button_ok );

    }


    // getters

    public TextComponent getTitle_component() {
        return title_component;
    }

    public TinyVBox getFields_container() {
        return fields_container;
    }

    public ButtonComponent getButton_ok() {
        return button_ok;
    }

    public ButtonComponent getButton_cancel() {
        return button_cancel;
    }

    public TinyHBox getButton_container() {
        return button_container;
    }
}

