
package mg.projetJava2019.paint.Objet.Shape;

import javafx.collections.ObservableList;
import javafx.scene.shape.Circle;
import mg.projetJava2019.paint.Objet.MyAction;


public class MyCircle  extends Border<Circle>{
    
    public MyCircle(Circle shape, ObservableList<MyAction> listeAction) {
        super(shape, listeAction);

        prefWidthProperty().bindBidirectional(prefHeightProperty());
        this.shape.radiusProperty().bind(prefWidthProperty().divide(2));
        this.shape.centerXProperty().bind(prefWidthProperty().divide(2));
        this.shape.centerYProperty().bind(prefHeightProperty().divide(2));

        System.out.println("New circle");
    }

}
