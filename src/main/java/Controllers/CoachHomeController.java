package Controllers;

import Application.DBClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class CoachHomeController {

    @FXML
    private AnchorPane root;

    @FXML
    private ImageView Close;

    @FXML
    private ImageView Minus;

    @FXML
    private Label welcomeLabel;

    @FXML
    void initialize() {
        welcomeLabel.setText("Bienvenue Coach " + DBClass.currentSession.getName().split(" ")[0]);
    }


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
    void EmploiAction(MouseEvent event) throws IOException {
        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/CoachTimeTable.fxml"));
        Scene adminScene = new Scene(root);
        primaryStage.setScene(adminScene);
        primaryStage.getScene().setFill(Color.TRANSPARENT);
    }


    @FXML
    void RankingAction(MouseEvent event) throws IOException {
        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/CoachRanking.fxml"));
        Scene adminScene = new Scene(root);
        primaryStage.setScene(adminScene);
        primaryStage.getScene().setFill(Color.TRANSPARENT);
    }


}
