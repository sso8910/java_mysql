import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Public {
    public static void main(String[]args){
        // VS code에서 폴더 만들기, class 파일 만들기
        // MySQL 열기 --> mysql - connector J
        // connect to database 클릭
        // connection method, hostname : localhost, port, username, password, default schema(원하는 database 이름) 항목 입력확인
        // Hostname: localhost  port: 3306
        // Username: root
        // Default Schema : world
        // password : tbrs00002b
        // access to 'World' DB
        final String USER = "root";
        final String PASS = "tbrs00002b";
        final String DB_URL = "jdbc:mysql://localhost/world";
        String QUERY = "select ID, Name, Population "+
                        "from city " +
                        "where 1=1 " +
                        "and population >= 9230000";
        try(
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);) {
                        // Extract data from result set
            while (rs.next()) {
                           // Retrieve by column name
                System.out.print("ID: " + rs.getInt("ID"));
                System.out.print(", Name: " + rs.getString("Name"));
                System.out.println(", Population: " + rs.getInt("Population"));  
            }
            } catch (SQLException e) {
            e.printStackTrace();
            }
        // Make new SQL tab for executing query

    }
}
