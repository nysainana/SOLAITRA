
package mg.projetJava2019.paint.Objet.Shape;

import javafx.collections.ObservableList;
import javafx.scene.shape.Rectangle;
import mg.projetJava2019.paint.Objet.MyAction;

public class MyRectangle extends Border<Rectangle>{
    
    public static final int RECTANGLE = 1;
    public static final int RECTANGLEARRONDI = 2;
    public static final int CARRE = 3;

    public MyRectangle(int identity, Rectangle shape, ObservableList<MyAction> listeAction){
        super(shape, listeAction);
        
        this.shape.widthProperty().bind(prefWidthProperty());
        this.shape.heightProperty().bind(prefHeightProperty());
        switch(identity){
            case RECTANGLEARRONDI:     
                this.shape.setArcHeight(40);
                this.shape.setArcWidth(40);
                prefWidthProperty().addListener((observable, oldValue, newValue) -> {
                    if(newValue.doubleValue()>80)
                        this.shape.setArcWidth(40);
                    else if(newValue.doubleValue()>40)
                        this.shape.setArcWidth(20);
                    else if(newValue.doubleValue()>20)
                        this.shape.setArcWidth(10);
                    else if(newValue.doubleValue()>10)
                        this.shape.setArcWidth(5);
                });

                prefHeightProperty().addListener((observable, oldValue, newValue) -> {
                    if(newValue.doubleValue()>80)
                        this.shape.setArcHeight(40);
                    else if(newValue.doubleValue()>40)
                        this.shape.setArcHeight(20);
                    else if(newValue.doubleValue()>20)
                        this.shape.setArcHeight(10);
                    else if(newValue.doubleValue()>10)
                        this.shape.setArcHeight(5);
                });
                break;
            case CARRE:
                prefWidthProperty().bindBidirectional(prefHeightProperty());
                break;
        }
        System.out.println("New rectangle");
    }

    @Override
    public Rectangle getChild() {
        return this.shape;
    }

}
