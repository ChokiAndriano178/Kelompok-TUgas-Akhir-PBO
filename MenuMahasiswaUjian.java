package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MenuMahasiswaUjian {


    @FXML
    private Button btn_back;

    @FXML
    void back() throws IOException {
        btn_back.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../fxmlClass/MenuMahasiswa.fxml")));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();

    }

    @FXML
    void submitAll() {

    }

    @FXML
    void uploadLaporan() {

    }

    @FXML
    void uploadNilaiPerusahaan() {

    }

}
