package Controllers;

import Application.DBClass;
import Application.User;

import com.mongodb.client.model.Filters;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateUserController {

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
    void initialize() {
        typeChoiceBox.getItems().add("Client");
        typeChoiceBox.getItems().add("Admin");
        typeChoiceBox.getItems().add("Coach");

        firstNameFld.setText(DBClass.selectedUser.getName().split(" ")[0]);
        lastNameFld.setText(DBClass.selectedUser.getName().split(" ")[1]);
        emailFld.setText(DBClass.selectedUser.getEmail());
        phoneFld.setText(DBClass.selectedUser.getPhone());
        passwordFld.setText(DBClass.selectedUser.getPassword());
        typeChoiceBox.setValue(DBClass.selectedUser.getType());
    }


    @FXML
    void updateUser(ActionEvent event) throws IOException {
        User u = new User(firstNameFld.getText(), lastNameFld.getText(), passwordFld.getText(), emailFld.getText(), phoneFld.getText());
        u.setType(typeChoiceBox.getValue());
        DBClass.usersCollection.findOneAndReplace(Filters.eq("email", DBClass.selectedUser.getEmail()), u);

        Stage signUpStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/AdminUsers.fxml"));
        Scene scene = new Scene(root);
        signUpStage.setScene(scene);
        signUpStage.show();
        signUpStage.setResizable(false);
        signUpStage.getScene().setFill(Color.TRANSPARENT);

    }

}
