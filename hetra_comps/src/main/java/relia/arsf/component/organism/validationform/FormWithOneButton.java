package relia.arsf.component.organism.validationform;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import relia.arsf.component.ComponentFactory;
import relia.arsf.component.atom.button.ButtonComponent;
import relia.arsf.component.atom.button.ButtonType;
import relia.arsf.component.atom.layout.LargeVBox;
import relia.arsf.component.atom.layout.TinyHBox;
import relia.arsf.component.atom.layout.TinyVBox;
import relia.arsf.component.atom.text.TextComponent;
import relia.arsf.component.atom.text.TextType;
import relia.arsf.component.base.AComponent;
import relia.arsf.component.base.ComponentMountException;


/**
 * A form with title, button ok and some fields which
 * will be provided by other class
 */

@AComponent
public class FormWithOneButton extends LargeVBox {
    private final TextComponent title_component = ComponentFactory.create_text(
            "Give me a title", TextType.TITLE);

    private final TinyVBox content = ComponentFactory.create_tiny_vbox();

    private final ButtonComponent button_ok = ComponentFactory.create_button(
            "Valider", ButtonType.PRIMARY );

    private final TinyHBox button_container = ComponentFactory.create_tiny_hbox();


    public FormWithOneButton(String name) {
        super(name);
    }


    @Override
    public void initialize_component() {
        super.initialize_component();
        ((VBox) this.getView().getRoot_node()).setAlignment(Pos.TOP_CENTER);

        this.title_component.initialize_component();
        this.title_component.getViewModel().setAlignement( Pos.CENTER );

        this.content.initialize_component();

        this.button_ok.initialize_component();
        this.button_container.initialize_component();
        ((HBox) this.button_container.getView().getRoot_node()).setAlignment( Pos.CENTER );


        try { mount_childrens(); }
        catch (ComponentMountException e) {
            e.printStackTrace();
        }
    }

    private void mount_childrens() throws ComponentMountException {
        this.button_container.getViewModel().mount( this.button_ok );

        getViewModel().mount( this.title_component);
        getViewModel().mount( this.content);
        getViewModel().mount( this.button_container );
    }


    // getters

    public TextComponent getTitle_component() {
        return title_component;
    }

    public TinyVBox getContent() {
        return content;
    }

    public ButtonComponent getButton_ok() {
        return button_ok;
    }

    public TinyHBox getButton_container() {
        return button_container;
    }
}

