
package mg.projetJava2019.paint.Objet.Shape;

import javafx.collections.ObservableList;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeLineJoin;
import mg.projetJava2019.paint.Objet.MyAction;

public class MyPolygon extends Border<Polygon>{
    
    public static final int TRIANGLE = 1;
    public static final int TRIANGLERECTANGLE = 2;
    public static final int LOSANGE = 3;
    public static final int PENTAGONE = 4;
    public static final int HEXAGONE = 5;
    public static final int FLECHE = 6;
    public static final int ETOILE = 7;
    
    private int identity = 0;
    
    public MyPolygon(int identity, Polygon shape, ObservableList<MyAction> listeAction) {
        super(shape, listeAction);
        this.identity = identity;
        
        this.shape.getPoints().clear();
        this.shape.setStrokeLineJoin(StrokeLineJoin.ROUND);
        
        switch(this.identity){
            case TRIANGLE:
                this.shape.getPoints().addAll(getPrefWidth()/2, 0d, getPrefWidth(),
                        getPrefHeight(), 0d, getPrefHeight());
                break;
            case TRIANGLERECTANGLE:
                this.shape.getPoints().addAll(
                        0d, 0d,
                        getPrefWidth(), getPrefHeight(),
                        0d, getPrefHeight());
                break;
            case LOSANGE:
                this.shape.getPoints().addAll(
                        getPrefWidth()/2, 0d, 
                        getPrefWidth(), getPrefHeight()/2, 
                        getPrefWidth()/2, getPrefHeight(), 
                        0d, getPrefHeight()/2);
                break;
            case PENTAGONE:
                this.shape.getPoints().addAll(
                        getPrefWidth()/2, 0d, 
                        getPrefWidth(), (3*getPrefHeight())/8, 
                        (6*getPrefWidth())/8, getPrefHeight(), 
                        (2*getPrefWidth())/8, getPrefHeight(),
                        0d, (3*getPrefHeight())/8);
                break;
            case HEXAGONE: 
                this.shape.getPoints().addAll(
                        getPrefWidth()/2, 0d, 
                        getPrefWidth(), getPrefHeight()/4, 
                        getPrefWidth(), (3*getPrefHeight())/4, 
                        getPrefWidth()/2, getPrefHeight(),
                        0d, (3*getPrefHeight())/4,
                        0d, getPrefHeight()/4);
                break;
            case FLECHE:
                this.shape.getPoints().addAll(
                        getPrefWidth()/2, 0d, 
                        getPrefWidth()/2, getPrefHeight()/4, 
                        getPrefWidth(), getPrefHeight()/4, 
                        getPrefWidth(), (3*getPrefHeight())/4,
                        getPrefWidth()/2, (3*getPrefHeight())/4,
                        getPrefWidth()/2, getPrefHeight(),
                        0d, getPrefHeight()/2);
                break;
            case ETOILE:
                this.shape.getPoints().addAll(
                        getPrefWidth()/2, 0d,
                        (12.5*getPrefWidth())/20, (2*getPrefHeight())/5, 
                        getPrefWidth(), (2*getPrefHeight())/5,
                        (7*getPrefWidth())/10, (12.5*getPrefHeight())/20,
                        (4*getPrefWidth())/5, getPrefHeight(),
                        getPrefWidth()/2, (15.5*getPrefHeight())/20,
                        getPrefWidth()/5, getPrefHeight(),
                        (3*getPrefWidth())/10, (12.5*getPrefHeight())/20,
                        0d, (2*getPrefHeight())/5,
                        (7.5*getPrefWidth())/20, (2*getPrefHeight())/5);
                break;
        }
        
        prefWidthProperty().addListener((observable, oldValue, newValue) -> {
            widthAndHeightChange(newValue.doubleValue(), getPrefHeight());
        });
        
        prefHeightProperty().addListener((observable, oldValue, newValue) -> {
            widthAndHeightChange( getPrefWidth(), newValue.doubleValue());
        });
        
        System.out.println("New triangle");
    }
    
    private void widthAndHeightChange(double w, double h){
        switch(identity){
            case TRIANGLE:
                this.shape.getPoints().set(0, w/2);
                this.shape.getPoints().set(2, w);
                this.shape.getPoints().set(3, h);
                this.shape.getPoints().set(5, h);
                break;
            case TRIANGLERECTANGLE:
                this.shape.getPoints().set(2, w);
                this.shape.getPoints().set(3, h);
                this.shape.getPoints().set(5, h);
                break;
            case LOSANGE:
                this.shape.getPoints().set(0, w/2);
                this.shape.getPoints().set(2, w);
                this.shape.getPoints().set(3, h/2);
                this.shape.getPoints().set(4, w/2);
                this.shape.getPoints().set(5, h);
                this.shape.getPoints().set(7, h/2);
                break;
            case PENTAGONE:
                this.shape.getPoints().set(0, w/2);
                this.shape.getPoints().set(2, w);
                this.shape.getPoints().set(3, (3*h)/8);
                this.shape.getPoints().set(4, (6*w)/8);
                this.shape.getPoints().set(5, h);
                this.shape.getPoints().set(6, (2*w)/8);
                this.shape.getPoints().set(7, h);
                this.shape.getPoints().set(9, (3*h)/8);
                break;
            case HEXAGONE:
                this.shape.getPoints().set(0, w/2);
                this.shape.getPoints().set(2, w);
                this.shape.getPoints().set(3, h/4);
                this.shape.getPoints().set(4, w);
                this.shape.getPoints().set(5, (3*h)/4);
                this.shape.getPoints().set(6, w/2);
                this.shape.getPoints().set(7, h);
                this.shape.getPoints().set(9, (3*h)/4);
                this.shape.getPoints().set(11, h/4);
                break;
            case FLECHE:
                this.shape.getPoints().set(0, w/2);
                this.shape.getPoints().set(2, w/2);
                this.shape.getPoints().set(3, h/4);
                this.shape.getPoints().set(4, w);
                this.shape.getPoints().set(5, h/4);
                this.shape.getPoints().set(6, w);
                this.shape.getPoints().set(7, (3*h)/4);
                this.shape.getPoints().set(8, w/2);
                this.shape.getPoints().set(9, (3*h)/4);
                this.shape.getPoints().set(10, w/2);
                this.shape.getPoints().set(11, h);
                this.shape.getPoints().set(13, h/2);
                break;
            case ETOILE:
                this.shape.getPoints().set(0, w/2);
                this.shape.getPoints().set(1, 0d);
                this.shape.getPoints().set(2, (12.5*w)/20);
                this.shape.getPoints().set(3, (2*h)/5);
                this.shape.getPoints().set(4, w);
                this.shape.getPoints().set(5, (2*h)/5);
                this.shape.getPoints().set(6, (7*w)/10);
                this.shape.getPoints().set(7, (12.5*h)/20);
                this.shape.getPoints().set(8, (4*w)/5);
                this.shape.getPoints().set(9, h);
                this.shape.getPoints().set(10, w/2);
                this.shape.getPoints().set(11, (15.5*h)/20);
                this.shape.getPoints().set(12, w/5);
                this.shape.getPoints().set(13, h);
                this.shape.getPoints().set(14, (3*w)/10);
                this.shape.getPoints().set(15, (12.5*h)/20);
                this.shape.getPoints().set(16, 0d);
                this.shape.getPoints().set(17, (2*h)/5);
                this.shape.getPoints().set(18, (7.5*w)/20);
                this.shape.getPoints().set(19, (2*h)/5);
                break;
        }
    }

}
