package mg.projetJava2019.paint.Objet.Shape;

import java.awt.MouseInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import mg.projetJava2019.paint.Objet.MyAction;

public class MyLine extends Sommet<Line> {
    
    private Circle circleDebut, circleFin;
    private double x1m, y1m, x2m, y2m;
    
    public MyLine(Line shape, ObservableList<MyAction> listeAction) {
        super(shape, listeAction);
        
        circleDebut = createCircle(listeAction);
        circleDebut.centerXProperty().bindBidirectional( this.shape.startXProperty());
        circleDebut.centerYProperty().bindBidirectional( this.shape.startYProperty());
        
        circleFin = createCircle(listeAction);
        circleFin.centerXProperty().bindBidirectional( this.shape.endXProperty());
        circleFin.centerYProperty().bindBidirectional( this.shape.endYProperty());
        
        circleDebut.setOnMouseDragged((event) -> {
            circleDebut.setCenterX( event.getX());
            circleDebut.setCenterY( event.getY());
        });
        
        circleFin.setOnMouseDragged((event) -> {
            circleFin.setCenterX( event.getX());
            circleFin.setCenterY( event.getY());
        });
        
        circleDebut.onMousePressedProperty().bind(this.shape.onMousePressedProperty());
        circleFin.onMousePressedProperty().bind(this.shape.onMousePressedProperty());
        circleDebut.onMouseReleasedProperty().bind(this.shape.onMouseReleasedProperty());
        circleFin.onMouseReleasedProperty().bind(this.shape.onMouseReleasedProperty());
        
        this.shape.setOnMousePressed(event -> {
            double x = MouseInfo.getPointerInfo().getLocation().x;
            double y = MouseInfo.getPointerInfo().getLocation().y;
            x1m = x - circleDebut.getCenterX();
            y1m = y - circleDebut.getCenterY();
            x2m = x - circleFin.getCenterX();
            y2m = y - circleFin.getCenterY();
        });

        this.shape.setOnMouseDragged(event -> {
            if(isSelected()){
                double x = MouseInfo.getPointerInfo().getLocation().x;
                double y = MouseInfo.getPointerInfo().getLocation().y;

                double X1 = x - x1m;
                double Y1 = y - y1m;
                double X2 = x - x2m;
                double Y2 = y - y2m;
                
                circleDebut.setCenterX(X1);
                circleDebut.setCenterY(Y1);
                circleFin.setCenterX(X2);
                circleFin.setCenterY(Y2);
            }
        });
        
        this.shape.setOnMouseReleased((event) -> {
            
        });
        
    }
    
    @Override
    public ObservableList<Node> getChildren(){
        return FXCollections.observableArrayList(this.shape, circleDebut, circleFin);
    }
    
    @Override
    public ObservableList<Double> getCopyDouble(){
        super.getCopyDouble();
        oldValueDouble.addAll( 
                shape.getStartX(), shape.getStartY(),
                shape.getEndX(), shape.getEndY()
        );
        return oldValueDouble;
    }
 
}
