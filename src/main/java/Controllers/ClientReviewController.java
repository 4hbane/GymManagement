package Controllers;

import Application.DBClass;
import Application.Review;
import Application.User;
import com.mongodb.client.model.Filters;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientReviewController {

    @FXML
    private AnchorPane root;

    @FXML
    private ImageView Close;

    @FXML
    private Button reviewBtn;
    @FXML
    private Button annulerBtn;

    @FXML
    private Label doneText;

    @FXML
    private ImageView Minus;

    @FXML
    private ChoiceBox<Integer> choiceRank;

    @FXML
    private Text coachName;

    @FXML
    private TextArea reviewText;

    @FXML
    void initialize() {
        doneText.setVisible(false);
        coachName.setText(DBClass.selectedUser.getName().split(" ")[0]);
        for(int i = 0; i < 10; i++) {
            choiceRank.getItems().add(i+1);
        }
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
    void ReviewAction(ActionEvent event) {
        DBClass.selectedUser.setRanking(DBClass.selectedUser.getRanking() + choiceRank.getValue());
        DBClass.usersCollection.findOneAndReplace(Filters.eq("email", DBClass.selectedUser.getEmail()), DBClass.selectedUser);

        Review r = new Review(DBClass.currentSession.getEmail(), DBClass.selectedUser.getEmail(), reviewText.getText());
        DBClass.reviewCollection.insertOne(r);

        choiceRank.setVisible(false);
        reviewText.setVisible(false);
        reviewBtn.setVisible(false);
        annulerBtn.setText("Retour");
        doneText.setVisible(true);



    }

    @FXML
    void ReturnAction(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/ClientRank.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.getScene().setFill(Color.TRANSPARENT);

    }

}
