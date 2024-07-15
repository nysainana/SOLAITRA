package mg.projetJava2019.paint.Objet.Shape;


import javafx.collections.ObservableList;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import mg.projetJava2019.paint.Objet.MyAction;

public class Sommet< T extends Shape> extends MyShape<T> implements Cloneable{

    public Sommet(T shape, ObservableList<MyAction> listeAction) {
        super(shape, listeAction);
        this.shape.setCursor(Cursor.MOVE);
        
    }

    protected Circle createCircle(ObservableList<MyAction> listeAction){
        Circle circ = new Circle();
        circ.setRadius(5);
        circ.setStrokeWidth(1);
        circ.setFill(Color.WHITE);
        circ.setStroke(Color.valueOf("#666666"));
        circ.setCursor(Cursor.OPEN_HAND);
        circ.getStyleClass().add("circle-move");
        circ.visibleProperty().bind( selectedProperty());
        circ.addEventHandler( MouseEvent.MOUSE_PRESSED, (event) -> {
            circ.setCursor(Cursor.CLOSED_HAND);
            getCopyPaint();
            getCopyDouble();
        });
        circ.addEventHandler( MouseEvent.MOUSE_RELEASED, (event) -> {
            circ.setCursor(Cursor.OPEN_HAND);
            listeAction.add( new MyAction(this, oldValueColor, oldValueDouble));
        });
        return circ;
    }
}
