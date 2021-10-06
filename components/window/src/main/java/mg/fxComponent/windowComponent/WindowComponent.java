package mg.fxComponent.windowComponent;


import mg.fxComponent.base.Component;

public class WindowComponent extends Component<WindowComponentVM> {

    public WindowComponent() {
        super("/fxml/window.fxml",
                new WindowComponentView(new WindowComponentVM())
        );
    }

}
