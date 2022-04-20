package relia.arsf.component.molecule.box;

import relia.arsf.component.ComponentFactory;
import relia.arsf.component.atom.layout.MediumVBox;
import relia.arsf.component.atom.text.TextComponent;
import relia.arsf.component.atom.text.TextType;
import relia.arsf.component.base.AComponent;
import relia.arsf.component.base.ComponentMountException;


/**
 * A Medium vertical box with a title.
 * It can contain one ore many childrens as items.
 */

@AComponent
public class TitledBox extends MediumVBox {
    protected final TextComponent title = ComponentFactory.create_text("Give me a title", TextType.TITLE);

    public TitledBox(String name) {
        super(name);
    }

    @Override
    public void initialize_component() {
        super.initialize_component();
        this.title.initialize_component();

        try { getViewModel().mount( this.title ); }
        catch (ComponentMountException e) { e.printStackTrace(); }
    }
}
