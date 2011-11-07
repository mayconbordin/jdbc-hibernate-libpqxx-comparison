import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class PostgreSQLTest {
    public static void main(String[] args) {
        // Get current time
        long startTime = System.currentTimeMillis();
        
        try {
            //Get PostgreSQL driver
            Class.forName("org.postgresql.Driver");

            //Make a new connection
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/teste","postgres", "servidor");

            //Make the statement to run queries
            Statement s = c.createStatement();

            //Execute the query and receive the result
            ResultSet rs = s.executeQuery("SELECT id, city, state FROM cities");

            //Print the result set
            /*while (rs.next()) {
                System.out.println( rs.getInt("id") + " - " + rs.getString("city") + " - " + rs.getString("state") );
            }*/
        } catch (ClassNotFoundException ex) {
            System.out.println("ERRO: " + ex.getMessage());
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("ERRO: " + ex.getMessage());
            ex.printStackTrace();
        }

        // Get elapsed time in seconds
        float elapsedTime = (System.currentTimeMillis()-startTime)/1000F;

        //Print the elapsed time
        System.out.println(elapsedTime);
    }
}
