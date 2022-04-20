package relia.arsf.component.molecule.box;

import relia.arsf.component.base.AComponent;
import relia.arsf.component.base.ComponentMountException;
import relia.arsf.component.base.DirectChildrens;
import relia.arsf.component.ComponentFactory;
import relia.arsf.component.atom.layout.SmallVBox;
import relia.arsf.component.atom.layout.TinyVBox;
import relia.arsf.component.atom.text.TextComponent;
import relia.arsf.component.atom.text.TextType;


/**
 * A group of componend.
 * It have a name and one or more childrens inside
 * */

@AComponent
public class GroupBox extends SmallVBox implements DirectChildrens {
	private final TextComponent group_name = ComponentFactory.create_text("Group name", TextType.EMPHASE);
	private final TinyVBox content = ComponentFactory.create_tiny_vbox();


	public GroupBox(String name) {
		super(name);
	}


	@Override
	public void initialize_component() {
		super.initialize_component();
		initialize_childrens();

		try {
			mount_childrens();
		} catch (ComponentMountException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void initialize_childrens() {
		this.group_name.initialize_component();
		this.content.initialize_component();
	}


	@Override
	public void mount_childrens() throws ComponentMountException {
		getViewModel().mount( this.group_name );	
		getViewModel().mount( this.content );	
	}


	// getters 
	
	public TextComponent getGroup_name() {
		return group_name;
	}


	public TinyVBox getContent() {
		return content;
	}

	
}

