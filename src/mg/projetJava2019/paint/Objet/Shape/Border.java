
package mg.projetJava2019.paint.Objet.Shape;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.awt.MouseInfo;
import javafx.collections.ObservableList;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import mg.projetJava2019.paint.Objet.MyAction;


public class Border< T extends Shape> extends MyShape<T> implements Cloneable{
    
    private Circle circle = new Circle();
    private Pane pane = new Pane();
    private double xm, ym;
    private AnchorPane paneIn = new AnchorPane();

    public Border( T shape, ObservableList<MyAction> listeAction) {
        super(shape, listeAction);
        
        maxWidthProperty().bind(prefWidthProperty());
        maxHeightProperty().bind(prefHeightProperty());
               
        paneIn.prefWidthProperty().bind(prefWidthProperty());
        paneIn.prefHeightProperty().bind(prefHeightProperty());
        paneIn.setCursor(Cursor.MOVE);
        getChildren().add(paneIn);
        
        paneIn.setOnMousePressed(event -> {
            modifier = false;
            double x = MouseInfo.getPointerInfo().getLocation().x;
            double y = MouseInfo.getPointerInfo().getLocation().y;
            xm = x - getLayoutX();
            ym = y - getLayoutY();
            getCopyDouble();
            getCopyPaint();
        });

        paneIn.setOnMouseDragged(event -> {
            if(isSelected()){
                double x = MouseInfo.getPointerInfo().getLocation().x;
                double y = MouseInfo.getPointerInfo().getLocation().y;

                double X = x - xm;
                double Y = y - ym;
                setLayoutX(X);
                setLayoutY(Y);
                modifier = true;
            }
        });
        
        paneIn.setOnMouseReleased((event) -> {
            if(modifier){
                listeAction.add( new MyAction<>( this, oldValueColor, oldValueDouble));
            }
        });
        
        pane.setPrefSize(17,17);
        pane.setLayoutX(-pane.getPrefWidth()/2);
        pane.setLayoutY(-pane.getPrefHeight()/2);
        pane.setStyle("-fx-border-color: #666666; -fx-border-radius: 17;"
                + " -fx-background-radius: 17; -fx-background-color: white;");
        pane.setCursor(Cursor.H_RESIZE);
        getChildren().add(pane);
        MaterialDesignIconView icon1 = new MaterialDesignIconView(MaterialDesignIcon.ROTATE_RIGHT);
        icon1.setGlyphSize(15);
        icon1.setLayoutX((pane.getPrefWidth()-icon1.getGlyphSize().doubleValue())/2);
        icon1.setLayoutY(((pane.getPrefHeight()-icon1.getGlyphSize().doubleValue())/2)+icon1.getGlyphSize().doubleValue()-2);
        icon1.setFill(Color.valueOf("#666666"));
        pane.getChildren().add(icon1);

        pane.setOnMouseDragged(event -> {
            if(isSelected()){
                double angle = Math.atan((event.getX()+(getPrefWidth()/2))/(event.getX()+(getPrefHeight()/2)))+(Math.PI/2);
                setRotate(angle);
            }
        });

        circle.setRadius(5);
        circle.setStrokeWidth(1);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.valueOf("#666666"));
        circle.setCursor(Cursor.SE_RESIZE);
        getChildren().add(circle);
        
        circle.setOnMousePressed((event) -> {
            modifier = false;
            getCopyDouble();
            getCopyPaint();
        });

        circle.setOnMouseDragged((event) -> {
            if(circle.getCenterX()>=9){
                circle.setCenterX(event.getX());
                if(circle.getCenterX()<9)
                    circle.setCenterX(9);
            }

            if(circle.getCenterY()>=9){
                circle.setCenterY(event.getY());
                if(circle.getCenterY()<9)
                    circle.setCenterY(9);
            }
            modifier = true;
        });
        
        circle.setOnMouseReleased((event) -> {
            if(modifier){
                listeAction.add( new MyAction<>(this, oldValueColor, oldValueDouble));
            }
        });
        
        circle.centerXProperty().bindBidirectional(prefWidthProperty());
        circle.centerYProperty().bindBidirectional(prefHeightProperty());
        circle.visibleProperty().bind(selectedProperty());
        pane.visibleProperty().bind(selectedProperty());
        
        selectedProperty().addListener((observable, oldValue, newValue) -> {
            setBorder(newValue);
        });
    }
    
    private void setBorder(boolean set){
        if(set){
            paneIn.setStyle("-fx-border-width: 1; -fx-border-color: #666666; -fx-border-style: dashed;" +
                    " -fx-background-color: rgba(0, 0, 0, 0.1)");
        }
        else{
            paneIn.setStyle("-fx-border-width: 0; -fx-background-color: rgba(0, 0, 0, 0.0)");
        }
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        Border<T> copie = (Border<T>) super.clone();
        copie.setPrefSize( getPrefWidth(), getPrefHeight());
        copie.setLayoutX( getLayoutX());
        copie.setLayoutY( getLayoutY());
        return copie; 
    }
    
    @Override
    public ObservableList<Double> getCopyDouble(){
        super.getCopyDouble();
        oldValueDouble.addAll( getPrefWidth(), getPrefHeight(), getLayoutX(), getLayoutY(), getRotate());
        return oldValueDouble;
    }
}
