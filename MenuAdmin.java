package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MenuAdmin {

    @FXML
    private Button btn_Approval;

    @FXML
    private Button btn_back;


    @FXML
    void Approval() throws IOException {
        btn_Approval.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../fxmlClass/MenuAdminApproval.fxml")));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

    @FXML
    void NilaiPKN() {

    }

    @FXML
    void PenjadwalanUjian() {

    }

    @FXML
    void back() throws IOException {
        btn_back.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../fxmlClass/tampilanLogin.fxml")));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();

    }


}
