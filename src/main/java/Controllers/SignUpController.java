package Controllers;

import Application.DBClass;
import Application.User;

import com.mongodb.MongoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SignUpController {

    @FXML
    private TextField phoneFld;

    @FXML
    private TextField passwordFld;

    @FXML
    private TextField emailFld;

    @FXML
    private TextField lastNameFld;

    @FXML
    private TextField firstNameFld;

    @FXML
    private Button singUpBtn;

    @FXML
    private Button loginBtn;

    void clearFields() {
        firstNameFld.clear();
        lastNameFld.clear();
        emailFld.clear();
        passwordFld.clear();
        phoneFld.clear();
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
    void LoginTabAction(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/Login.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.getScene().setFill(Color.TRANSPARENT);
    }

    @FXML
    void SingUpAction(ActionEvent event) throws IOException {
        User u = new User(firstNameFld.getText(), lastNameFld.getText(), passwordFld.getText(), emailFld.getText(), phoneFld.getText());
        try {
            DBClass.usersCollection.insertOne(u);
            System.out.println(u.toString());
            System.out.println("Successfully Inserted");
        } catch (MongoException e) {
            System.out.println("Encountered MongoException");
        }

        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/Login.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.getScene().setFill(Color.TRANSPARENT);
    }

}
