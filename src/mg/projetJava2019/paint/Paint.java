
package mg.projetJava2019.paint;

import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mg.projetJava2019.paint.Objet.Utility;
import mg.projetJava2019.paint.interfaces.controller.FXLPrincipalleController;

public class Paint extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader load = new FXMLLoader(getClass().getResource("/mg/projetJava2019/paint/interfaces/fxml/FXMLPrincipalle.fxml"));
        Parent root = (Parent) load.load();
        FXLPrincipalleController cp = (FXLPrincipalleController) load.getController();
        Scene scene = new Scene(root);
        stage.setTitle("Sans nom - Solaitra");
        stage.setWidth(1040.0);
        stage.setHeight(680.0);
        stage.setMinWidth(940);
        stage.setMinHeight(600);
        stage.getIcons().addAll( new Utility().getListeImage());
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        if(screen.getWidth() <= 1040){
            stage.setMaximized(true);
        }
        stage.setOnCloseRequest((event) -> {
            event.consume();
            cp.quiter(null);
        });
        cp.getFile().addListener((observable, oldValue, newValue) -> {
            stage.setTitle(newValue.getAbsolutePath()+" - Solaitra");
        });
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
