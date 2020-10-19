package Controllers;

import Application.DBClass;
import Application.Review;
import Application.User;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.bson.Document;

import java.io.IOException;

public class CoachRankingController {

    @FXML
    private AnchorPane root;

    @FXML
    private ImageView Close;

    @FXML
    private ImageView Minus;

    @FXML
    private Label rank;

    @FXML
    private ListView<Review> listView;

    @FXML
    void initialize() {
        rank.setText(Long.toString(DBClass.reviewCollection.countDocuments(new Document())));
        MongoCursor<Review> cursor = DBClass.reviewCollection.find((Filters.eq("coachEmail", DBClass.currentSession.getEmail()))).iterator();
        try {
            while (cursor.hasNext()) {
                listView.getItems().add(cursor.next());
            }
        } finally {
            cursor.close();
        }
    }

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
    void ReturnAction(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/CoachHome.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.getScene().setFill(Color.TRANSPARENT);
    }

}
