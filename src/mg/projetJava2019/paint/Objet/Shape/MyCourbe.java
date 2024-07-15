
package mg.projetJava2019.paint.Objet.Shape;

import java.awt.MouseInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import mg.projetJava2019.paint.Objet.MyAction;

public class MyCourbe extends Sommet<CubicCurve>{
    
    private Circle circleDebut, circleFin, circleControl1, circleControl2;
    private double x1m, y1m, x2m, y2m, xc1, yc1, xc2, yc2;
    private Line l1, l2, l3;
    
    public MyCourbe(CubicCurve shape, ObservableList<MyAction> listeAction) {
        super(shape, listeAction);
        
        circleDebut = createCircle(listeAction);
        circleDebut.centerXProperty().bindBidirectional( this.shape.startXProperty());
        circleDebut.centerYProperty().bindBidirectional( this.shape.startYProperty());
        
        circleFin = createCircle(listeAction);
        circleFin.centerXProperty().bindBidirectional( this.shape.endXProperty());
        circleFin.centerYProperty().bindBidirectional( this.shape.endYProperty());
        
        circleControl1 = createCircle(listeAction);
        circleControl1.centerXProperty().bindBidirectional( this.shape.controlX1Property());
        circleControl1.centerYProperty().bindBidirectional( this.shape.controlY1Property());
        
        circleControl2 = createCircle(listeAction);
        circleControl2.centerXProperty().bindBidirectional( this.shape.controlX2Property());
        circleControl2.centerYProperty().bindBidirectional( this.shape.controlY2Property());
        
        l1 = createLineEntre(circleDebut, circleControl1);
        l2 = createLineEntre(circleControl1, circleControl2);
        l3 = createLineEntre(circleControl2, circleFin);
        
        circleDebut.setOnMouseDragged((event) -> {
            circleDebut.setCenterX( event.getX());
            circleDebut.setCenterY( event.getY());
        });
        
        circleFin.setOnMouseDragged((event) -> {
            circleFin.setCenterX( event.getX());
            circleFin.setCenterY( event.getY());
        });
        
        circleControl1.setOnMouseDragged((event) -> {
            circleControl1.setCenterX( event.getX());
            circleControl1.setCenterY( event.getY());
        });
        
        circleControl2.setOnMouseDragged((event) -> {
            circleControl2.setCenterX( event.getX());
            circleControl2.setCenterY( event.getY());
        });
        
        
        this.shape.setOnMousePressed(event -> {
            double x = MouseInfo.getPointerInfo().getLocation().x;
            double y = MouseInfo.getPointerInfo().getLocation().y;
            x1m = x - circleDebut.getCenterX();
            y1m = y - circleDebut.getCenterY();
            x2m = x - circleFin.getCenterX();
            y2m = y - circleFin.getCenterY();
            xc1 = x - circleControl1.getCenterX();
            yc1 = y - circleControl1.getCenterY();
            xc2 = x - circleControl2.getCenterX();
            yc2 = y - circleControl2.getCenterY();
        });

        this.shape.setOnMouseDragged(event -> {
            if(isSelected()){
                double x = MouseInfo.getPointerInfo().getLocation().x;
                double y = MouseInfo.getPointerInfo().getLocation().y;

                double X1 = x - x1m;
                double Y1 = y - y1m;
                double X2 = x - x2m;
                double Y2 = y - y2m;
                double X3 = x - xc1;
                double Y3 = y - yc1;
                double X4 = x - xc2;
                double Y4 = y - yc2;
                
                circleDebut.setCenterX(X1);
                circleDebut.setCenterY(Y1);
                circleFin.setCenterX(X2);
                circleFin.setCenterY(Y2);
                circleControl1.setCenterX(X3);
                circleControl1.setCenterY(Y3);
                circleControl2.setCenterX(X4);
                circleControl2.setCenterY(Y4);
            }
        });
        
        this.shape.setOnMouseReleased((event) -> {
            
        });
        
        
    }
    
    private Line createLineEntre( Circle c1, Circle c2){
        Line l = new Line();
        l.setStroke( Color.BLUE);
        l.setStrokeLineCap(StrokeLineCap.BUTT);
        l.visibleProperty().bind(c1.visibleProperty());
        l.startXProperty().bind( c1.centerXProperty());
        l.startYProperty().bind( c1.centerYProperty());
        l.endXProperty().bind( c2.centerXProperty());
        l.endYProperty().bind( c2.centerYProperty());
        return l;
    }
    
    @Override
    public ObservableList<Node> getChildren(){
        return FXCollections.observableArrayList(this.shape, l1, l2, l3,
                circleDebut, circleControl1, circleControl2, circleFin);
    }
    
    @Override
    public ObservableList<Double> getCopyDouble(){
        super.getCopyDouble();
        oldValueDouble.addAll( 
                shape.getStartX(), shape.getStartY(),
                shape.getEndX(), shape.getEndY(),
                shape.getControlX1(), shape.getControlY1(),
                shape.getControlX2(), shape.getControlY2()
        );
        return oldValueDouble;
    }
    
}
