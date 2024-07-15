package mg.projetJava2019.paint.Objet.Shape;

import javafx.collections.ObservableList;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import mg.projetJava2019.paint.Objet.MyAction;

public class MyArc extends Border<Arc> {

    public MyArc(Arc shape, ObservableList<MyAction> listeAction) {
        super(shape, listeAction);
        
        this.shape.setStartAngle(90);
        this.shape.setLength(270);
        this.shape.setType(ArcType.ROUND);
        this.shape.radiusXProperty().bind(prefWidthProperty().divide(2));
        this.shape.radiusYProperty().bind(prefHeightProperty().divide(2));
        this.shape.centerXProperty().bind(prefWidthProperty().divide(2));
        this.shape.centerYProperty().bind(prefHeightProperty().divide(2));

        System.out.println("New arc");
    }

}
