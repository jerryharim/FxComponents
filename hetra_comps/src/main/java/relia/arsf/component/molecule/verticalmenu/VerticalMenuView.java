package relia.arsf.component.molecule.verticalmenu;

import java.util.NoSuchElementException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.VBox;
import relia.arsf.component.base.MVVMView;
import relia.arsf.component.base.View;
import relia.model.Year;


/**
 * T represent the type of element used in menu list
 */ 

@MVVMView
public class VerticalMenuView extends View<VerticalMenuViewModel> {
	@FXML public VBox menu_container;
  @FXML private MenuButton yearmenu;
	@FXML private Button importation,
			contribuable, 
			parametre, 
			impression, 
			stats;
  Button current = null;

    public VerticalMenuView(VerticalMenuViewModel viewModel) {
        super(viewModel);
    }

    void initYearMenu(){
      yearmenu.getItems().clear();
      Year.findAll().stream().sorted((y1, y2) -> y2.getLabel().compareTo(y1.getLabel())) .forEach(year -> {
        javafx.scene.control.MenuItem mi = new javafx.scene.control.MenuItem();
        mi.setText(year.getLabel());
        mi.setOnAction($ -> {
          Year.setCurYear(year);
          yearmenu.setText(year.getLabel());
        });
        yearmenu.getItems().add(mi);
        if(year == Year.getCurYear()){
          yearmenu.setText(year.getLabel());
        }
      });
    }

    private void visible(Node node, boolean show){
      node.setVisible(show);
      node.setManaged(show);
    }

    @Override
    public void sync_with_view_model() {
      sync_selected_menu_item();
      setCurrentMenu(contribuable);
      initYearMenu();
      Year.listenToCurrentYear(y -> {
        initYearMenu();
        visible(yearmenu, y != null);
        visible(contribuable, y != null);
        visible(parametre, y != null);
        visible(impression, y != null);
        visible(stats, y != null);
        if(y != null){
          yearmenu.setText(y.getLabel());
        }
      });
    }

    void setCurrentMenu(Button cur){
      if(current != null) current.getStyleClass().remove("selected");
      if(cur != null) {
        cur.getStyleClass().add("selected");
        current = cur;
      }
    }


	private void sync_selected_menu_item() {
        this.viewModel.selected_menu_item().addListener(
                (obs, last_selected_item, selected_item) -> {

            if (last_selected_item != null) unactive_menu_item( last_selected_item );
            active_menu_item( selected_item );
        });
	}


	private void unactive_menu_item( MenuItem menu_item ) {
	}

	private void active_menu_item( MenuItem menu_item ) {
	}

	private Button find_menu_item_view(MenuItem menu_item) {
        try {
            return (Button) this.menu_container.getChildren().stream()
                .filter( menu_item_view -> menu_item_view.getUserData().equals(menu_item) )
                .findFirst()
                .get();
        } catch (NoSuchElementException exception) {
            System.out.println(String.format("[ERROR] %s not found from the menu items view", menu_item));
            return null;
        }
	}



    @FXML
    void contribuables_selected(ActionEvent event) {
      setCurrentMenu(contribuable);
      this.viewModel.select_menu_item(MenuItem.CONTRIBUABLE);
    }

    @FXML
    void importation_selected(ActionEvent event) {
      setCurrentMenu(importation);
      this.viewModel.select_menu_item(MenuItem.IMPORTATION);
    }

    @FXML
    void impression_selected(ActionEvent event) {
      setCurrentMenu(impression);
        this.viewModel.select_menu_item(MenuItem.IMPRESSION);
    }

    @FXML
    void parametres_selected(ActionEvent event) {
      setCurrentMenu(parametre);
        this.viewModel.select_menu_item(MenuItem.PARAMETRE);
    }

    @FXML
    void stats_selected(ActionEvent event) {
      setCurrentMenu(stats);
      this.viewModel.select_menu_item(MenuItem.STATS);
    }


    // getters
    
    public VBox getMenu_container() {
		return menu_container;
	}

}
