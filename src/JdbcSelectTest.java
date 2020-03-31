import java.sql.*;

public class JdbcSelectTest {
    public static void main(String[] args){
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/soloaventyr?allowPublicKeyRetrieval=TRUE&useSSL=false&serverTimezone=UTC",
                        "jesper", "elev123");

        ){
            Statement stmt = conn.createStatement();
            int story_id = 1;
            int target_id = 2;
            String strSelect = "select body from story where id = " + story_id;
            System.out.println("This SQL statement is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println("Story body:");
            while(rset.next()){
                String body = rset.getString("body");
                System.out.println(body);
            }

            while (target_id !=20) {
                String strSelect2 = "select target_id, description fom links where story_id = " + story_id;

        }
    }
}
