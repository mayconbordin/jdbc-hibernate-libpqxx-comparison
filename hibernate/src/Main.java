
import dao.CityDAO;
import java.util.List;
import model.City;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author maycon
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();

        // Get current time
        long startTime = System.currentTimeMillis();
        
        CityDAO dao = new CityDAO(session);
        List<City> list = dao.list();

        /*for ( City city : list ) {
            System.out.println( city.getId() + " - " + city.getCity() + " - " + city.getState() );
        }*/

        // Get elapsed time in seconds
        float elapsedTime = (System.currentTimeMillis()-startTime)/1000F;

        //Print the elapsed time
        System.out.println(elapsedTime);
    }
}
