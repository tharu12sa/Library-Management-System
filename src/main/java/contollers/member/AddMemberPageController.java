package contollers.member;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddMemberPageController {

    AddMemberController addMemberController = new AddMemberController();

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtMemberId;

    @FXML
    private TextField txtNUmber;

    @FXML
    private TextField txtName;

    @FXML
    void btnAddMemberOnAction(ActionEvent event) {
        addMemberController.addMember(txtMemberId.getText(),txtName.getText(),txtAddress.getText(),txtEmail.getText(),txtNUmber.getText());
    }

}
