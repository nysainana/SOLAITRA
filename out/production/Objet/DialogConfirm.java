
package mg.projetJava2019.paint.Objet;

import com.jfoenix.controls.JFXDialog;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import mg.projetJava2019.paint.interfaces.controller.ControlerDialodContent;
import mg.projetJava2019.paint.interfaces.controller.FXMLDialogConfirmController;

public class DialogConfirm extends JFXDialog{
    
    private AnchorPane paneConfirm;
    private FXMLDialogConfirmController contrConfirm;
    private AnchorPane paneContent;
    private ControlerDialodContent contrContent;
    
    public DialogConfirm(String titre, String text, AnchorPane parent, boolean but1, boolean but2, boolean but3){
        super();
        try {
            FXMLLoader load = new FXMLLoader(getClass().getResource("/mg/projetJava2019/paint/interfaces/fxml/FXMLDialogConfirm.fxml"));
            paneConfirm = (AnchorPane) load.load();
            contrConfirm = (FXMLDialogConfirmController) load.getController();
            contrConfirm.setMessage(text);
            contrConfirm.setContent(but1, but2, but3);
            
            load = new FXMLLoader(getClass().getResource("/mg/projetJava2019/paint/interfaces/fxml/FXMLDialogContent.fxml"));
            paneContent = (AnchorPane) load.load();
            contrContent = (ControlerDialodContent) load.getController();
            if(titre == null)
                contrContent.pasDeTete();
            else
                contrContent.setTitle(titre);
            contrContent.getScroolContent().setContent(paneConfirm);
            
            StackPane stkPane = new StackPane();
            AnchorPane.setTopAnchor(stkPane, 0d);
            AnchorPane.setLeftAnchor(stkPane, 0d);
            AnchorPane.setBottomAnchor(stkPane, 0d);
            AnchorPane.setRightAnchor(stkPane, 0d);
            stkPane.getStyleClass().add(titre);
            setDialogContainer(stkPane);
            setContent(paneContent);
            setTransitionType(DialogTransition.TOP);
            parent.getChildren().add(stkPane);
            
            setOnDialogClosed((event) -> {
                parent.getChildren().remove(stkPane);
            });
            
            contrConfirm.setOnAnnul((event) -> {
                close();
            });
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public void setOnAccept(EventHandler<ActionEvent> event){
        contrConfirm.setOnAccept(event);
    }
    
    public void setOnRefuse(EventHandler<ActionEvent> event){
        contrConfirm.setOnRefuse(event);
    }

}
