package relia.arsf.component.atom.text;

import relia.arsf.component.base.AComponent;
import relia.arsf.component.base.Component;


@AComponent
public class TextComponent extends Component<TextViewModel> {

	public TextComponent(String component_name) {
		super( component_name, new TextView(new TextViewModel()));
	}

	public TextComponent(String component_name, String text, TextType type) {
		super(component_name, new TextView(new TextViewModel(text, type)));
	}
}
