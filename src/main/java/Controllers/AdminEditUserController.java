package Controllers;

import Application.DBClass;
import Application.User;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminEditUserController {

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
    private TextField phoneFld;

    @FXML
    private ChoiceBox<Boolean> paidChoice;

    @FXML
    void initialize() {

        paidChoice.getItems().add(true);
        paidChoice.getItems().add(false);

        firstNameFld.setText(DBClass.selectedUser.getName().split(" ")[0]);
        lastNameFld.setText(DBClass.selectedUser.getName().split(" ")[1]);
        emailFld.setText(DBClass.selectedUser.getEmail());
        phoneFld.setText(DBClass.selectedUser.getPhone());
        paidChoice.setValue(DBClass.selectedUser.getPaid());
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
        Parent root = FXMLLoader.load(getClass().getResource("/AdminUsers.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.getScene().setFill(Color.TRANSPARENT);
    }

    @FXML
    void UpdateAction(ActionEvent event) throws IOException {
        String oldemail = DBClass.selectedUser.getEmail();
        DBClass.selectedUser.setName(firstNameFld.getText() + lastNameFld.getText());
        DBClass.selectedUser.setEmail(emailFld.getText());
        DBClass.selectedUser.setPhone(phoneFld.getText());
        DBClass.selectedUser.setPaid(paidChoice.getValue());

        DBClass.usersCollection.findOneAndReplace(Filters.eq("email", oldemail), DBClass.selectedUser);

        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/AdminUsers.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.getScene().setFill(Color.TRANSPARENT);

    }

}
