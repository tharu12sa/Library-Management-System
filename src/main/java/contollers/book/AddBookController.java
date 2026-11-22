package contollers.book;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class AddBookController {
//    Connection connection;
//
//    {
//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system_v1"
//                    ,"root",
//                    "Tharu12");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }


    Connection connection = DBConnection.getInstance().getConnection();

    public ObservableList<String> getCategoty(){
        ObservableList<String> categoryList = FXCollections.observableArrayList();
        String sql = "SELECT category_id FROM categories ORDER BY category_id ASC";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                categoryList.add(resultSet.getString("category_name"));
            }
        } catch (SQLException e) {
            System.err.println("Could not load batches from DB: " + e.getMessage());
        }
        if (categoryList.isEmpty()){
            categoryList.addAll("Horror","Fantasy","Science Fiction","Romance","Educational");
        }
        return categoryList;
    }

    public void addSBook(int bookId, String category, String bookTitel, int quantity, String author, String Year){
        String Sql = "INSERT INTO books(book_id,book_titel,author,category,published_year,quantity) " +
                "VALUES (?,?,?,?,?,?)";
        System.out.println(connection);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);

            preparedStatement.setInt(1,bookId);
            preparedStatement.setString(2,bookTitel);
            preparedStatement.setString(3,author);
            preparedStatement.setString(4,category);
            preparedStatement.setDate(5, Date.valueOf(Year));
            preparedStatement.setInt(6,quantity);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
