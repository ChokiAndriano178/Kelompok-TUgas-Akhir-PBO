package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;

public class ControllerLogin implements Initializable {

    @FXML
    private AnchorPane pane_login;

    @FXML
    private TextField txt_username;

    @FXML
    private PasswordField txt_password;

    @FXML
    private ComboBox<String> type;

    @FXML
    private Button btn_login;

    @FXML
    private AnchorPane pane_signup;

    @FXML
    private TextField txt_username_up;

    @FXML
    private TextField txt_password_up;

    @FXML
    private TextField email_up;

    @FXML
    private ComboBox<String> type_up;


    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public void LoginpaneShow(){

        pane_login.setVisible(true);
        pane_signup.setVisible(false);
    }

    public void SignuppaneShow(){

        pane_login.setVisible(false);
        pane_signup.setVisible(true);
    }


    @FXML
    private void Login() {
        conn = mysqlconnect.ConnectDb();
        String sql = "Select * from users where username = ? and password = ? and type = ? ";
        try {
            assert conn != null;
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_username.getText());
            pst.setString(2, txt_password.getText());
            pst.setString(3, type.getValue());

            rs = pst.executeQuery();
            String dataLogin = type.getValue();

            if(rs.next()){
                switch (dataLogin) {
                    case "Mahasiswa": {
                        JOptionPane.showMessageDialog(null, "Username dan Password Benar");

                        btn_login.getScene().getWindow().hide();
                        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../fxmlClass/MenuMahasiswa.fxml")));
                        Stage mainStage = new Stage();
                        Scene scene = new Scene(root);
                        mainStage.setScene(scene);
                        mainStage.show();
                        break;
                    }
                    case "Dosen": {
                        JOptionPane.showMessageDialog(null, "Username dan Password Benar");

                        btn_login.getScene().getWindow().hide();
                        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../fxmlClass/MenuDosen.fxml")));
                        Stage mainStage = new Stage();
                        Scene scene = new Scene(root);
                        mainStage.setScene(scene);
                        mainStage.show();
                        break;
                    }
                    case "Admin": {
                        JOptionPane.showMessageDialog(null, "Username dan Password Benar");

                        btn_login.getScene().getWindow().hide();
                        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../fxmlClass/MenuAdmin.fxml")));
                        Stage mainStage = new Stage();
                        Scene scene = new Scene(root);
                        mainStage.setScene(scene);
                        mainStage.show();
                        break;
                    }
                }
            }else
                JOptionPane.showMessageDialog(null, "Username atau Password Salah !!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tidak ada koneksi ke database : " + e);
        }

    }


    public void add_users(){
        conn = mysqlconnect.ConnectDb();
        String sql = "insert into users (username,password,type,email) values (?,?,?,?)";
        try {
            assert conn != null;
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_username_up.getText());
            pst.setString(2, txt_password_up.getText());
            pst.setString(3, type_up.getValue());
            pst.setString(4, email_up.getText());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Data telah disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data tidak disimpan");
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (ComboBox<String> comboBox : Arrays.asList(type_up, type))
            comboBox.getItems().addAll("Mahasiswa", "Dosen", "Admin");
    }

}