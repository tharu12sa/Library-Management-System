package contollers.member;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import scene.SceneManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MemberPageController implements Initializable {

    @FXML
    private Button btnAddBook;

    @FXML
    private Button btnAddMemberClick;

    @FXML
    private Button btnAddMembers;

    @FXML
    private Button btnDashBoard;

    @FXML
    private Button btnHistory;

    @FXML
    private Button btnIssuseBook;

    @FXML
    private Button btnReturnBook;

    @FXML
    void btnAddBookOnAction(ActionEvent event) {
//        Stage stage = new Stage();
//        try {
//            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/book_page.fxml"))));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        stage.show();

        SceneManager.switchPage("/view/book_page.fxml");

    }

    @FXML
    void btnAddMemberClickOnAction(ActionEvent event) {
//        Stage stage = new Stage();
//        try {
//            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/add_member.fxml"))));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        stage.show();

        SceneManager.switchPage("/view/add_member.fxml");

    }

    @FXML
    void btnAddMembersOnAction(ActionEvent event) {

    }

    @FXML
    void btnDashBoardOnAction(ActionEvent event) {
//        Stage stage=new Stage();
//        try {
//            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/home_page.fxml"))));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        stage.show();

        SceneManager.switchPage("/view/home_page.fxml");


    }

    @FXML
    void btnHistoryOnAction(ActionEvent event) {

    }



    @FXML
    void btnReturnBookOnAction(ActionEvent event) {

    }

    @FXML
    public void btnViewOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void btnIssueBookOnAction(ActionEvent actionEvent) {
    }

    private void setActiveButton(Button activeBtn) {
        Button[] allButtons = {
                btnDashBoard, btnAddBook, btnAddMembers,
                btnIssuseBook, btnReturnBook, btnHistory
        };

        for (Button btn : allButtons) {
            if (btn != null) {
                btn.getStyleClass().remove("nav-button-active");
                if (!btn.getStyleClass().contains("nav-button")) {
                    btn.getStyleClass().add("nav-button");
                }
            }
        }

        if (activeBtn != null) {
            activeBtn.getStyleClass().remove("nav-button");
            activeBtn.getStyleClass().add("nav-button-active");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setActiveButton(btnAddMembers);
    }
}
