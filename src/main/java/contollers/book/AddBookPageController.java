package contollers.book;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddBookPageController implements Initializable {

    AddBookController addBookController= new AddBookController();

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBookTitel;

    @FXML
    private ComboBox<String> cmbCategory;

    @FXML
    private TextField txtQuantity;

    @FXML
    private DatePicker txtYear;

    @FXML
    void btnAddBookOnAction(ActionEvent event) {
        addBookController.addSBook(Integer.parseInt(txtBookId.getText()),cmbCategory.getValue(),txtBookTitel.getText(),
                Integer.parseInt(txtQuantity.getText()),
                txtAuthor.getText(), String.valueOf(txtYear.getValue()));
        Stage stage = (Stage) txtBookId.getScene().getWindow();
        stage.close();

    }

//    ObservableList<String> category= FXCollections.observableArrayList("Horror","Fantasy","Science Fiction","Romance","Educational");
//    public void setCmbCategory(){
//        cmbCategory.setItems(category);
//    }

public void loadCategory(){
        ObservableList<String> category = addBookController.getCategoty();
        cmbCategory.setItems(category);
}
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadCategory();
    }
}
