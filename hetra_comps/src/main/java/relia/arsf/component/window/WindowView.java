package relia.arsf.component.window;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;
import relia.arsf.component.base.Component;
import relia.arsf.component.base.MVVMView;
import relia.arsf.component.base.View;
import relia.arsf.component.data.TaskpayerProvider;
import relia.arsf.component.StateManagerFactory;
import relia.global.Global;


@MVVMView
public class WindowView extends View<WindowViewModel> {
  @FXML private StackPane root;
  @FXML private BorderPane body_container;
  @FXML private VBox left_container, right_container, center_container;
  @FXML private VBox popupbox;
  @FXML private HBox header;
  @FXML private HBox popgrandpa;
  @FXML private MenuButton usermenu;
  double dragX = 0;
  double dragY = 0;
  Rectangle2D defSize = null;
  @FXML private Button close_window_button,
      button_add,
      minimize_window_button,
      maximize_window_button;

  @FXML private Label lab_username, lab_deconnexion;


  public WindowView(WindowViewModel viewModel) {
    super(viewModel);
  }

  void initViewUser(){
    usermenu.getItems().clear();
    usermenu.setText(Global.getCommune());
    maximize_window_button.setOnAction(e -> {
      toggleMax();
    });
    minimize_window_button.setOnAction(e -> {
      Stage stg = (Stage) minimize_window_button.getScene().getWindow();
      stg.setIconified(true);
    });
  }

  public void startLoading(){
    initViewUser();
	  init_state_manager_contents();
  }


  public void init_state_manager_contents() {
    //load_taskpayer_list();
  }

private void load_taskpayer_list() {
	StateManagerFactory.getTaxepayer_page_state_manager()
		.getTaxepayerLists().setAll(
			TaskpayerProvider.load_taxepayer_list()
	);
}
				

  @Override
  public void sync_with_view_model() {
    Popup.Companion.init(popupbox, popgrandpa);
    sync_username();
    send_window_states();
    sync_center_content();
    sync_left_content();
    sync_right_content();
    sync_current_popup();
    this.center_container.setAlignment( Pos.TOP_CENTER );

    // Initialization
    header.setOnMousePressed(me -> {
      Window win = header.getScene().getWindow();
      dragX = me.getScreenX() - win.getX();
      dragY = me.getScreenY() - win.getY();
    });

    header.setOnMouseDragged(me -> {
      Window win = header.getScene().getWindow();
      win.setX(me.getScreenX() - dragX);
      win.setY(me.getScreenY() - dragY);
    });

    header.setOnMouseClicked(mouseEvent -> {
      if(mouseEvent.getButton().equals(MouseButton.PRIMARY) && mouseEvent.getClickCount() == 2){
        toggleMax();
      }
    });

    // Init fullscreen on start
    header.sceneProperty().addListener(($, $$, v) -> {
      if(v != null){
        header.getScene().getWindow().setOnShown(e -> {
          Window win = header.getScene().getWindow();
          Screen screen = Screen.getPrimary();
          Rectangle2D bounds = screen.getVisualBounds();
          if(win.getX() != bounds.getMinX()){
            toggleMax();
          }
        });
      }
    });
  }


  void toggleMax(){
    Window win = header.getScene().getWindow();
    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();
    Stage wstage = (Stage) win;
    if(wstage.getX() == bounds.getMinX() && wstage.getY() == bounds.getMinY()){
      bounds = defSize;
      maximize_window_button.getStyleClass().remove("max");
    }
    else {
      defSize = new Rectangle2D(
          wstage.getX(),
          wstage.getY(),
          wstage.getWidth(),
          wstage.getHeight()
      );
      maximize_window_button.getStyleClass().add("max");
    }
    wstage.setX(bounds.getMinX());
    wstage.setY(bounds.getMinY());
    wstage.setWidth(bounds.getWidth());
    wstage.setHeight(bounds.getHeight());
  }


  /**
   * Send window states to the view model
   */
  private void send_window_states() {
    send_close_window_pressed_state();
    send_minimize_window_state();
  }

  private void send_close_window_pressed_state() {
    this.close_window_button.pressedProperty().addListener( (obs, oldState, pressed) -> {
      this.viewModel.pressed_close_button().set(pressed);
    });
  }

  private void send_minimize_window_state() {
    this.minimize_window_button.pressedProperty().addListener((obs, oldState, pressed)  -> {
      this.viewModel.pressed_minimize_button().set(pressed);
    });
  }



  private void sync_username() {
    this.viewModel.usernameProperty().addListener((obs, old, actual_username) -> {
      this.lab_username.setText(actual_username);
    });
  }


  // root content

  private void sync_center_content() {
    this.viewModel.content_center().addListener((obs, old, component) -> {
      if (component != null) show_content_center(component);
      else clear_content_center();
    });
  }


  private void sync_left_content() {
    this.viewModel.content_left().addListener((obs, old, component) -> {
      if (component != null) show_content_left( component );
    });
  }


  private void sync_right_content() {
    this.viewModel.content_right().addListener((obs, old, component) -> {
      if (component != null) show_content_right( component );
    });
  }


  private void show_content_center( Component<?> component ) {
    this.body_container.setCenter( component.getView().getRoot_node() );
  }

  private void clear_content_center() {
    this.center_container.getChildren().clear();
  }


  private void show_content_left( Component<?> component ) {
    Node node = component.getView().getRoot_node();
    VBox.setVgrow( node, Priority.ALWAYS );
    this.left_container.getChildren().setAll( node );
  }


  private void show_content_right( Component<?> component ) {
    Node node = component.getView().getRoot_node();
    VBox.setVgrow( node, Priority.ALWAYS );
    this.right_container.getChildren().setAll(node);
  }


  // popup

  private void sync_current_popup() {
      this.viewModel.current_popup().addListener((obs, old, current_popup) -> {
        if (current_popup != null) showPopup(current_popup);
        else close_popup();
      });
  }

  private void showPopup( Component<?> component ) {
      StackPane popup_container = new StackPane();

      // full opaque check
      if (this.viewModel.isFull_opaque())
        popup_container.setStyle("-fx-background-color: rgba(250,250,250,1);");
      else
        popup_container.setStyle("-fx-background-color: rgba(0,0,0,0.1);");

      popup_container.getChildren().add( component.getView().getRoot_node() );
      this.root.getChildren().add(1, popup_container );
  }


  private void close_popup() {
      this.root.getChildren().remove(1);
  }


  public MenuButton getUserMenu(){
    return usermenu;
  }
}


