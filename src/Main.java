import java.sql.*;
import java.util.Properties;
public class Main {
    public static void main(String[] args) {

          System.out.println("Hello world!");
//        String jdbcURl = "jdbc:postgresql://localhost:5432/employees";
//
//        String user = "postgres";
//        String pass = "1234";
//
//        Connection conn2 = null;
//        Statement stmt2 = null;
//        try {
//            conn2 = DriverManager.getConnection(jdbcURl, user, pass);
//            if (conn2 != null) {
//                System.out.println("Connected to database #2");
//            }
//            stmt2 = conn2.createStatement();
//            ResultSet rs = stmt2.executeQuery( "SELECT * FROM empsal;" );
//            while ( rs.next() ) {
//                int id = rs.getInt("id");
//                String  name = rs.getString("name");
//                int salary  = rs.getInt("salary");
//                System.out.println( "ID = " + id );
//                System.out.println( "NAME = " + name );
//                System.out.println( "SALARY = " + salary );
//                System.out.println();
//            }
//            rs.close();
//            stmt2.close();
//            conn2.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        //String ref = "jdbc:postgresql://{public dns or ip}:{port}/{database name}","{username}","{password}";
        String url = "jdbc:postgresql://";
        String host = "sanjay.cqlap8amzsmz.ap-northeast-1.rds.amazonaws.com";
        String username = "tillde";
        String port = "5432";
        String password = "xerneas12";
        String database = "sanjdb";

        String aws = "jdbc:postgresql://"+host+":"+port+"/"+database+"?user="+username+"&password="+password;
        System.out.println(aws);
        Connection aws_con = null;
        Statement stmt2 = null;
        try {
            aws_con = DriverManager.getConnection(aws);
            if (aws_con != null) {
                System.out.println("Connected to the aws database");
            }
            stmt2 = aws_con.createStatement();
            ResultSet rs = stmt2.executeQuery( "SELECT * FROM \"WalletInfo\";" );
            while ( rs.next() ) {
                int id = rs.getInt("ID");
                int balance  = rs.getInt("Balance");
                String  rollno = rs.getString("RollNo");

                System.out.println( "ID = " + id );
                System.out.println( "Rollno = " + rollno );
                System.out.println( "Balance = " + balance );
                System.out.println();
            }
            rs.close();
            stmt2.close();
            aws_con.close();
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        System.out.println("Operation done successfully");





    }
}