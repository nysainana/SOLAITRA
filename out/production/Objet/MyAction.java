
package mg.projetJava2019.paint.Objet;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import mg.projetJava2019.paint.Objet.Shape.MyLineElements;
import mg.projetJava2019.paint.Objet.Shape.MyShape;

public class MyAction {
    
    public static final int AJOUTER = 1;
    public static final int SUPPRIMER = 2;
    public static final int STROKE = 3;
    public static final int STROKEWIDTH = 4;
    public static final int FILL = 5;
    public static final int DEPLACE = 6;
    public static final int RESIZE = 7;
    
    private int identity = 0;
    private MyShape object;
    private MyLineElements line;
    private AnchorPane parent;
    private Line lin;

    public MyAction(int identity, MyShape object, AnchorPane parent) {
        this.identity = identity;
        this.object = object;
        this.parent = parent;
    }
    
    public MyAction(int identity, MyLineElements line, AnchorPane parent) {
        this.identity = identity;
        this.line = line;
        this.parent = parent;
    }
    
    public MyAction(int identity, Line line, AnchorPane parent) {
        this.identity = identity;
        this.lin = line;
        this.parent = parent;
    }
    
    private Paint oldValue, newValue;
    public MyAction(int identity, MyShape object, Paint oldValue) {
        this.identity = identity;
        this.object = object;
        this.oldValue = oldValue;
        if(this.identity == STROKE)
            newValue = this.object.getChild().getStroke();
        else if(this.identity == FILL)
            newValue = this.object.getChild().getFill();
    }
    
    private double oldStrokeWidth, newStrokeWidth;
    public MyAction(MyShape object, double oldStrokeWidth) {
        this.identity = STROKEWIDTH;
        this.object = object;
        this.oldStrokeWidth = oldStrokeWidth;
        newStrokeWidth = this.object.getChild().getStrokeWidth();
    }
    
    private double oldValue1, oldValue2, newValue1, newValue2;
    public MyAction(int identity, MyShape object, double oldValue1, double oldValue2) {
        this.identity = identity;
        this.object = object;
        this.oldValue1 = oldValue1;
        this.oldValue2 = oldValue2;
        if(this.identity == DEPLACE){
            newValue1 = this.object.getLayoutX();
            newValue2 = this.object.getLayoutY();
        }
        else if(this.identity == RESIZE){
            newValue1 = this.object.getPrefWidth();
            newValue2 = this.object.getPrefHeight();
        }
    }
      
    public MyAction(AnchorPane anc, double oldValue1, double oldValue2) {
        this.identity = RESIZE;
        this.parent = anc;
        this.oldValue1 = oldValue1;
        this.oldValue2 = oldValue2;
        newValue1 = this.parent.getPrefWidth();
        newValue2 = this.parent.getPrefHeight();
    }
    
    public void retour(){
        switch(identity){
            case AJOUTER:
                if(object!=null)
                    parent.getChildren().remove(object);
                else if(lin!=null)
                    parent.getChildren().remove(lin);
                else
                    parent.getChildren().remove(line);
                break;
            case SUPPRIMER:
                parent.getChildren().add(object);
                break;
            case STROKE: 
                object.getChild().setStroke(oldValue);
                break;
            case STROKEWIDTH:
                object.getChild().setStrokeWidth(oldStrokeWidth);
                break;
            case FILL:
                object.getChild().setFill(oldValue);
                break;
            case DEPLACE:
                object.setLayoutX(oldValue1);
                object.setLayoutY(oldValue2);
                break;
            case RESIZE:
                if(object!=null)
                    object.setPrefSize(oldValue1, oldValue2);
                else
                    parent.setPrefSize(oldValue1, oldValue2);
                break;
        }
    }
    
    public void avancer(){
        switch(identity){
            case AJOUTER:
                if(object!=null)
                    parent.getChildren().add(object);
                else if(lin!=null)
                    parent.getChildren().add(lin);
                else{
                    parent.getChildren().add(line);
                }
                break;
            case SUPPRIMER:
                parent.getChildren().remove(object);
                break;
            case STROKE: 
                object.getChild().setStroke(newValue);
                break;
            case STROKEWIDTH:
                object.getChild().setStrokeWidth(newStrokeWidth);
                break;
            case FILL:
                object.getChild().setFill(newValue);
                break;
            case DEPLACE:
                object.setLayoutX(newValue1);
                object.setLayoutY(newValue2);
                break;
            case RESIZE:
                if(object!=null)
                    object.setPrefSize(newValue1, newValue2);
                else
                    parent.setPrefSize(newValue1, newValue2);
                break;
        }
    }
    
}
