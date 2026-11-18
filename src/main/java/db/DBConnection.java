package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection connection;
    public static DBConnection instance;

//    public static Connection getConnection(){
//        Connection connection;
//
//        {
//            try {
//                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system_v1"
//                        ,"root","Tharu12");
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return connection;
//    }

    //---------------------------------------------------------

    private DBConnection(){
        try {
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system_v1"
                    ,"root",
                    "Tharu12");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static DBConnection getInstance(){
        if(instance == null){
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }
}
