import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.Query;

public class MiniProjectConnectMysql {
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
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            //Insert
            //int id = 323214; 
            QUERY = "insert into city(ID, Name, CountryCode, District, Population) " +
                    "values (98765, 'Name',  'AFG', 'Maharashtra', 500) ";
            int val = stmt.executeUpdate(QUERY);
            //Selcet
            QUERY = "select ID, Name, CountryCode, District, Population "+
                    "from city "+
                    "where name = 'Name' ";
            ResultSet rs = stmt.executeQuery(QUERY);
            //result grid, action output 확인

            //Update
            QUERY = "update city " +
                    "set Population = 2000 " +
                    "where Name='Name' " ; 
            val = stmt.executeUpdate(QUERY);


            //Select
            System.out.println();
            
            //Delete
            QUERY = "delete from city "+
                    "where name='Name' " ;
            val = stmt.executeUpdate(QUERY);
            
            //Select
            System.out.println();

            //새로운 Query생성, selsect 명령문 입력 후 test 해보기
           // ResultSet rs = stmt.executeQuery(QUERY); {
                        // Extract data from result set
            while (rs.next()) {
                           // Retrieve by column name
                System.out.print("ID: " + rs.getInt("ID"));
                System.out.print(", Name: " + rs.getString("Name"));
                System.out.println(", Population: " + rs.getInt("Population"));  
            }
        }catch (SQLException e) {
            e.printStackTrace();
            }
        // Make new SQL tab for executing query

    }
}

