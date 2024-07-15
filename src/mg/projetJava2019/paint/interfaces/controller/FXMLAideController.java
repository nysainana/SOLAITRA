
package mg.projetJava2019.paint.interfaces.controller;

import com.jfoenix.controls.JFXTreeView;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import mg.projetJava2019.paint.Objet.Utility;

public class FXMLAideController implements Initializable {

    @FXML private JFXTreeView<MyFile> treeView;
    @FXML private AnchorPane root;
    @FXML private WebView webView;
    
    private final File file = new File("fichier/aide");
    private WebEngine engine;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        engine = webView.getEngine();
        treeView.setRoot(loadTreeModel());
        
        treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue != null ){
                File f = newValue.getValue();
                if(!f.isDirectory()){
                    engine.loadContent(Utility.lireFichier(f.getAbsolutePath()));
                }
            }
        });
    }
    
    private  TreeItem<MyFile> loadTreeModel(){
        TreeItem<MyFile> mere = new TreeItem<>(new MyFile(file));
        loadDirectory(mere);
        return mere;
    }
    
    private void loadDirectory(TreeItem<MyFile> mere){
        File lf[] = mere.getValue().listFiles();
        if(lf!=null){
            for(File f:lf){
                TreeItem<MyFile> fils = new TreeItem<>(new MyFile(f));
                mere.getChildren().add(fils);
                if(f.isDirectory()){
                    loadDirectory( fils);
                }
            }
        }
    }
    
    @FXML
    private void fermer(ActionEvent event) {
        root.getScene().getWindow().hide();
    }


    class MyFile extends File{
        
        public MyFile(File f) {
            super(f.getPath());
        }
        
        @Override
        public String toString(){
            return getName();
        }
        
    }
    
}
