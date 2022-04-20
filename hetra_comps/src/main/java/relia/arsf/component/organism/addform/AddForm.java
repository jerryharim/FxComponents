package relia.arsf.component.organism.addform;

import relia.arsf.component.base.FXMLComponent;


/**
 * Use to add new taxe payer
 */
public class AddForm extends FXMLComponent<AddFormViewModel> {

    public AddForm(String component_name) {
        super(
                component_name,
                "/organism/ajout_contribuable.fxml" ,
                new AddFormView(new AddFormViewModel())
        );
    }

}
