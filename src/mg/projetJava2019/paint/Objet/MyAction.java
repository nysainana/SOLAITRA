
package mg.projetJava2019.paint.Objet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import mg.projetJava2019.paint.Objet.Shape.Border;
import mg.projetJava2019.paint.Objet.Shape.MyCourbe;
import mg.projetJava2019.paint.Objet.Shape.MyLine;
import mg.projetJava2019.paint.Objet.Shape.MyLineElements;
import mg.projetJava2019.paint.Objet.Shape.MyShape;

public class MyAction<T extends MyShape> {
    
    public static int AJOUT = 1;
    public static int SUPPRIMER = 2;
    
    private T node;
    private ObservableList<Paint> oldValueColor;
    private final ObservableList<Paint> newValueColor = FXCollections.observableArrayList();
    private ObservableList<Double> oldValueDouble;
    private final ObservableList<Double> newValueDouble = FXCollections.observableArrayList();
    private int id = 0;
    private AnchorPane parent, canvas;
    private MyLineElements lineE;
    
    public MyAction(MyLineElements node, AnchorPane parent){
        this.lineE = node;
        this.parent = parent;
    }
    
    public MyAction(AnchorPane node, double oldWidth, double oldHeight){
        this.canvas = node;
        oldValueDouble = FXCollections.observableArrayList( oldWidth, oldHeight);
        newValueDouble.addAll( node.getPrefWidth(), node.getPrefHeight());
    }
    
    public MyAction(int id, T node, AnchorPane parent){
        this.node = node;
        this.id = id;
        this.parent = parent;
    }
    
    public MyAction(T node, ObservableList<Paint> oldValueColor, ObservableList<Double> oldValueDouble) {
        this.node = node;
        this.oldValueColor = oldValueColor;
        this.oldValueDouble = oldValueDouble;
        if(node instanceof MyShape){
            newValueColor.addAll(
                    node.getChild().getStroke(),
                    node.getChild().getFill()
            );
            newValueDouble.addAll(
                    node.getChild().getStrokeWidth()
            );
            if(node instanceof Border){
                newValueDouble.addAll(
                        node.getPrefWidth(),
                        node.getPrefHeight(),
                        node.getLayoutX(),
                        node.getLayoutY(),
                        node.getRotate()
                );
            }
            else if(node instanceof MyLine){
                MyLine ml = (MyLine) node;
                newValueDouble.addAll(
                        ml.getChild().getStartX(),
                        ml.getChild().getStartY(),
                        ml.getChild().getEndX(),
                        ml.getChild().getEndY()
                );
            }
            else if(node instanceof MyCourbe){
                MyCourbe mc = (MyCourbe) node;
                newValueDouble.addAll( 
                        mc.getChild().getStartX(),
                        mc.getChild().getStartY(),
                        mc.getChild().getEndX(),
                        mc.getChild().getEndY(),
                        mc.getChild().getControlX1(),
                        mc.getChild().getControlY1(),
                        mc.getChild().getControlX2(),
                        mc.getChild().getControlY2()
                );
            }
        }
    }
    
    public void retour(){
        if(lineE != null){
            parent.getChildren().remove(lineE);
        }
        else if(canvas != null){
            canvas.setPrefSize( oldValueDouble.get(0), oldValueDouble.get(1));
        }
        else{
            if( node instanceof MyShape){
                if(id == 0){
                    node.getChild().setStroke( oldValueColor.get(0));
                    node.getChild().setFill( oldValueColor.get(1));
                    node.getChild().setStrokeWidth( oldValueDouble.get(0));
                    if(node instanceof Border){
                        node.setPrefSize( oldValueDouble.get(1), oldValueDouble.get(2));
                        node.setLayoutX( oldValueDouble.get(3));
                        node.setLayoutY( oldValueDouble.get(4));
                        node.setRotate( oldValueDouble.get(5));
                    }
                    else if(node instanceof MyLine){
                        ((MyLine) node).getChild().setStartX(oldValueDouble.get(1));
                        ((MyLine) node).getChild().setStartY(oldValueDouble.get(2));
                        ((MyLine) node).getChild().setEndX(oldValueDouble.get(3));
                        ((MyLine) node).getChild().setEndY(oldValueDouble.get(4));
                    }else if(node instanceof MyCourbe){
                        ((MyCourbe) node).getChild().setStartX(oldValueDouble.get(1));
                        ((MyCourbe) node).getChild().setStartY(oldValueDouble.get(2));
                        ((MyCourbe) node).getChild().setEndX(oldValueDouble.get(3));
                        ((MyCourbe) node).getChild().setEndY(oldValueDouble.get(4));
                        ((MyCourbe) node).getChild().setControlX1(oldValueDouble.get(5));
                        ((MyCourbe) node).getChild().setControlY1(oldValueDouble.get(6));
                        ((MyCourbe) node).getChild().setControlX2(oldValueDouble.get(7));
                        ((MyCourbe) node).getChild().setControlY2(oldValueDouble.get(8));
                    }
                }
                else if(id == AJOUT){
                    if(node instanceof Border)
                        parent.getChildren().remove(node);
                    else
                        parent.getChildren().removeAll(node.getChildren());
                }
                else if(id == SUPPRIMER){
                    if(node instanceof Border)
                        parent.getChildren().add(node);
                    else
                        parent.getChildren().addAll(node.getChildren());
                }
            }
        }
    }
    
    public void avancer(){
        if(lineE != null){
            parent.getChildren().add(lineE);
        }
        else if(canvas != null){
            canvas.setPrefSize( newValueDouble.get(0), newValueDouble.get(1));
        }
        else{
            if( node instanceof MyShape){
                if(id == 0){
                    node.getChild().setStroke( newValueColor.get(0));
                    node.getChild().setFill( newValueColor.get(1));
                    node.getChild().setStrokeWidth( newValueDouble.get(0));
                    if(node instanceof Border){
                        node.setPrefSize( newValueDouble.get(1), newValueDouble.get(2));
                        node.setLayoutX( newValueDouble.get(3));
                        node.setLayoutY( newValueDouble.get(4));
                        node.setRotate( newValueDouble.get(5));
                    }
                    else if(node instanceof MyLine){
                        ((MyLine) node).getChild().setStartX(newValueDouble.get(1));
                        ((MyLine) node).getChild().setStartY(newValueDouble.get(2));
                        ((MyLine) node).getChild().setEndX(newValueDouble.get(3));
                        ((MyLine) node).getChild().setEndY(newValueDouble.get(4));
                    }else if(node instanceof MyCourbe){
                        ((MyCourbe) node).getChild().setStartX(newValueDouble.get(1));
                        ((MyCourbe) node).getChild().setStartY(newValueDouble.get(2));
                        ((MyCourbe) node).getChild().setEndX(newValueDouble.get(3));
                        ((MyCourbe) node).getChild().setEndY(newValueDouble.get(4));
                        ((MyCourbe) node).getChild().setControlX1(newValueDouble.get(5));
                        ((MyCourbe) node).getChild().setControlY1(newValueDouble.get(6));
                        ((MyCourbe) node).getChild().setControlX2(newValueDouble.get(7));
                        ((MyCourbe) node).getChild().setControlY2(newValueDouble.get(8));
                    }
                }
                else if(id == AJOUT){
                    if(node instanceof Border)
                        parent.getChildren().add(node);
                    else
                        parent.getChildren().addAll(node.getChildren());
                }
                else if(id == SUPPRIMER){
                    if(node instanceof Border)
                        parent.getChildren().remove(node);
                    else
                        parent.getChildren().removeAll(node.getChildren());
                }
            }
        }
    }
}
