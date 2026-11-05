package contollers.login;

import contollers.db.DBConnection;

import java.sql.*;

public class LoginContoller {
//    public static boolean cheakUserNameAndPassword(String UserName, String Password) {
//        if (UserName.equals("saman") && Password.equals("saman12")){
//            return true;
//        }
//    return false;
   // }
//------------------------------------------------------------------------------


//    Connection connection;
//
//    {
//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system_v1"
//                    ,"root","Tharu12");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    Connection connection = DBConnection.getConnection();

    public void testConeection(){
        System.out.println(connection);
    }

    public boolean cheakUserNameAndPassword(String userName, String password) {
        String sql = "Select * from user";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String  dbUserName =resultSet.getString("username");
                String dbPassword =resultSet.getString("password");

                if (userName.equals(dbUserName) && password.equals(dbPassword)){
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
