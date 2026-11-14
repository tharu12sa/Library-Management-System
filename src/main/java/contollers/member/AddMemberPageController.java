package contollers.member;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddMemberPageController {


    AddMemberController addMemberController = new AddMemberController();

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtMemberId;

    @FXML
    private DatePicker txtBirthday;

    @FXML
    private TextField txtNIC;


    @FXML
    private TextField txtName;

    @FXML
    void btnAddMemberOnAction(ActionEvent event) {
        addMemberController.addMember(Integer.parseInt(txtMemberId.getText()),txtName.getText()
                ,txtAddress.getText(),txtEmail.getText(),txtNIC.getText(), String.valueOf(txtBirthday.getValue()));
        Stage stage = (Stage) txtMemberId.getScene().getWindow();
        stage.close();
    }

}
