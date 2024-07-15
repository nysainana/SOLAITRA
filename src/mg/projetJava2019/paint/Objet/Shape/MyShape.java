
package mg.projetJava2019.paint.Objet.Shape;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
import mg.projetJava2019.paint.Objet.MyAction;


public class MyShape<T extends Shape> extends AnchorPane implements Cloneable{
    
    private BooleanProperty selected = new SimpleBooleanProperty(Boolean.FALSE);
    protected T shape;
    protected boolean modifier = false;
    protected ObservableList<Paint> oldValueColor;
    protected ObservableList<Double> oldValueDouble;
    
    public MyShape( T shape, ObservableList<MyAction> listeAction) {
        super();
        this.shape = shape;
        getChildren().add(this.shape);
        
        getStyleClass().add("my-shape");
        
        this.shape.mouseTransparentProperty().bind(selected.not());
        mouseTransparentProperty().bind(selected.not());
    }
    
    public void setSelected( boolean isSelected){
        selected.setValue(isSelected);
        requestFocus();
    }
    
    public boolean isSelected(){
        return selected.get();
    }
    
    public BooleanProperty selectedProperty(){
        return selected;
    }

    public T getChild(){
        return shape;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        MyShape<T> copie = (MyShape<T>) super.clone();
        copie.shape.setStroke( shape.getStroke());
        copie.shape.setStrokeWidth( shape.getStrokeWidth());
        copie.shape.setFill( shape.getFill());
        return copie; 
    }
    
    public ObservableList<Paint> getCopyPaint(){
        oldValueColor = FXCollections.observableArrayList(shape.getStroke(), shape.getFill());
        return oldValueColor;
    }
    
    public ObservableList<Double> getCopyDouble(){
        oldValueDouble = FXCollections.observableArrayList(shape.getStrokeWidth());
        return oldValueDouble;
    }
    
}
