package Controllers;

import Application.DBClass;
import Application.Reservation;
import Application.User;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class ClientReserveCoachController {

    @FXML
    private AnchorPane root;

    @FXML
    private ImageView Close;

    @FXML
    private ImageView Minus;

    @FXML
    private TextField activity;

    @FXML
    private DatePicker date;

    @FXML
    private ChoiceBox<User> coachChoice;

    @FXML
    void initialize() {
        MongoCursor<User> cursor = DBClass.usersCollection.find((Filters.eq("type", "Coach"))).iterator();
        try {
            while (cursor.hasNext()) {
                coachChoice.getItems().add(cursor.next());
            }
        } finally {
            cursor.close();
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
    void ReturnAction(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/ClientHome.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.getScene().setFill(Color.TRANSPARENT);
    }

    @FXML
    void ReserveAction(ActionEvent event) {
        Reservation r = new Reservation(date.getValue(), activity.getText(), coachChoice.getSelectionModel().getSelectedItem().getName());
        DBClass.reservationCollection.insertOne(r);
    }

}
