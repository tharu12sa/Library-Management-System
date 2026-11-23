package contollers.dashBoard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import scene.SceneManager;

import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardPageContoller implements Initializable {

    //Stage addBookStage = new Stage();

    @FXML
    private Button btnAddBook;

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
    private Button btnQuickAddBook;

    @FXML
    private Button btnQuickAddMember;

    @FXML
    private Button btnQuickViewAllBook;

    @FXML
    void btnAddBookOnAction(ActionEvent event) {

//        try {
//            addBookStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/book_page.fxml"))));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        addBookStage.show();
        SceneManager.switchPage("/view/book_page.fxml");

    }

    @FXML
    void btnAddMembersOnAction(ActionEvent event) {
//        Stage stage = new Stage();
//        try {
//            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/member_page.fxml"))));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        stage.show();

        SceneManager.switchPage("/view/member_page.fxml");
    }

    @FXML
    void btnDashBoardOnAction(ActionEvent event) {

    }

    @FXML
    void btnHistoryOnAction(ActionEvent event) {

    }

    @FXML
    void btnIssuseBookOnAction(ActionEvent event) {

    }

    @FXML
    void btnReturnBookOnAction(ActionEvent event) {

    }

    @FXML
    public void btnViewOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void btnIssuseOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void btnReturnOnAction(ActionEvent actionEvent) {
    }

    public void btnQABOOKOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/book_page.fxml");
    }

    public void btnQAViewOnActoin(ActionEvent actionEvent) {

    }

    public void btnQAMemberOnActoin(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/member_page.fxml");
    }

    private void setupQuickActionHoverEffect() {
        Button[] quickButtons = {btnQuickAddBook, btnQuickAddMember, btnQuickViewAllBook};

        for (Button hoveredBtn : quickButtons) {
            if (hoveredBtn == null) continue;

            hoveredBtn.hoverProperty().addListener((obs, wasHovered, isNowHovered) -> {
                for (Button otherBtn : quickButtons) {
                    if (otherBtn == null || otherBtn == hoveredBtn) continue;

                    if (isNowHovered) {
                        if (!otherBtn.getStyleClass().contains("quick-btn-green-highlight")) {
                            otherBtn.getStyleClass().add("quick-btn-green-highlight");
                        }
                    } else {
                        otherBtn.getStyleClass().remove("quick-btn-green-highlight");
                    }
                }
            });
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       // setActiveButton(btnDashBoard);
        setupQuickActionHoverEffect();
    }
}
