package Controllers;

import Application.DBClass;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import sun.reflect.misc.FieldUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CoachTimeTableController {

    @FXML
    private  ImageView emploiView;

    @FXML
    private AnchorPane root;

    @FXML
    private ImageView Close;

    @FXML
    private ImageView Minus;

    //TODO Manals Code
    private FileChooser fileChooser;
    private File filePath;
    private Image image;
    private  BufferedImage bufferedImage;
    public Image getImage(){ return this.image; }
    public void setImage(Image image) { this.image= image; }



    @FXML
    void initialize() {
        try {
            bufferedImage = ImageIO.read(new File("src/main/resources/Assets/timetable.png")) ;
            Image image = SwingFXUtils.toFXImage(bufferedImage,null) ;
            this.setImage(image);
            emploiView.setImage(this.getImage());
        } catch(IOException e){
            e.printStackTrace();
        }    }


    @FXML
    public void Close(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML
    public void Minus(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void ReturnAction(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/CoachHome.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.getScene().setFill(Color.TRANSPARENT);
    }


    // TODO: Manals CODE.

    @FXML
    void modifyTimeTable(ActionEvent event) {
        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        fileChooser = new FileChooser() ;
        fileChooser.setTitle("open image") ;
        //set to user’s directory or go to the default C drive if cannot access
        File adminDirectory = new File(".") ;
        fileChooser.setInitialDirectory(adminDirectory) ;
        this.filePath = fileChooser.showOpenDialog(primaryStage) ;
        try {
            FileUtils.copyFile(this.filePath, new File("src/main/resources/Assets/timetable.png"));
            initialize();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

}
