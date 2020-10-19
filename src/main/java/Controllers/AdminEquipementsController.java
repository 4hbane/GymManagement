package Controllers;

import Application.DBClass;
import Application.Equipment;
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
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminEquipementsController {

    @FXML
    private ImageView imageView;
    @FXML
    private Button addBtn;

    @FXML
    private Button updateBtn;

    @FXML
    private Button removeBtn;

    @FXML
    private ListView<Equipment> listView;

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
        Parent root = FXMLLoader.load(getClass().getResource("/AdminHome.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.getScene().setFill(Color.TRANSPARENT);
    }
    @FXML
    void initialize() {
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        MongoCursor<Equipment> cursor = DBClass.equipmentCollection.find().iterator();
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
        MongoCursor<Equipment> cursor = DBClass.equipmentCollection.find().iterator();
        try {
            while (cursor.hasNext()) {
                listView.getItems().add(cursor.next());
            }
        } finally {
            cursor.close();
        }
    }

    @FXML
    void AddAction(ActionEvent event) throws IOException {
        listView.getScene().getWindow().hide();
        Stage signUpStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/Holder.fxml"));
        Scene scene = new Scene(root);
        signUpStage.setScene(scene);
        signUpStage.show();
        signUpStage.setResizable(false);

    }

    @FXML
    void RemoveAction(ActionEvent event) {
        DBClass.equipmentCollection.deleteMany(Filters.eq("name", DBClass.selectedEquipement.getName()));
        clearAndUpdateListView();
    }

    @FXML
    void selectedItem(MouseEvent event) {
        DBClass.selectedEquipement = listView.getSelectionModel().getSelectedItem();
        //TODO: Sort out the new thing later create vars.
        imageView.setImage(new ImageView("Assets/Equipements/" + DBClass.selectedEquipement.getName().toString() + ".png").getImage());
        System.out.println(DBClass.selectedEquipement);
    }

    @FXML
    void UpdateAction(ActionEvent event) throws IOException {
        listView.getScene().getWindow().hide();
        Stage signUpStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/Holder.fxml"));
        Scene scene = new Scene(root);
        signUpStage.setScene(scene);
        signUpStage.show();
        signUpStage.setResizable(false);
        clearAndUpdateListView();
    }

}
