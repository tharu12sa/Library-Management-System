package contollers.member;

import java.sql.*;

public class AddMemberController {
   Connection connection;

    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system_v1"
                    ,"root","Tharu12");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addMember(int  member_id, String member_name, String address, String email, String nic, String birthday){
        String sql = "INSERT INTO members(member_id,member_name,address,email,Nic,birthday)" + "VALUES(?,?,?,?,?,?)";

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
