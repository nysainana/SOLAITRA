
package mg.projetJava2019.paint.Objet;

import java.awt.GraphicsEnvironment;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

public class Utility {
    
    public ObservableList<Image> getListeImage(){
        Image logo1 = new Image(getClass().getResourceAsStream("/mg/projetJava2019/paint/interfaces/image/logos/Paint1.png"));
        Image logo2 = new Image(getClass().getResourceAsStream("/mg/projetJava2019/paint/interfaces/image/logos/Paint2.png"));
        Image logo3 = new Image(getClass().getResourceAsStream("/mg/projetJava2019/paint/interfaces/image/logos/Paint3.png"));
        return FXCollections.observableArrayList(logo1, logo2, logo3);
    }
    
    public static File saveImageAsPNG(AnchorPane node, File file, String titre){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(titre);

        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("png files (*.png)", "*.png"));
        if(file!=null)
            fileChooser.setInitialDirectory(file.getParentFile());
        
        File f = file==null? fileChooser.showSaveDialog(node.getScene().getWindow()) : file;

        if(f != null){
            try {
                WritableImage writableImage = new WritableImage((int)node.getWidth(), (int)node.getHeight());
                SnapshotParameters sp = new SnapshotParameters();
                sp.setViewport( new Rectangle2D( 0, 0, node.getWidth(), node.getHeight()));
                node.snapshot( sp, writableImage);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                ImageIO.write(renderedImage, "png", f);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return f;
    }
    
    public static Color getColorOfPixel(AnchorPane node, int x, int y){
        WritableImage writableImage = new WritableImage((int)node.getWidth(), (int)node.getHeight());
        SnapshotParameters sp = new SnapshotParameters();
        sp.setViewport( new Rectangle2D( 0, 0, node.getWidth(), node.getHeight()));
        return node.snapshot( sp, writableImage).getPixelReader().getColor(x, y);
    }
    
    public static ObservableList<String> getListFont(){
        ObservableList<String> listF = FXCollections.observableArrayList("Systemme");
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] listFont = ge.getAvailableFontFamilyNames();
        for(String font : listFont ){
            listF.add(font);
        }
        return listF;
    }
    
    public static String lireFichier( String filePath){
        try {
            File file = new File(filePath);
            Scanner scf = new Scanner(new BufferedReader(new FileReader(file)));
            String line = "";
            boolean b = false;
            while(scf.hasNextLine()){
                if(!b){
                    line =scf.nextLine(); 
                    b = true;
                }
                else{
                    line += "\n"+scf.nextLine();
                }
            }
            scf.close();
            return line;
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return "";
    }
    
}
