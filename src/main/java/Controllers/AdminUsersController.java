package Controllers;

import java.io.IOException;

import Application.User;
import Application.DBClass;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AdminUsersController {
    @FXML
    TextField filterText;

    @FXML
    private Button addUserBtn;

    @FXML
    private Button updateBtn;

    @FXML
    private Button removeBtn;

    @FXML
    private ListView<User> listView;

    @FXML
    void initialize() {
        MongoCursor<User> cursor = DBClass.usersCollection.find((Filters.eq("type", "Adherent"))).iterator();
        try {
            while (cursor.hasNext()) {
                listView.getItems().add(cursor.next());
            }
        } finally {
            cursor.close();
        }
    }

    public void clearAndUpdateListView() {
        this.listView.getItems().clear();
        MongoCursor<User> cursor = DBClass.usersCollection.find((Filters.eq("type", "Adherent"))).iterator();
        try {
            while (cursor.hasNext()) {
                listView.getItems().add(cursor.next());
            }
        } finally {
            cursor.close();
        }
    }

    public void applyFilter() {
        listView.getItems().clear();
        MongoCursor<User> cursor = DBClass.usersCollection.find(Filters.and(Filters.regex("name", filterText.getText()), Filters.regex("type", "Adherent"))).iterator();
        try {
            while (cursor.hasNext()) {
                listView.getItems().add(cursor.next());
            }
        } finally {
            cursor.close();
        }
    }

    @FXML
    void SearchAction(ActionEvent event) {
        if(filterText.getText().isEmpty()) {
            clearAndUpdateListView();
        } else {
            applyFilter();
        }
    }

    @FXML
    void CoachsAction(ActionEvent event) throws IOException{
        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/AdminCoachs.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.getScene().setFill(Color.TRANSPARENT);
    }

    @FXML
    void RemoveAction(ActionEvent event) {
        DBClass.usersCollection.deleteMany(Filters.eq("email", DBClass.selectedUser.getEmail()));
        clearAndUpdateListView();
    }



    @FXML
    void UpdateAction(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/AdminEditUser.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.getScene().setFill(Color.TRANSPARENT);
    }


    @FXML
    void selectedItem(MouseEvent event) {
        DBClass.selectedUser = listView.getSelectionModel().getSelectedItem();
        // TODO: Remove later
        System.out.println(DBClass.selectedUser);
    }

    @FXML
    void PaidAction(ActionEvent event) throws IOException {
        DBClass.selectedUser.setPaid(!DBClass.selectedUser.getPaid());
        DBClass.usersCollection.findOneAndReplace(Filters.eq("email", DBClass.selectedUser.getEmail()), DBClass.selectedUser);

        clearAndUpdateListView();
    }

    @FXML

    void ReturnAction(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/AdminHome.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.getScene().setFill(Color.TRANSPARENT);
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
}
