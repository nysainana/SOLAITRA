
package mg.projetJava2019.paint.interfaces.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import mg.projetJava2019.paint.Objet.Aide;
import mg.projetJava2019.paint.Objet.DialogConfirm;
import mg.projetJava2019.paint.Objet.MyAction;
import mg.projetJava2019.paint.Objet.Shape.*;
import mg.projetJava2019.paint.Objet.Utility;

public class FXLPrincipalleController implements Initializable {


    @FXML private AnchorPane root;
    @FXML private AnchorPane panePallete;
    @FXML private SplitPane splitPane;
    @FXML private JFXButton arcButton;
    @FXML private JFXButton crayonButton;
    @FXML private JFXButton pinceauButton;
    @FXML private JFXButton remplissageButton;
    @FXML private JFXButton textButton;
    @FXML private JFXButton gommeButton;
    @FXML private JFXButton ligneButton;
    @FXML private JFXButton rectangleButton;
    @FXML private JFXButton carreButton;
    @FXML private JFXButton selectionButton;
    @FXML private JFXButton triangleButton;
    @FXML private JFXButton circleButton;
    @FXML private JFXButton ovalButton;
    @FXML private JFXButton triangleRectangleButton;
    @FXML private JFXButton losangeButton;
    @FXML private JFXButton pentagoneButton;
    @FXML private JFXButton hexagoneButton;
    @FXML private JFXButton flecheButton;
    @FXML private JFXButton rectangleArrondiButton;
    @FXML private JFXButton courbeButton;
    @FXML private JFXButton legendeButton;
    @FXML private JFXButton etoileButton;
    @FXML private AnchorPane parentCanvas;
    @FXML private Label labPointer;
    @FXML private Label labSizeCanvas;
    @FXML private Label labSizeSelect;
    @FXML private AnchorPane canvas;
    @FXML private JFXColorPicker colorPick2;
    @FXML private JFXColorPicker colorPick1;
    @FXML private JFXComboBox<String> comboTaille;
    @FXML private JFXCheckBox contourCheck;
    @FXML private JFXCheckBox remplissageCheck;
    @FXML private VBox boxProperty;
    @FXML private AnchorPane paneForme;
    @FXML private Rectangle rectSarisary;
    @FXML private Circle circleResize;
    @FXML private MenuItem menuRetour;
    @FXML private MenuItem menuAvance;
    @FXML private MenuItem menuSupprimer;
    @FXML private MenuItem menuSauver;
    @FXML private JFXButton selectColorButton;
    @FXML private Rectangle rectIndication;
    @FXML private MenuItem menuNouveau;
    @FXML private VBox boxButtonFormes;
    @FXML private VBox boxButtonOutils;
    @FXML private AnchorPane paneText;
    @FXML private AnchorPane taillePane;
    @FXML private JFXTextArea textArea;
    @FXML private JFXRadioButton radioOpaque;
    @FXML private ToggleGroup toogleGroup;
    @FXML private JFXRadioButton radioTransparent;
    @FXML private JFXTextField textFieldPolice;
    @FXML private JFXButton buttonPolice;
    @FXML private JFXTextField fieldTaillePolice;
    @FXML private JFXButton buttonTaillePolice;
    @FXML private JFXCheckBox checkGras;
    @FXML private JFXCheckBox checkItalique;
    @FXML private JFXCheckBox checkSouligne;
    @FXML private JFXCheckBox checkBarre;
    @FXML private JFXTextField textFieldRotation;
    @FXML private JFXButton buttonRotation;
    @FXML private AnchorPane rotationPane;
    @FXML private MenuItem menuAide;



    private final int CRAYON = 1;
    private final int PINCEAU = 2;
    private final int REMPLISSAGE = 3;
    private final int TEXT = 4;
    private final int GOMME = 5;
    private final int CIRCLE = 10;
    private final int ARC = 11;
    private final int LINE = 12;
    private final int TRIANGLERECTANGLE = 13;
    private final int RECTANGLE = 14;
    private final int CARRE = 15;
    private final int TRIANGLE = 16;
    private final int ELLIPSE = 17;
    private final int PIPETTE = 18;
    private final int RECTANGLEARRONDI = 19;
    private final int LOSANGE = 21;
    private final int PENTAGONE = 22;
    private final int HEXAGONE = 23;
    private final int FLECHE = 24;
    private final int COURBE = 25;
    public final int LEGENDE = 26;
    public final int ETOILE = 27;
    public final int IMAGE = 28;
    
    private final ObservableList<Node> listeButton = FXCollections.observableArrayList();
    
    private final IntegerProperty IDENTITY = new SimpleIntegerProperty(0);
    private final ObjectProperty<Cursor> CURSOR = new SimpleObjectProperty<>(Cursor.DEFAULT);
    private final ObservableList<MyAction> listeAction = FXCollections.observableArrayList();
    private final ObservableList<MyAction> listeActionA = FXCollections.observableArrayList();
    private final ObjectProperty<MyShape> mShapeSelected = new SimpleObjectProperty<>();
    private int selectedColorPick = 1;
    private final BooleanProperty sauver = new SimpleBooleanProperty(true);
    
    private final ObjectProperty<MyLine> mLineProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<MyRectangle> mRectangleProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<MyCircle> mCircleProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<MyEllipse> mEllipseProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<MyArc> mArcProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<MyPolygon> mPolygonProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<MyLegende> mLegendProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<MyLineElements> mLineElementProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<MyCourbe> mCourbeProperty = new SimpleObjectProperty<>();
    
    private Cursor crayon;
    private Cursor pinceau;
    private final Circle CCurseur = new Circle();
    private final ContextMenu menuPolice = new ContextMenu();
    private final ContextMenu menuTaillPolice = new ContextMenu();
    private final ContextMenu menuRotation = new ContextMenu();
    
