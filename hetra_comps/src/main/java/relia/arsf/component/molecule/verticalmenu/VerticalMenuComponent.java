package relia.arsf.component.molecule.verticalmenu;

import relia.arsf.component.base.FXMLComponent;

/**
 * Affiche et met à jour le menu en cours
 */ 

public class VerticalMenuComponent extends FXMLComponent<VerticalMenuViewModel> {

    public VerticalMenuComponent(String name) {
        super(
			name,
			"/fxml/vertical_menu.fxml",
			new VerticalMenuView(new VerticalMenuViewModel())
        );
    }

}
