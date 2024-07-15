
package mg.projetJava2019.paint.Objet.Shape;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;

public class MyLineElements extends Polyline{
    
    public static final int CRAYON = 1;
    public static final int PINCEAU = 2;
    public static final int GAUMME = 3;
    
    private int IDENTITY = 1;
    private final AnchorPane parent;
    
    public MyLineElements(int identity, double startX, double startY, Paint colorOfPoint, double sizeOfPoint, AnchorPane parent){
        super(startX, startY);
        IDENTITY = identity;
        this.parent = parent;
        setSmooth(true);
        setStrokeLineJoin(StrokeLineJoin.ROUND);
        setMouseTransparent(true);
        if(IDENTITY == CRAYON)
            setStrokeWidth(sizeOfPoint);
        else
            setStrokeWidth(sizeOfPoint*6);
        
        setStrokeLineCap(StrokeLineCap.ROUND);
        
        if(IDENTITY == GAUMME)
            setStroke(Color.WHITE);
        else
            setStroke(colorOfPoint);
        
        parent.getChildren().add(this);
    }
    
    public void ajoutPoints(double newX, double newY){
        getPoints().addAll(newX, newY);
    }
}
