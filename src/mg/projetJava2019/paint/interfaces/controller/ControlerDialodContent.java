
package mg.projetJava2019.paint.interfaces.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

public class ControlerDialodContent implements Initializable {

    @FXML private AnchorPane rootPane;
    @FXML private ScrollPane scroolContent;
    @FXML private Label labelTitle;
    @FXML private AnchorPane qnchorTete;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    public ScrollPane getScroolContent(){
        return scroolContent;
    }
    
    public void setTitle( String title){
        labelTitle.setText(title);
    }

    public void pasDeTete(){
        rootPane.getChildren().remove(qnchorTete);
        AnchorPane.setTopAnchor( scroolContent, 0d);
    }
    
}
