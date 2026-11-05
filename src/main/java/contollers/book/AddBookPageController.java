package contollers.book;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddBookPageController {

    AddBookController addBookController= new AddBookController();

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBookTitel;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtQuantity;

    @FXML
    private DatePicker txtYear;

    @FXML
    void btnAddBookOnAction(ActionEvent event) {
        addBookController.addSBook(Integer.parseInt(txtBookId.getText()),txtCategory.getText(),txtBookTitel.getText(),
                Integer.parseInt(txtQuantity.getText()),
                txtAuthor.getText(), String.valueOf(txtYear.getValue()));
        Stage stage = (Stage) txtBookId.getScene().getWindow();
        stage.close();

    }

}
