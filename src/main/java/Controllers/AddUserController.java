package Controllers;

import Application.DBClass;

import Application.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddUserController {

    @FXML
    void initialize() {

        typeChoiceBox.getItems().add("Client");
        typeChoiceBox.getItems().add("Admin");
        typeChoiceBox.getItems().add("Coach");

        firstNameFld.setText("First Name");
        lastNameFld.setText("Last Name");
        phoneFld.setText("0606060606");
        passwordFld.setText("HelloWorld");
    }

    @FXML
    private ChoiceBox<String> typeChoiceBox;

    @FXML
    private TextField phoneFld;

    @FXML
    private TextField emailFld;

    @FXML
    private TextField lastNameFld;

    @FXML
    private TextField passwordFld;

    @FXML
    private TextField firstNameFld;

    @FXML
    void addUser(ActionEvent event) throws IOException {
        User u = new User(firstNameFld.getText(), lastNameFld.getText(), passwordFld.getText(), emailFld.getText(), phoneFld.getText());
        u.setType(typeChoiceBox.getValue());
        DBClass.usersCollection.insertOne(u);

        typeChoiceBox.getScene().getWindow().hide();
        Stage signUpStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/AdminUsers.fxml"));
        Scene scene = new Scene(root);
        signUpStage.setScene(scene);
        signUpStage.show();
        signUpStage.setResizable(false);
    }

}
