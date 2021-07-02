package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MenuMahasiswa {

    @FXML
    private Button btn_pengajuanProposal;

    @FXML
    private Button btn_back;

    @FXML
    void PendaftaranUjian() throws IOException {
        btn_pengajuanProposal.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../fxmlClass/MenuMahasiswaUjian.fxml")));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();

    }

    @FXML
    void PengajuanProposal() throws IOException {
        btn_pengajuanProposal.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../fxmlClass/MenuMahasiswaProposal.fxml")));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
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
