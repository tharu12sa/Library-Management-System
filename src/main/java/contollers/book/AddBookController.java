package contollers.book;

import contollers.db.DBConnection;

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

    Connection connection = DBConnection.getConnection();

    public void addSBook(int bookId, String category, String bookTitel, int quantity, String author, String Year){
        String Sql = "INSERT INTO books(book_id,book_titel,author,category,published_year,quantity) " +
                "VALUES (?,?,?,?,?,?)";

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
