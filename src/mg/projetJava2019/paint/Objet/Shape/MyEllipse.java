package mg.projetJava2019.paint.Objet.Shape;

import javafx.collections.ObservableList;
import javafx.scene.shape.Ellipse;
import mg.projetJava2019.paint.Objet.MyAction;

public class MyEllipse extends  Border<Ellipse> {

    public MyEllipse(Ellipse shape, ObservableList<MyAction> listeAction) {
        super(shape, listeAction);
        
        this.shape.radiusXProperty().bind(prefWidthProperty().divide(2));
        this.shape.radiusYProperty().bind(prefHeightProperty().divide(2));
        this.shape.centerXProperty().bind(prefWidthProperty().divide(2));
        this.shape.centerYProperty().bind(prefHeightProperty().divide(2));

        System.out.println("New ellipse");

    }

}
