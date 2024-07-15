
package mg.projetJava2019.paint.Objet.Shape;

import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class MyImage extends Border{
    
    private ImageView image;

    public MyImage(Image img, ObservableList listeAction) {
        super( new Rectangle(), listeAction);
        image = new ImageView(img);
        image.setMouseTransparent(true);
        getChildren().set(0, image);
        
        image.fitWidthProperty().bind( prefWidthProperty());
        image.fitHeightProperty().bind( prefHeightProperty());
        
    }
    
    
    
}
