package contollers.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

    public void addMember(String text, String txtNameText, String txtAddressText, String txtEmailText, String txtNUmberText){}
}
