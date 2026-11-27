package contollers.book;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import scene.SceneManager;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class BookPageController implements Initializable {

    AddBookController addBookController = new AddBookController();

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
    private ComboBox<String> addCategory;

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

    @FXML
    public void btnBookIDGenerateOnAction(ActionEvent actionEvent) {
        String category = addCategory.getValue();

        if (category == null || category.trim().isEmpty()){
            new Alert(Alert.AlertType.WARNING, "Please select category to generate Student ID!").show();
            return;
        }
        try {
            String bookID = addBookController.generateBookID(category);
            addBookID.setText(bookID);
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, "Failed to generate Book ID: " + e.getMessage()).show();
        }
    }

    public void addBookOnAction(ActionEvent actionEvent) {
        String bookID= addBookID.getText();
        String bookTitle = addBookTitle.getText();
        String author = addAuthor.getText();
        String category = addCategory.getValue();
        LocalDate year = addYear.getValue();
        String quantity = addquantity.getText();

        if (bookTitle == null || bookTitle.trim().isEmpty() ||
                author == null || author.trim().isEmpty() ||
                category == null || category.trim().isEmpty() ||
                year == null || quantity == null || quantity.trim().isEmpty()){
            new Alert(Alert.AlertType.WARNING, "Please fill in all required fields!").show();
            return;
        }

        if (bookID == null || bookID.trim().isEmpty()) {
            bookID = addBookController.generateBookID(category);
            addBookID.setText(bookID);
        }

        try {
            boolean isAdded = addBookController.addBook(
                    bookID.trim(),
                    bookTitle.trim(),
                    author.trim(),
                    category.trim(),
                    year.toString(),
                    quantity.trim()
                    );

            if (isAdded) {
                new Alert(Alert.AlertType.INFORMATION, "Book Added Successfully!\nBook ID: " + bookID).show();
                //clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Add Book!").show();
            }
        }catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error: " + e.getMessage()).show();
        }
       //addBookController.addBook(addBookID.getText(),addBookTitle.getText(),addAuthor.getText(),addCategory.getValue(), String.valueOf(addYear.getValue()),addquantity.getText());
    }

    public void loadCategory(){
        ObservableList<String> category = addBookController.getCategory();
        addCategory.setItems(category);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadCategory();

    }


}
