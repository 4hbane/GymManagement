package Controllers;

import Application.DBClass;
import Application.Reclamation;
import Application.User;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientReclamationController {

    @FXML
    private AnchorPane root;

    @FXML
    private ImageView Close;

    @FXML
    private Button sendBtn;

    @FXML
    private ImageView Minus;

    @FXML
    private Label reclamationSent;

    @FXML
    private TextField objectOfRec;

    @FXML
    private TextArea mainTextOfRec;

    @FXML
    void initialize() {
        reclamationSent.setVisible(false);
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
    void ReturnAction(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/ClientHome.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.getScene().setFill(Color.TRANSPARENT);
    }

    @FXML
    void SendAction(ActionEvent event) {
        if(!mainTextOfRec.getText().isEmpty() && !objectOfRec.getText().isEmpty()) {
            Reclamation r = new Reclamation(objectOfRec.getText(), mainTextOfRec.getText());
            DBClass.reclamationCollection.insertOne(r);

            objectOfRec.setVisible(false);
            mainTextOfRec.setVisible(false);
            sendBtn.setVisible(false);
            reclamationSent.setVisible(true);
        }
    }

}
