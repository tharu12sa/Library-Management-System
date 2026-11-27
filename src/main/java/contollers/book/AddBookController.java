package contollers.book;


import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AddBookController {
    Connection connection = DBConnection.getInstance().getConnection();

    public boolean addBook(String book_id, String book_titel, String author, String category,
                        String published_year, String quantity) {
        String SQL = "INSERT INTO books(book_id, book_titel, author, category, published_year, quantity) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, book_id);
            preparedStatement.setString(2, book_titel);
            preparedStatement.setString(3, author);
            preparedStatement.setString(4, category);
            preparedStatement.setString(5, published_year);
            preparedStatement.setString(6, quantity);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ObservableList<String> getCategory() {
        ObservableList<String> categoryList = FXCollections.observableArrayList();
        String sql = "SELECT category_name FROM categories ORDER BY category_name ASC";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                categoryList.add(resultSet.getString("category_name"));
            }
        } catch (SQLException e) {
            System.err.println("Could not load categories from DB: " + e.getMessage());
        }

            if (categoryList.isEmpty()) {
                categoryList.addAll("Horror","Fantasy","Science Fiction","Romance","Educational");
            }
        return categoryList;
    }

    public String generateBookID(String category) {
        String mode  = category.trim().substring(0, 1);
        String prefix = mode + "001";

        String sql ="SELECT book_id FROM books WHERE book_id LIKE ? ORDER BY book_id DESC LIMIT 1";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,prefix + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String lastBookId = resultSet.getString("book_id");
                if (lastBookId != null && lastBookId.length() > prefix.length()) {
                    String lastNumberStr = lastBookId.substring(prefix.length());
                    try {
                        int nextNumber = Integer.parseInt(lastNumberStr) + 1;
                        return prefix + String.format("%03d", nextNumber);
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
            return prefix + "001";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
