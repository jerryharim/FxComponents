package relia.arsf.component.molecule.titlewithadd;

import relia.arsf.component.atom.button.ButtonComponent;
import relia.arsf.component.atom.button.ButtonType;
import relia.arsf.component.atom.title.TitleComponent;
import relia.arsf.component.base.ParentComponent;


/**
 * Title component with add button in the right 
 * side
 */ 

public class TitlePlusComponent extends ParentComponent<TitlePlusViewModel> {
    private final TitleComponent title = new TitleComponent("title");
    private final ButtonComponent button_plus = new ButtonComponent("Button plus");

    public TitlePlusComponent(String name) {
		super(
			name,
            new TitlePlusView(new TitlePlusViewModel())
        );
	}

	@Override
	public void initialize_childrens() {
	    this.title.initialize_component();
        this.button_plus.initialize_component();
        this.button_plus.getViewModel().setType( ButtonType.TRANSPARENT );
		this.button_plus.getViewModel().setText( "Ajouter" );
	}

	@Override
	public void mount_childrens() {
        mount_title();
	    mount_button_plus();
	}

	private void mount_title() {
	    ((TitlePlusView) this.view).mount_title(this.title.getView().getRoot_node());
	}

	private void mount_button_plus() {
	    ((TitlePlusView) this.view).mount_button_plus(this.button_plus.getView().getRoot_node());
	}

	// setters
	
	public void setText(String text) {
		this.title.getViewModel().text().set( text );
	}


    // getters

    public TitleComponent getTitle_component() {
        return title;
    }

    public ButtonComponent getButton_plus_component() {
        return button_plus;
    }

}
