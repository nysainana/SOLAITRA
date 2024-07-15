
package mg.projetJava2019.paint.interfaces.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class FXMLDialogConfirmController implements Initializable {

    @FXML private JFXButton buttonSauver;
    @FXML private JFXButton buttonNePasSauver;
    @FXML private JFXButton buttonAnnuler;
    @FXML private Label labelText;
    @FXML private HBox boxButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void setOnAccept(EventHandler<ActionEvent> event){
        buttonSauver.setOnAction(event);
    }
    
    public void setOnRefuse(EventHandler<ActionEvent> event){
        buttonNePasSauver.setOnAction(event);
    }
    
    public void setOnAnnul(EventHandler<ActionEvent> event){
        buttonAnnuler.setOnAction(event);
    }
    
    public void setMessage( String text){
        labelText.setText(text);
    }
    
    public void setContent(boolean bSaubver, boolean bRefuser, boolean bannul){
        if(!bSaubver)
            boxButton.getChildren().remove(buttonSauver);
        if(!bRefuser)
            boxButton.getChildren().remove(buttonNePasSauver);
        if(!bannul)
            boxButton.getChildren().remove(buttonAnnuler);
    }
    
    
}