    private ObjectProperty<File> file = new SimpleObjectProperty<>();
    
    private double oldWidth, oldHeight;
    protected boolean modifier = false;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /* rotation
                angle = Math.PI/2-Math.athan2( cordSourisX-centrexObjet, cordSourisY-centreyObjet);
         */

        CCurseur.radiusProperty().bind(comboTaille.getSelectionModel().selectedIndexProperty().add(1).multiply(3));
        CCurseur.setStroke(Color.BLACK);
        CCurseur.setMouseTransparent(true);
        
        crayon = new ImageCursor(new Image(getClass().
                getResourceAsStream("/mg/projetJava2019/paint/interfaces/image/cursor/pencil_50px.png")),
                0, 50);
        pinceau = new ImageCursor(new Image(getClass().
                getResourceAsStream("/mg/projetJava2019/paint/interfaces/image/cursor/Marker_Pen_50px.png")),
                0, 50);
        
        listeButton.addAll(panePallete.lookupAll(".vbox .vbox-outils .jfx-button"));
        
        colorPick1.setValue(Color.BLACK);
        colorPick2.setValue(Color.WHITE);
        colorPick1.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(IDENTITY.get()==PINCEAU){
                CCurseur.setFill(colorPick1.getValue());
            }
            if(mShapeSelected.get()!=null){
                if(IDENTITY.get()==TEXT){
                    mShapeSelected.get().getChild().setFill(newValue);
                }
                else{
                    ObservableList<Paint> lp= mShapeSelected.get().getCopyPaint();
                    mShapeSelected.get().getChild().setStroke(newValue);
                    ajouterALaListeAction( new MyAction(mShapeSelected.get(), lp, mShapeSelected.get().getCopyDouble()));
                }
            }
        });
        
        colorPick1.setOnMousePressed((event) -> {
            selectedColorPick = 1;
            rectIndication.setLayoutX(35);
        });
        
        colorPick2.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(mShapeSelected.get()!=null){
                if(IDENTITY.get()==TEXT && radioOpaque.isSelected()){
                        ((MyText) mShapeSelected.get()).setFill(newValue);
                }
                else if(remplissageCheck.isSelected()){
                    ObservableList<Paint> lp= mShapeSelected.get().getCopyPaint();
                    mShapeSelected.get().getChild().setFill(newValue);
                    ajouterALaListeAction( new MyAction(mShapeSelected.get(), lp, mShapeSelected.get().getCopyDouble()));
                }
            }
        });
        
        colorPick2.setOnMousePressed((event) -> {
            selectedColorPick = 2;
            rectIndication.setLayoutX(115);
        });

        comboTaille.getItems().addAll( "Niveau 1", "Niveau 2", "Niveau 3", "Niveau 4");
        comboTaille.getSelectionModel().select(0);
        comboTaille.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            if(mShapeSelected.get()!=null){
                ObservableList<Double> ld= mShapeSelected.get().getCopyDouble();
                mShapeSelected.get().getChild().setStrokeWidth(
                        newValue.doubleValue() == 0? 1d : (newValue.doubleValue()+1)*2);
                ajouterALaListeAction( new MyAction(mShapeSelected.get(), mShapeSelected.get().getCopyPaint(),ld));
            }
        });
        
        contourCheck.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(mShapeSelected.get()!=null){
                double strokeWidth = Double.valueOf(comboTaille.getSelectionModel().getSelectedIndex()+1);
                ObservableList<Double> ld= mShapeSelected.get().getCopyDouble();
                if(newValue)
                    mShapeSelected.get().getChild().setStrokeWidth(strokeWidth==1d? 1 : strokeWidth*2);
                else
                    mShapeSelected.get().getChild().setStrokeWidth(0);
                ajouterALaListeAction( new MyAction(mShapeSelected.get(), mShapeSelected.get().getCopyPaint(),  ld));
            }
        });
        
        remplissageCheck.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(mShapeSelected.get()!=null){
                ObservableList<Paint> lp= mShapeSelected.get().getCopyPaint();
                if(newValue)
                    mShapeSelected.get().getChild().setFill(colorPick2.getValue());
                else
                    mShapeSelected.get().getChild().setFill(Color.TRANSPARENT);
                ajouterALaListeAction( new MyAction(mShapeSelected.get(), lp, mShapeSelected.get().getCopyDouble()));
            }
        });
        boxProperty.getChildren().removeAll(paneForme, paneText, rotationPane);
        
        parentCanvas.minWidthProperty().bind(parentCanvas.prefWidthProperty());
        parentCanvas.minHeightProperty().bind(parentCanvas.prefHeightProperty());
        parentCanvas.maxWidthProperty().bind(parentCanvas.prefWidthProperty());
        parentCanvas.maxHeightProperty().bind(parentCanvas.prefHeightProperty());
        
        circleResize.centerXProperty().bindBidirectional(parentCanvas.prefWidthProperty());
        circleResize.centerYProperty().bindBidirectional(parentCanvas.prefHeightProperty());
        
        circleResize.setOnMousePressed((event) -> {
            oldWidth = parentCanvas.getPrefWidth();
            oldHeight = parentCanvas.getPrefHeight();
        });
        
        circleResize.setOnMouseDragged((event) -> {
            if(circleResize.getCenterX()>=0){
                circleResize.setCenterX(event.getX());
                if(circleResize.getCenterX()<0)
                    circleResize.setCenterX(0);
            }

            if(circleResize.getCenterY()>=0){
                circleResize.setCenterY(event.getY());
                if(circleResize.getCenterY()<0)
                    circleResize.setCenterY(0);
            }
            modifier = true;
        });
        
        circleResize.setOnMouseReleased((event) -> {
            ajouterALaListeAction( new MyAction( parentCanvas, oldWidth, oldHeight));
        });
        
        rectSarisary.widthProperty().bind(canvas.widthProperty());
        rectSarisary.heightProperty().bind(canvas.heightProperty());
        canvas.cursorProperty().bind(CURSOR);

        crayonButton.setOnAction((event) -> {
            IDENTITY.set(CRAYON);
            selectButton(crayonButton);
        });

        pinceauButton.setOnAction((event) -> {
            IDENTITY.set(PINCEAU);
            selectButton(pinceauButton);
        });

        remplissageButton.setOnAction((event) -> {
            IDENTITY.set(REMPLISSAGE);
            selectButton(remplissageButton);
        });

        textButton.setOnAction((event) -> {
            IDENTITY.set(TEXT);
            selectButton(textButton);
        });

        gommeButton.setOnAction((event) -> {
            IDENTITY.set(GOMME);
            selectButton(gommeButton);
        });

        circleButton.setOnAction((event) -> {
            IDENTITY.set(CIRCLE);
            selectButton(circleButton);
        });

        arcButton.setOnAction((event) -> {
            IDENTITY.set(ARC);
            selectButton(arcButton);
        });

        ligneButton.setOnAction((event) -> {
            IDENTITY.set(LINE);
            selectButton(ligneButton);
        });

        triangleRectangleButton.setOnAction((event) -> {
            IDENTITY.set(TRIANGLERECTANGLE);
            selectButton(triangleRectangleButton);
        });
        
        losangeButton.setOnAction((event) -> {
            IDENTITY.set(LOSANGE);
            selectButton(losangeButton);
        });
        
        pentagoneButton.setOnAction((event) -> {
            IDENTITY.set(PENTAGONE);
            selectButton(pentagoneButton);
        });
        
        hexagoneButton.setOnAction((event) -> {
            IDENTITY.set(HEXAGONE);
            selectButton(hexagoneButton);
        });
        
        flecheButton.setOnAction((event) -> {
            IDENTITY.set(FLECHE);
            selectButton(flecheButton);
        });

        rectangleButton.setOnAction((event) -> {
            IDENTITY.set(RECTANGLE);
            selectButton(rectangleButton);
        });
        
        rectangleArrondiButton.setOnAction((event) -> {
            IDENTITY.set(RECTANGLEARRONDI);
            selectButton(rectangleArrondiButton);
        });
        
        courbeButton.setOnAction((event) -> {
            IDENTITY.set(COURBE);
            selectButton(courbeButton);
        });
        
        legendeButton.setOnAction((event) -> {
            IDENTITY.set(LEGENDE);
            selectButton(legendeButton);
        });
        
        etoileButton.setOnAction((event) -> {
            IDENTITY.set(ETOILE);
            selectButton(etoileButton);
        });

        ovalButton.setOnAction((event) -> {
            IDENTITY.set(ELLIPSE);
            selectButton(ovalButton);
        });

        triangleButton.setOnAction((event) -> {
            IDENTITY.set(TRIANGLE);
            selectButton(triangleButton);
        });

        selectionButton.setOnAction((event) -> {
            IDENTITY.set(0);
            selectButton(selectionButton);
        });
        
        carreButton.setOnAction((event) -> {
            IDENTITY.set(CARRE);
            selectButton(carreButton);
        });
        
        selectColorButton.setOnAction((event) -> {
            IDENTITY.set(PIPETTE);
            selectButton(selectColorButton);
        });

        canvas.setOnMouseEntered((event) -> {
            if(IDENTITY.get()==PINCEAU || IDENTITY.get()==GOMME){
                parentCanvas.getChildren().add(CCurseur);
                CCurseur.setCenterX(event.getX());
                CCurseur.setCenterY(event.getY());
            }
        });
        
        canvas.setOnMouseMoved((event) -> {
            if(IDENTITY.get()==PINCEAU || IDENTITY.get()==GOMME){
                CCurseur.setCenterX(event.getX());
                CCurseur.setCenterY(event.getY());
            }
            labPointer.setText(event.getX()+", "+event.getY());
        });

        canvas.setOnMouseExited((event) -> {
            if(IDENTITY.get()==PINCEAU || IDENTITY.get()==GOMME){
                parentCanvas.getChildren().remove(CCurseur);
            }
            labPointer.setText("");
        });

        labSizeCanvas.setText( canvas.getWidth()+"x"+canvas.getHeight());
        canvas.widthProperty().addListener((observable, oldValue, newValue) -> {
            labSizeCanvas.setText( newValue+"x"+canvas.getHeight());
            deSelect();
        });

        canvas.heightProperty().addListener((observable, oldValue, newValue) -> {
            labSizeCanvas.setText( canvas.getWidth()+"x"+newValue);
            deSelect();
        });
        
        textArea.textProperty().addListener((observable, oldValue, newValue) -> {
            if(mShapeSelected.get()!=null){
                MyText mText = (MyText) mShapeSelected.get();
                mText.getChild().setText(newValue.isEmpty() ? "Texte" : newValue);
            }
        });
        
        toogleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.equals( radioOpaque)){
                ((MyText) mShapeSelected.get()).setFill(colorPick2.getValue());
            }
            else{
                ((MyText) mShapeSelected.get()).setFill(Color.TRANSPARENT);
            }
        });

        ObservableList<String> listeRotation = FXCollections.observableArrayList(
                "0","45","90","135","180","225","270","315"
        );
        for(String rot : listeRotation ){
            MenuItem rdb = new MenuItem();
            Label lab = new Label(rot);
            rdb.setGraphic(lab);
            rdb.getStyleClass().add("radio-color");
            menuRotation.getItems().add(rdb);
            rdb.setOnAction((event) -> {
                ObservableList<Double> ld = mShapeSelected.get().getCopyDouble();
                ((Border) mShapeSelected.get()).setRotate(Integer.parseInt(rot));
                ajouterALaListeAction( new MyAction(mShapeSelected.get(), mShapeSelected.get().getCopyPaint(),ld));
            });
        }

        textFieldRotation.textProperty().addListener((observable, oldValue, newValue) -> {
            try{
                Double.parseDouble(newValue);
            }catch(NumberFormatException e){
                textFieldRotation.setText(oldValue);
            }
        });
        textFieldRotation.focusedProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList<Double> ld = mShapeSelected.get().getCopyDouble();
            ((Border) mShapeSelected.get()).setRotate(Integer.parseInt(textFieldRotation.getText()));
            ajouterALaListeAction( new MyAction(mShapeSelected.get(), mShapeSelected.get().getCopyPaint(),ld));
        });
        buttonRotation.setOnMouseClicked((event) -> {
            Point point = MouseInfo.getPointerInfo().getLocation();
            menuRotation.show( buttonRotation, point.x, point.y);
        });
        rotationPane.parentProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue != null)
                textFieldRotation.setText("0.0");
        });

        for(String font : Utility.getListFont() ){
            MenuItem rdb = new MenuItem();
            Label lab = new Label(font);
            lab.setFont(Font.font(font));
            rdb.setGraphic(lab);
            rdb.getStyleClass().add("radio-color");
            menuPolice.getItems().add(rdb);
            rdb.setOnAction((event) -> {
                textFieldPolice.setText(font);
                if(mShapeSelected.get()!=null){
                    ((MyText) mShapeSelected.get()).getChild()
                            .setFont( getFont());
                }
            });
            if(textFieldPolice.getText().isEmpty()){
                textFieldPolice.setText(font);
            }
        }
        buttonPolice.setOnMouseClicked((event) -> {
            Point point = MouseInfo.getPointerInfo().getLocation();
            menuPolice.show( buttonPolice, point.x, point.y);
        });
        textFieldPolice.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue)
                ((MyText) mShapeSelected.get()).getChild().setFont( getFont());
        });
        
        ObservableList<String> listeTaillePolice = FXCollections.observableArrayList(
                "8","9","10","11","12","14","16","18","20","22","24","26","28","36","48","72"
        );
        for(String fontSize : listeTaillePolice ){
            MenuItem rdb = new MenuItem();
            Label lab = new Label(fontSize);
            rdb.setGraphic(lab);
            rdb.getStyleClass().add("radio-color");
            menuTaillPolice.getItems().add(rdb);
            rdb.setOnAction((event) -> {
                fieldTaillePolice.setText(fontSize);
                if(mShapeSelected.get()!=null){
                    ((MyText) mShapeSelected.get()).getChild().setFont(getFont());
                }
            });
            if(fieldTaillePolice.getText().isEmpty()){
                fieldTaillePolice.setText(fontSize);
            }
        }
        buttonTaillePolice.setOnMouseClicked((event) -> {
            Point point = MouseInfo.getPointerInfo().getLocation();
            menuTaillPolice.show( buttonTaillePolice, point.x, point.y);
        });
        
        fieldTaillePolice.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                double value = Double.parseDouble(newValue);
            } catch (NumberFormatException e) {
                fieldTaillePolice.setText(oldValue);
            }
        });
        fieldTaillePolice.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue)
                ((MyText) mShapeSelected.get()).getChild().setFont(getFont());
        });
        
        checkSouligne.selectedProperty().addListener((observable, oldValue, newValue) -> {
            ((MyText) mShapeSelected.get()).getChild().setUnderline(newValue);
        });
        
        checkGras.selectedProperty().addListener((observable, oldValue, newValue) -> {
            ((MyText) mShapeSelected.get()).getChild().setFont(getFont());
        });
        
        checkItalique.selectedProperty().addListener((observable, oldValue, newValue) -> {
            ((MyText) mShapeSelected.get()).getChild().setFont(getFont());
        });
        
        checkBarre.selectedProperty().addListener((observable, oldValue, newValue) -> {
            ((MyText) mShapeSelected.get()).getChild().setStrikethrough(newValue);
        });
        
        IDENTITY.addListener((observable, oldValue, newValue) -> {
            deSelect();
            boxProperty.getChildren().removeAll(taillePane, paneForme, paneText, rotationPane);
            switch(newValue.intValue()){
                case LINE:
                case RECTANGLE:
                case CARRE:
                case TRIANGLE:
                case TRIANGLERECTANGLE:
                case CIRCLE:
                case ELLIPSE:
                case ARC:
                case RECTANGLEARRONDI:
                case LOSANGE:
                case PENTAGONE:
                case HEXAGONE:
                case FLECHE:
                case COURBE:
                case LEGENDE:
                case ETOILE:
                    boxProperty.getChildren().addAll(taillePane, paneForme);
                    CURSOR.set(Cursor.CROSSHAIR);
                    break;
                case CRAYON:
                    CURSOR.set(crayon);
                    boxProperty.getChildren().add(taillePane);
                    break;
                case PINCEAU:
                    CURSOR.set(pinceau);
                    CCurseur.setFill(colorPick1.getValue());
                    CCurseur.setStrokeWidth(0);
                    boxProperty.getChildren().add(taillePane);
                    break;
                case GOMME:
                    CURSOR.set(Cursor.NONE);
                    CCurseur.setFill(Color.WHITE);
                    CCurseur.setStrokeWidth(1);
                    boxProperty.getChildren().add(taillePane);
                    break;
                case TEXT:
                    CURSOR.set(Cursor.TEXT);
                    break;
                default:
                    CURSOR.set(Cursor.DEFAULT);
                    break;
                case IMAGE:
                    boxProperty.getChildren().addAll(rotationPane);
                    System.out.println("id change");
                    break;
            }
        });

        mShapeSelected.addListener((observable, oldValue, newValue) -> {
              if(newValue != null){
                  labSizeSelect.setText(newValue.getPrefWidth()+"x"+newValue.getPrefHeight());

                  newValue.prefWidthProperty().addListener((obs, oldV, newV) -> {
                      labSizeSelect.setText(newV+"x"+newValue.getPrefHeight());
                  });

                  newValue.prefHeightProperty().addListener((obs, oldV, newV) -> {
                      labSizeSelect.setText(newValue.getPrefWidth()+"x"+newV);
                  });
                  
                  newValue.parentProperty().addListener((obs, oldV, newV) -> {
                      if(newV==null)
                          menuSupprimer.setDisable(true);
                      else
                          menuSupprimer.setDisable(false);
                  });

                  if(newValue instanceof Border) {
                      ((Border) newValue).rotateProperty().addListener((obs, oldV, newV) -> {
                          textFieldRotation.setText(String.valueOf(newV));
                      });
                  }

                  menuSupprimer.setDisable(false);
                  ajouterALaListeAction( new MyAction( MyAction.AJOUT, newValue, canvas));
                  System.out.println("true");
              }
              else{
                  labSizeSelect.setText("");
                  menuSupprimer.setDisable(true);
                  textArea.setText("");
                  boxProperty.getChildren().remove(rotationPane);
                  System.out.println("false");
              }
        });
        menuSauver.disableProperty().bind(sauver);
        
        listeAction.addListener((Observable c) -> {
            menuRetour.setDisable( listeAction.isEmpty());
            sauver.set(false);
        });
        
        listeActionA.addListener((Observable c) -> {
            menuAvance.setDisable( listeActionA.isEmpty());
        });
        
        rectSarisary.setOnMousePressed((MouseEvent event) -> {
            if(IDENTITY.get()!=0) {
                deSelect();
                boxProperty.getChildren().remove(rotationPane);
                Paint strokeColor = colorPick1.getValue();
                Paint fillColor = remplissageCheck.isSelected()? colorPick2.getValue():Color.TRANSPARENT;
                double taille = Double.valueOf(comboTaille.getSelectionModel().getSelectedIndex()+1);
                double strokeWidth = contourCheck.isSelected()? (taille==1d? 1 : taille*2) : 0d;
                int id = 0;
                switch(IDENTITY.get()){
                    case CRAYON:
                    case PINCEAU:
                    case GOMME:
                        
                        if(IDENTITY.get()==CRAYON)
                            id = MyLineElements.CRAYON;
                        else if(IDENTITY.get()==PINCEAU)
                            id = MyLineElements.PINCEAU;
                        else if(IDENTITY.get()==GOMME)
                            id = MyLineElements.GAUMME;
                        
                        MyLineElements mElmt = new MyLineElements( id, event.getX(), event.getY(), 
                                strokeColor, taille, canvas);
                        mElmt.ajoutPoints(event.getX(), event.getY());
                        mLineElementProperty.set(mElmt);
                        ajouterALaListeAction( new MyAction(mElmt, canvas));
                        break;
                    case REMPLISSAGE:
                        break;
                    case PIPETTE:
                        if(selectedColorPick == 1)
                            colorPick1.setValue( Utility.getColorOfPixel(canvas, (int)event.getX(), (int)event.getY()));
                        else
                            colorPick2.setValue( Utility.getColorOfPixel(canvas, (int)event.getX(), (int)event.getY()));
                        break;
                    case TEXT:
                        Text text = new Text();
                        text.setFont(getFont());
                        text.setFill(strokeColor);
                        text.setText("Texte");
                        text.setUnderline( checkSouligne.isSelected());
                        text.setStrikethrough( checkBarre.isSelected());
                        MyText mText = new MyText(text, listeAction);
                        mText.setLayoutX(event.getX());
                        mText.setLayoutY(event.getY());
                        if(radioOpaque.isSelected())
                            mText.setFill(colorPick2.getValue());
                        mText.setPrefSize( 200, 50);
                        canvas.getChildren().add(mText);
                        mShapeSelected.set(mText);
                        break;
                    case CIRCLE:
                        Circle circ = new Circle();
                        circ.setStroke( strokeColor);
                        circ.setFill( fillColor);
                        circ.setStrokeWidth(strokeWidth);
                        MyCircle mCircle = new MyCircle(circ, listeAction);
                        mCircle.setLayoutX(event.getX());
                        mCircle.setLayoutY(event.getY());
                        canvas.getChildren().add(mCircle);
                        mCircleProperty.set(mCircle);
                        mShapeSelected.set(mCircleProperty.get());
                        break;
                    case ARC:
                        Arc arc = new Arc();
                        arc.setStroke( strokeColor);
                        arc.setFill( fillColor);
                        arc.setStrokeWidth(strokeWidth);
                        MyArc mArc = new MyArc(arc, listeAction);
                        mArc.setLayoutX(event.getX());
                        mArc.setLayoutY(event.getY());
                        canvas.getChildren().add(mArc);
                        mArcProperty.set(mArc);
                        mShapeSelected.set(mArcProperty.get());
                        break;
                    case LINE:
                        Line line = new Line();
                        line.setStartX(event.getX());
                        line.setStartY(event.getY());
                        line.setEndX(event.getX());
                        line.setEndY(event.getY());
                        line.setStroke(strokeColor);
                        line.setStrokeWidth(taille==1d? 1 : taille*2);
                        MyLine mLine = new MyLine(line, listeAction);
                        canvas.getChildren().addAll(mLine.getChildren());
                        mLineProperty.set(mLine);
                        mShapeSelected.set(mLineProperty.get());
                        break;
                    case RECTANGLE:
                    case CARRE:
                    case RECTANGLEARRONDI:
                        Rectangle rect = new Rectangle();
                        rect.setStroke( strokeColor);
                        rect.setFill( fillColor);
                        rect.setStrokeWidth(strokeWidth);
                        
                        if(IDENTITY.get() == RECTANGLE)
                            id = MyRectangle.RECTANGLE;
                        else if(IDENTITY.get() == CARRE)
                            id = MyRectangle.CARRE;
                        else if(IDENTITY.get() == RECTANGLEARRONDI)
                            id = MyRectangle.RECTANGLEARRONDI;
                        
                        MyRectangle mRectangle = new MyRectangle( id, rect, listeAction);
                        mRectangle.setLayoutX(event.getX());
                        mRectangle.setLayoutY(event.getY());
                        canvas.getChildren().add(mRectangle);
                        mRectangleProperty.set(mRectangle);
                        mShapeSelected.set(mRectangleProperty.get());
                        break;
                    case TRIANGLE:
                    case TRIANGLERECTANGLE:
                    case LOSANGE:
                    case PENTAGONE:
                    case HEXAGONE:
                    case FLECHE:
                    case ETOILE:
                        Polygon polygon = new Polygon();
                        polygon.setStroke( strokeColor);
                        polygon.setFill( fillColor);
                        polygon.setStrokeWidth(strokeWidth);
                        
                        if(IDENTITY.get()==TRIANGLE)
                            id = MyPolygon.TRIANGLE;
                        else if(IDENTITY.get() == TRIANGLERECTANGLE)
                            id = MyPolygon.TRIANGLERECTANGLE;
                        else if(IDENTITY.get() == LOSANGE)
                            id = MyPolygon.LOSANGE;
                        else if(IDENTITY.get() == PENTAGONE)
                            id = MyPolygon.PENTAGONE;
                        else if(IDENTITY.get() == HEXAGONE)
                            id = MyPolygon.HEXAGONE;
                        else if(IDENTITY.get() == FLECHE)
                            id = MyPolygon.FLECHE;
                        else if(IDENTITY.get() == ETOILE)
                            id = MyPolygon.ETOILE;
                        
                        MyPolygon mPolygon = new MyPolygon( id, polygon, listeAction);
                        mPolygon.setLayoutX(event.getX());
                        mPolygon.setLayoutY(event.getY());
                        canvas.getChildren().add(mPolygon);
                        mPolygonProperty.set(mPolygon);
                        mShapeSelected.set(mPolygonProperty.get());
                        break;
                    case ELLIPSE:
                        Ellipse ellips = new Ellipse();
                        ellips.setStroke( strokeColor);
                        ellips.setFill( fillColor);
                        ellips.setStrokeWidth(strokeWidth);
                        MyEllipse mEllipse = new MyEllipse(ellips, listeAction);
                        mEllipse.setLayoutX(event.getX());
                        mEllipse.setLayoutY(event.getY());
                        canvas.getChildren().add(mEllipse);
                        mEllipseProperty.set(mEllipse);
                        mShapeSelected.set(mEllipseProperty.get());
                        break;
                    case COURBE:
                        CubicCurve corbe = new CubicCurve();
                        corbe.setStroke(strokeColor);
                        corbe.setFill(fillColor);
                        corbe.setStrokeWidth(strokeWidth);
                        corbe.setStartX(event.getX());
                        corbe.setStartY(event.getY());
                        corbe.setEndX(event.getX());
                        corbe.setEndY(event.getY());
                        corbe.setControlX1(corbe.getEndX());
                        corbe.setControlY1(corbe.getStartY());
                        corbe.setControlX2(corbe.getStartX());
                        corbe.setControlY2(corbe.getEndY());
                        MyCourbe mCourbe = new MyCourbe(corbe, listeAction);
                        mCourbe.setLayoutX(event.getX());
                        mCourbe.setLayoutY(event.getY());
                        canvas.getChildren().addAll(mCourbe.getChildren());
                        mCourbeProperty.set(mCourbe);
                        mShapeSelected.set(mCourbeProperty.get());
                        break;
                    case LEGENDE:
                        Ellipse ell = new Ellipse();
                        ell.setStroke( strokeColor);
                        ell.setFill( fillColor);
                        ell.setStrokeWidth( strokeWidth);
                        MyLegende mLegend = new MyLegende(ell, listeAction);
                        mLegend.setLayoutX(event.getX());
                        mLegend.setLayoutY(event.getY());
                        canvas.getChildren().add(mLegend);
                        mLegendProperty.set(mLegend);
                        mShapeSelected.set(mLegendProperty.get());
                        break;
                }
            }
        });
        
        rectSarisary.setOnMouseDragged((MouseEvent event) -> {
            if(IDENTITY.get()!=0) {
                switch (IDENTITY.get()) {
                    case CRAYON:
                    case PINCEAU:
                    case GOMME:
                        mLineElementProperty.get().ajoutPoints(event.getX(), event.getY());
                        CCurseur.setCenterX(event.getX());
                        CCurseur.setCenterY(event.getY());
                        break;
                    case REMPLISSAGE:
                        break;
                    case PIPETTE:
                        break;
                    case TEXT:
                        break;
                    case CIRCLE:
                        mCircleProperty.get().setPrefWidth(event.getX()-mCircleProperty.get().getLayoutX());
                        break;
                    case ARC:
                        mArcProperty.get().setPrefSize(
                                event.getX()-mArcProperty.get().getLayoutX(),
                                event.getY()-mArcProperty.get().getLayoutY());
                        break;
                    case LINE:
                        mLineProperty.get().getChild().setEndX(event.getX());
                        mLineProperty.get().getChild().setEndY(event.getY());
                        break;
                    case RECTANGLE:
                    case RECTANGLEARRONDI:
                        mRectangleProperty.get().setPrefSize(
                                event.getX()-mRectangleProperty.get().getLayoutX(),
                                event.getY()-mRectangleProperty.get().getLayoutY());
                        break;
                    case CARRE:
                        mRectangleProperty.get().setPrefWidth(
                                event.getX()-mRectangleProperty.get().getLayoutX());
                        break;
                    case TRIANGLE:
                    case TRIANGLERECTANGLE:
                    case LOSANGE:
                    case PENTAGONE:
                    case HEXAGONE:
                    case FLECHE:
                    case ETOILE:    
                        mPolygonProperty.get().setPrefSize(event.getX()-mPolygonProperty.get().getLayoutX(),
                                event.getY()-mPolygonProperty.get().getLayoutY());
                        break;
                    case ELLIPSE:
                        mEllipseProperty.get().setPrefSize(
                                event.getX()-mEllipseProperty.get().getLayoutX(),
                                event.getY()-mEllipseProperty.get().getLayoutY());
                        break;
                    case COURBE:
                        mCourbeProperty.get().getChild().setEndX(event.getX());
                        mCourbeProperty.get().getChild().setEndY(event.getY());
                        mCourbeProperty.get().getChild().setControlX1(mCourbeProperty.get().getChild().getEndX());
                        mCourbeProperty.get().getChild().setControlY1(mCourbeProperty.get().getChild().getStartY());
                        mCourbeProperty.get().getChild().setControlX2(mCourbeProperty.get().getChild().getStartX());
                        mCourbeProperty.get().getChild().setControlY2(mCourbeProperty.get().getChild().getEndY());
                        break;
                    case LEGENDE:
                        mLegendProperty.get().setPrefSize(
                                event.getX()-mLegendProperty.get().getLayoutX(),
                                event.getY()-mLegendProperty.get().getLayoutY());
                        break;
                }
            }
        });

        rectSarisary.setOnMouseReleased((event) -> {
            if(IDENTITY.get()!=0) {
                switch (IDENTITY.get()) {
                    case CRAYON:
                        break;
                    case PINCEAU:
                        break;
                    case REMPLISSAGE:
                        break;
                    case PIPETTE:
                        IDENTITY.set(0);
                        selectButton(selectionButton);
                        break;
                    case TEXT:
                        if(!boxProperty.getChildren().contains(paneText))
                            boxProperty.getChildren().add(paneText);
                        mShapeSelected.get().setSelected(true);
                        break;
                    case GOMME:
                        break;
                    case CIRCLE:
                        mCircleProperty.get().setSelected(true);
                        break;
                    case ARC:
                        mArcProperty.get().setSelected(true);
                        break;
                    case LINE:
                        mLineProperty.get().setSelected(true);
                        break;
                    case RECTANGLE:
                    case CARRE:
                    case RECTANGLEARRONDI:
                        mRectangleProperty.get().setSelected(true);
                        break;
                    case TRIANGLE:
                    case TRIANGLERECTANGLE:
                    case LOSANGE:
                    case PENTAGONE:
                    case HEXAGONE:
                    case FLECHE:
                    case ETOILE:
                        mPolygonProperty.get().setSelected(true);
                        break;
                    case ELLIPSE:
                        mEllipseProperty.get().setSelected(true);
                        break;
                    case COURBE:
                        mCourbeProperty.get().setSelected(true);
                        break;
                    case LEGENDE:
                        mLegendProperty.get().setSelected(true);
                        break;
                }
            }
            if(mShapeSelected.get() instanceof  Border){
                boxProperty.getChildren().add( mShapeSelected.get() instanceof MyText? 1 : 2, rotationPane);
            }
        });
        
        Rectangle rect = new Rectangle();
        rect.widthProperty().bind(canvas.widthProperty());
        rect.heightProperty().bind(canvas.heightProperty());
        canvas.setClip(rect);
    }
    
    private void deSelect(){
        if(mShapeSelected.get()!=null)
            mShapeSelected.get().setSelected(false);
        
        mShapeSelected.set(null);
        System.out.println("deselect");
    }
    
    private void selectButton(JFXButton button){
        listeButton.forEach((but) -> {
            if(but.equals(button)){
                if(!but.getStyleClass().contains("jfx-button-selected"))
                    but.getStyleClass().add("jfx-button-selected");
            }
            else{
                if(but.getStyleClass().contains("jfx-button-selected"))
                    but.getStyleClass().remove("jfx-button-selected");
            }
        });
    }
    
    private void ajouterALaListeAction( MyAction act){
        listeAction.add(act);
        listeActionA.clear();
    }
    
    @FXML
    private void delete(ActionEvent event) {
        if(mShapeSelected.get()!=null){
            if(mShapeSelected.get() instanceof Sommet){
                canvas.getChildren().removeAll(((Sommet)mShapeSelected.get()).getChildren());
            }
            else{
                canvas.getChildren().remove(mShapeSelected.get());
            }
            ajouterALaListeAction( new MyAction( MyAction.SUPPRIMER, mShapeSelected.get(), canvas));
        }
    }

    @FXML
    private void retour(ActionEvent event) {
        if(!listeAction.isEmpty()){
            MyAction act = listeAction.get( listeAction.size()-1);
            act.retour();
            listeAction.remove( listeAction.size()-1);
            listeActionA.add(act);
        }
    }

    @FXML
    private void avancer(ActionEvent event) {
        if(!listeActionA.isEmpty()){
            MyAction act = listeActionA.get( listeActionA.size()-1);
            act.avancer();
            listeActionA.remove( listeActionA.size()-1);
            listeAction.add(act);
        }
    }

    @FXML
    public void quiter(ActionEvent event) {
        if(root.lookupAll(".Quiter").isEmpty()){
            if(!sauver.get()){
                DialogConfirm dialog = new DialogConfirm("Quiter", "Enregistré la modification?", root, true, true, true);
                dialog.setOnAccept((evt) -> {
                    dialog.close();
                    if(Utility.saveImageAsPNG( canvas, file.get(), "Enregistrer") != null)
                        System.exit(0);
                });
                dialog.setOnRefuse((evt) -> {
                    dialog.close();
                    System.exit(0);
                });
                dialog.show();
            }
            else{
                System.exit(0);
            }
        }
    }
    
    private Font getFont(){
        return Font.font(textFieldPolice.getText(),
                            checkGras.isSelected()? FontWeight.BOLD : FontWeight.NORMAL,
                            checkItalique.isSelected()? FontPosture.ITALIC : FontPosture.REGULAR,
                            Double.parseDouble(fieldTaillePolice.getText())
                        );
    }
    
    @FXML
    private void changeColor(ActionEvent event) {
        Color color = colorPick1.getValue();
        colorPick1.setValue( colorPick2.getValue());
        colorPick2.setValue(color);
    }

    @FXML
    private void enregistrer(ActionEvent event) {
        deSelect();
        sauver.set(true);
        MenuItem m = (MenuItem)event.getSource();
        File f;
        if(m.equals(menuSauver))
            f = Utility.saveImageAsPNG(canvas, file.get(), "Enregistrer");
        else
            f = Utility.saveImageAsPNG(canvas, null, "Enregistrer sous...");
        
        if(f!=null){
            file.set(f);
            showNotification("Enregistrement avec succes");
        }
    }

    @FXML
    private void nouveau(ActionEvent event) {
        if(!sauver.get()){
            DialogConfirm dialog = new DialogConfirm("Nouveau", "Enregistré la modification?", root, true, true, true);
            dialog.setOnAccept((evt) -> {
                dialog.close();
                if(Utility.saveImageAsPNG( canvas, file.get(), "Enregistrer") != null){
                    removeCanvasChild();
                    sauver.set(true);
                }
            });
            dialog.setOnRefuse((evt) -> {
                dialog.close();
                removeCanvasChild();
                sauver.set(true);
            });
            dialog.show();
        }
        else{
            removeCanvasChild();
        }
    }

    @FXML
    private void ouvrirFichier(ActionEvent event) {
        if(!sauver.get()){
            DialogConfirm dialog = new DialogConfirm("Ouvrir", "Enregistré la modification?", root, true, true, true);
            dialog.setOnAccept((evt) -> {
                dialog.close();
                if(Utility.saveImageAsPNG( canvas, file.get(), "Enregistrer") != null){
                    if(ouvrirUnFichier())
                        sauver.set(true);
                }
            });
            dialog.setOnRefuse((evt) -> {
                dialog.close();
                if(ouvrirUnFichier())
                    sauver.set(true);
            });
            dialog.show();
        }
        else{
            ouvrirUnFichier();
        }
    }
    
    private boolean ouvrirUnFichier(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Ouvrir");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichier image", "*.png", "*.jpg", "*.jpeg"));
        if(file!=null)
            fileChooser.setInitialDirectory(file.get().getParentFile());
        File f = fileChooser.showOpenDialog(root.getScene().getWindow());
        double padding = 7;
        if(f!=null){
            try {
                IDENTITY.set(IMAGE);
                file.set(f);
                removeCanvasChild();
                Image image = new Image( new FileInputStream(file.get()));
                double w = image.getWidth(), h = image.getHeight();
                circleResize.setCenterX( w+padding);
                circleResize.setCenterY( h+padding);
                MyImage mImage = new MyImage(image, listeAction);
                mImage.setPrefWidth(w);
                mImage.setPrefHeight(h);
                mImage.prefWidthProperty().addListener((observable, oldValue, newValue) -> {
                    if(canvas.getPrefWidth()-newValue.doubleValue() < padding){
                        circleResize.setCenterX( newValue.doubleValue()+padding);
                    }
                });
                mImage.prefHeightProperty().addListener((observable, oldValue, newValue) -> {
                    if(canvas.getPrefHeight()-newValue.doubleValue() < padding){
                        circleResize.setCenterY(  newValue.doubleValue()+padding);
                    }
                });
                canvas.getChildren().add(mImage);
                mImage.setSelected(true);
                mShapeSelected.set(mImage);
                return true;
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
                return false;
            }
        }
        else{
            IDENTITY.set(0);
            return false;
        }
    }
    
    private void removeCanvasChild(){
        Rectangle rect = (Rectangle)canvas.getChildren().get(0);
        canvas.getChildren().clear();
        canvas.getChildren().add(rect);
    }

    @FXML
    private void aide(ActionEvent event) {
        Aide aide = new Aide( root.getScene().getWindow());
        aide.show();
    }
    
    private void showNotification( String text){
        final JFXSnackbar notification = new JFXSnackbar(root);
        EventHandler event = (EventHandler) (Event event1) -> {
            notification.close();
        };
        notification.show( text, "Reduire", 5000, event);
    }
    
    public ObjectProperty<File> getFile(){
        return file;
    }
}
