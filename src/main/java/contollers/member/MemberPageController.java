package contollers.member;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import scene.SceneManager;

public class MemberPageController {

    AddMemberController addMemberController = new AddMemberController();

    @FXML
    private Button btnAddBook;

    @FXML
    private Button btnAddMembers;

    @FXML
    private Button btnDashBoard;

    @FXML
    private Button btnHistory;

    @FXML
    private Button btnIssueBook;

    @FXML
    private Button btnReturnBook;

    @FXML
    private Button btnView;

    @FXML
    private DatePicker dateBirth;

    @FXML
    private TextArea txtAddress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtMemberID;

    @FXML
    private TextField txtNIC;

    @FXML
    private TextField txtName;

    @FXML
    void btnAddBookOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/book_page.fxml");

    }

    @FXML
    void btnAddMembersOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/member_page.fxml");

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnDashBoardOnAction(ActionEvent event) {

        SceneManager.switchPage("/view/dashBoard_page.fxml");

    }

    @FXML
    void btnHistoryOnAction(ActionEvent event) {

    }

    @FXML
    void btnIssueBookOnAction(ActionEvent event) {

    }

    @FXML
    void btnReturnBookOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveMemberOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewOnAction(ActionEvent event) {

    }

    @FXML
    public void btnGenerateIDOnAction(ActionEvent actionEvent) {
        String NIC = txtNIC.getText();

        if (NIC == null || NIC.trim().isEmpty()){
            new Alert(Alert.AlertType.WARNING, "Please add NIC Number!").show();
            return;
        }
        try {
            String memberID = addMemberController.generateMemberID(NIC);
            txtMemberID.setText(memberID);
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, "Failed to generate Book ID: " + e.getMessage()).show();
        }
    }
}

