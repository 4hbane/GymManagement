package Controllers;

import Application.DBClass;
import Application.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminAddCoachController {

    @FXML
    private AnchorPane root;

    @FXML
    private ImageView Close;

    @FXML
    private ImageView Minus;

    @FXML
    private TextField lastNameFld;

    @FXML
    private TextField firstNameFld;

    @FXML
    private TextField emailFld;

    @FXML
    private PasswordField passwordFld;

    @FXML
    private TextField phoneFld;

    @FXML
    void AddAction(ActionEvent event) throws IOException {
        User u = new User(firstNameFld.getText(), lastNameFld.getText(), passwordFld.getText(), emailFld.getText(), phoneFld.getText());
        u.setType("Coach");
        DBClass.usersCollection.insertOne(u);
        ReturnAction(event);
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
        Parent root = FXMLLoader.load(getClass().getResource("/AdminCoachs.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.getScene().setFill(Color.TRANSPARENT);
    }


}
