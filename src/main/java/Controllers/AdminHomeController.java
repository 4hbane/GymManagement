package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminHomeController {

    @FXML
    private AnchorPane root;

    @FXML
    private ImageView Close;

    @FXML
    private ImageView Minus;

    @FXML
    public void Close(javafx.scene.input.MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML
    public void Minus(javafx.scene.input.MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void EquipementAction(MouseEvent event) throws IOException {
        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/AdminEquipements.fxml"));
        Scene adminScene = new Scene(root);
        primaryStage.setScene(adminScene);
        primaryStage.getScene().setFill(Color.TRANSPARENT);
    }


    @FXML
    void TimeTableAction(MouseEvent event) throws IOException {
        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/AdminTimeTable.fxml"));
        Scene adminScene = new Scene(root);
        primaryStage.setScene(adminScene);
        primaryStage.getScene().setFill(Color.TRANSPARENT);
    }

    @FXML
    void UsersAction(MouseEvent event) throws IOException {
        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/AdminUsers.fxml"));
        Scene adminScene = new Scene(root);
        primaryStage.setScene(adminScene);
        primaryStage.getScene().setFill(Color.TRANSPARENT);
    }


    @FXML
    void ReclamationsAction(MouseEvent event) throws  IOException {
        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/AdminReclamations.fxml"));
        Scene adminScene = new Scene(root);
        primaryStage.setScene(adminScene);
        primaryStage.getScene().setFill(Color.TRANSPARENT);
    }
}
