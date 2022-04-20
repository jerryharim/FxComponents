package relia.arsf.component.window;

import relia.arsf.component.base.AComponent;
import relia.arsf.component.base.FXMLComponent;


@AComponent
public class WindowComponent extends FXMLComponent<WindowViewModel> {

    public WindowComponent(String name) {
        super(
			      name,
            "/fxml/window.fxml",
            new WindowView(new WindowViewModel())
        );
    }

    public void startLoading(){
      ((WindowView)this.getView()).startLoading();
    }
}
