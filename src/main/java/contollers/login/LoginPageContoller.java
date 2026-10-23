package contollers.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPageContoller {

    Stage mainDashBoard = new Stage();

    LoginContoller loginContoller = new LoginContoller();

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnreset;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    private Label lblError;

    @FXML
    void btnresetOnAction(ActionEvent event) {
        txtUserName.clear();
        txtPassword.clear();
        txtUserName.requestFocus();
    }

    @FXML
    void btnOnAction(ActionEvent event) {
//        if (LoginContoller.cheakUserNameAndPassword(txtUserName.getText(), txtPassword.getText())) {
//            Stage stage = new Stage();
//            try {
//                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/home_page.fxml"))));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            stage.show();
//        }else {
//            lblError.setText("Invalid Username or Password!");
//        }

       if(loginContoller.cheakUserNameAndPassword(txtUserName.getText(),txtPassword.getText())) {
           try {
               mainDashBoard.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/home_page.fxml"))));
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
           mainDashBoard.show();

       }
    }

    @FXML
    public void txtPasswordOnAction(KeyEvent keyEvent) {
        if(loginContoller.cheakUserNameAndPassword(txtUserName.getText(),txtPassword.getText())) {
            try {
                mainDashBoard.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/home_page.fxml"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            mainDashBoard.show();

        }
    }
}
