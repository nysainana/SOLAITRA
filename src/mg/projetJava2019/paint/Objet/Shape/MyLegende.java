
package mg.projetJava2019.paint.Objet.Shape;

import javafx.collections.ObservableList;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineJoin;
import mg.projetJava2019.paint.Objet.MyAction;

public class MyLegende extends Border<Shape>{
    
    public MyLegende(Shape shape, ObservableList<MyAction> listeAction) {
        super(shape, listeAction);
        Ellipse ellipse = new Ellipse();
        ellipse.radiusXProperty().bind(prefWidthProperty().divide(2));
        ellipse.radiusYProperty().bind(prefHeightProperty().multiply(7).divide(8).divide(2));
        ellipse.centerXProperty().bind(prefWidthProperty().divide(2));
        ellipse.centerYProperty().bind(prefHeightProperty().multiply(7).divide(8).divide(2));
        
        Polygon polygon = new Polygon(
                getPrefWidth()/8, getPrefHeight()/2,
                getPrefWidth()/4, getPrefHeight(),
                (7*getPrefWidth())/8, getPrefHeight()/2);
        
        
        prefWidthProperty().addListener((observable, oldValue, newValue) -> {
            widthAndHeightChange( polygon, ellipse, newValue.doubleValue(), getPrefHeight());
            
            Shape shap = Shape.union( polygon, ellipse);
            shap.setStrokeLineJoin(StrokeLineJoin.ROUND);
            shap.strokeProperty().bind(this.shape.strokeProperty());
            shap.fillProperty().bind(this.shape.fillProperty());
            shap.strokeWidthProperty().bind(this.shape.strokeWidthProperty());
            getChildren().set(0, shap);
        });
        
        prefHeightProperty().addListener((observable, oldValue, newValue) -> {
            widthAndHeightChange( polygon, ellipse, getPrefWidth(), newValue.doubleValue());
            
            Shape shap = Shape.union( polygon, ellipse);
            shap.setStrokeLineJoin(StrokeLineJoin.ROUND);
            shap.strokeProperty().bind(this.shape.strokeProperty());
            shap.fillProperty().bind(this.shape.fillProperty());
            shap.strokeWidthProperty().bind(this.shape.strokeWidthProperty());
            getChildren().set(0, shap);
        });
        
    }
    
    private void widthAndHeightChange(Polygon polygon, Ellipse ellipse,  double w, double h){
        polygon.getPoints().set(0, w/8);
        polygon.getPoints().set(1, h/2);
        polygon.getPoints().set(2, w/4);
        polygon.getPoints().set(3, h);
        polygon.getPoints().set(4, (7*w)/8);
        polygon.getPoints().set(5, h/2);
    }
 
}
