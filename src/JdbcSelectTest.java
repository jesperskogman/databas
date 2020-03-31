import java.sql.*;
import java.util.Scanner;

public class JdbcSelectTest {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/soloaventyr?allowPublicKeyRetrieval=TRUE&useSSL=false&serverTimezone=UTC",
                        "jesper", "elev123");

        ) {
            Statement stmt = conn.createStatement();
            int story_id = 1;
            int target_id = 2;
            String strSelect = "select body from story where id = " + story_id;
            System.out.println("This SQL statement is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println("Story body:");
            while (rset.next()) {
                String body = rset.getString("body");
                System.out.println(body);
            }

            while (target_id != 20) {
                String strSelect2 = "select target_id, description fom links where story_id = " + story_id;
                System.out.println("The SQL statment is: " + strSelect2 + "\n");
                ResultSet rset2 = stmt.executeQuery(strSelect2);

                while (rset2.next()) {
                    int target_ids = rset2.getInt("target_id");
                    String description = rset2.getString("description");
                    System.out.println(target_ids + ": " + description);
                }

                Scanner in = new Scanner(System.in);
                target_id = in.nextInt();
                story_id = target_id;

                String strSelect3 = "select body from story id = " + target_id;
                System.out.println("The SQL statment is: " + strSelect3 + "\n");
                ResultSet rset3 = stmt.executeQuery(strSelect3);

                while (rset3.next()) {
                    String body = rset3.getString("body");
                    System.out.println(body);
                }

            }

            conn.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
