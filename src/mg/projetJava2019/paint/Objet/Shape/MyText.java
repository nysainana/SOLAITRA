
package mg.projetJava2019.paint.Objet.Shape;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import mg.projetJava2019.paint.Objet.MyAction;

public class MyText extends Border<Text>{
    private VBox box;
    public MyText(Text shape, ObservableList<MyAction> listeAction) {
        super(shape, listeAction);
        int i = getChildren().indexOf(this.shape);
        getChildren().remove(i);
        box = new VBox(this.shape);
        prefWidthProperty().bindBidirectional( box.prefWidthProperty());
        prefHeightProperty().bindBidirectional( box.prefHeightProperty());
        this.shape.textProperty().addListener((observable, oldValue, newValue) -> {
            box.setPrefHeight(box.getHeight());
        });
        this.shape.wrappingWidthProperty().bind( prefWidthProperty());
        Rectangle clip = new Rectangle();
        clip.widthProperty().bindBidirectional( prefWidthProperty());
        clip.heightProperty().bindBidirectional( prefHeightProperty());
        box.setClip(clip);
        getChildren().add( i, box);
        
    }
    
    public void setFill(Paint fill){
        box.setBackground( new Background( new BackgroundFill(fill, CornerRadii.EMPTY, Insets.EMPTY)));
    }
    
    
    
}
