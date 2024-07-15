
package mg.projetJava2019.paint.Objet;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import mg.projetJava2019.paint.interfaces.controller.FXMLAideController;

public class Aide extends Stage{
    
    private AnchorPane paneAide;
    private FXMLAideController contrConfirm;

    public Aide( Window owner) {
        super();
        try {
            FXMLLoader load = new FXMLLoader(getClass().getResource("/mg/projetJava2019/paint/interfaces/fxml/FXMLAide.fxml"));
            paneAide = (AnchorPane) load.load();
            contrConfirm = (FXMLAideController) load.getController();
            Scene scene = new Scene(paneAide);
            
            setTitle("Aide");
            setWidth(700.0);
            setHeight(500.0);
            setMinWidth(200);
            setMinHeight(100);
            setX( owner.getX()+50);
            setY( owner.getY()+50);
            initOwner(owner);
            getIcons().setAll(new Utility().getListeImage());
            setScene(scene);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
