package Controllers;

import Application.DBClass;

import Application.User;
import com.mongodb.client.model.Filters;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField passwordFld;

    @FXML
    private TextField emailFld;

    @FXML
    private Button loginBtn;

    @FXML
    private Button signUpBtn;

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

    void Login(Stage primaryStage) throws IOException {
        String mail = emailFld.getText();
        String pass = passwordFld.getText();
        User u = DBClass.usersCollection.find(Filters.eq("email", mail)).first();

        if(! u.equals(null)) {
            if(u.getPassword().equals(pass) && u.getType().equals("Admin")) {
                DBClass.currentSession = u;
                Parent root = FXMLLoader.load(getClass().getResource("/AdminHome.fxml"));
                Scene adminScene = new Scene(root);
                primaryStage.setScene(adminScene);
                primaryStage.getScene().setFill(Color.TRANSPARENT);
            }  else if ((u.getPassword().equals(pass) && u.getType().equals("Adherent"))) {
                DBClass.currentSession = u;
                Parent root = FXMLLoader.load(getClass().getResource("/ClientHome.fxml"));
                Scene adminScene = new Scene(root);
                primaryStage.setScene(adminScene);
                primaryStage.getScene().setFill(Color.TRANSPARENT);
            }  else if ((u.getPassword().equals(pass) && u.getType().equals("Coach"))) {
                DBClass.currentSession = u;
                Parent root = FXMLLoader.load(getClass().getResource("/CoachHome.fxml"));
                Scene adminScene = new Scene(root);
                primaryStage.setScene(adminScene);
                primaryStage.getScene().setFill(Color.TRANSPARENT);

            } else {
                // TODO: handle this later! Clear Fields
                System.out.println("Incorrect Password");
            }
        } else {
            // TODO: handle this later!
            System.out.println("User not in DB");
        }
    }

    @FXML
    void LoginAction(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Login(primaryStage);
    }

    @FXML
    void LoginActionKey(KeyEvent event) throws IOException {
        if(event.getCode().equals(KeyCode.ENTER)) {
            Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
            Login(primaryStage);
        }
    }

    @FXML
    void SignUpTabAction(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/SignUp.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.getScene().setFill(Color.TRANSPARENT);
    }
}
