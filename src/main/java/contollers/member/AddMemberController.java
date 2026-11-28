package contollers.member;

import db.DBConnection;

import java.sql.*;
import java.time.LocalDate;

public class AddMemberController {

    Connection connection = DBConnection.getInstance().getConnection();

    public String generateMemberID(String nic) {
        String NIC = nic.trim();
        String birthYear = NIC.length() == 10 ? "19" + NIC.substring(0, 2) : NIC.substring(0, 4);
        String year = String.valueOf(LocalDate.now().getYear()).substring(2);
        String prefix = birthYear + year;

        String sql ="SELECT member_id FROM members WHERE member_id LIKE ? ORDER BY member_id DESC LIMIT 1";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,prefix + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String lastMemberId = resultSet.getString("book_id");
                if (lastMemberId != null && lastMemberId.length() > prefix.length()) {
                    String lastNumberStr = lastMemberId.substring(prefix.length());
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


    public void addMember(int  member_id, String member_name, String address, String email, String nic, String birthday){
        String sql = "INSERT INTO members(member_id,member_name,address,email,Nic,birthday)" + "VALUES(?,?,?,?,?,?)";
        System.out.println(connection);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,member_id);
            preparedStatement.setString(2,member_name);
            preparedStatement.setString(3,address);
            preparedStatement.setString(4,email);
            preparedStatement.setString(5,nic);
            preparedStatement.setString(6, birthday);



            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
