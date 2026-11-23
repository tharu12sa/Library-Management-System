package contollers.book;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import scene.SceneManager;

public class BookPageController {

    @FXML
    private Button btnAddBook;

    @FXML
    private Button btnAddMembers;

    @FXML
    private Button btnClick;

    @FXML
    private Button btnDashBoard;

    @FXML
    private Button btnHistory;

    @FXML
    private Button btnIssuseBook;

    @FXML
    private Button btnReturnBook;

    @FXML
    private TextField addAuthor;

    @FXML
    private TextField addBookID;

    @FXML
    private TextField addBookTitle;

    @FXML
    private ComboBox<?> addCategory;

    @FXML
    private DatePicker addYear;

    @FXML
    private TextField addquantity;

    @FXML
    void btnAddBookOnAction(ActionEvent event) {

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
    void btnClickOnAction(ActionEvent event) {
//        Stage stage = new Stage();
//        try {
//            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/add_book.fxml"))));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        stage.show();
        SceneManager.switchPage("/view/add_book.fxml");

    }

    @FXML
    void btnDashBoardOnAction(ActionEvent event) {
//        Stage stage=new Stage();
//        try {
//            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashBoard_page.fxml"))));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        stage.show();

        SceneManager.switchPage("/view/dashBoard_page.fxml");

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
    public void btnIssueBookOnAction(ActionEvent actionEvent) {
    }

    public void addBookOnAction(ActionEvent actionEvent) {
    }
}
