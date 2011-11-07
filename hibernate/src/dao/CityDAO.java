package dao;

import java.util.List;
import model.City;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author maycon
 */
public class CityDAO {
    private Session session;
    
    public CityDAO(Session session) {
        this.session = session;
    }
    
    public List<City> list() throws HibernateException {
        try {
            Criteria select = session.createCriteria( City.class );
            return select.list();
        } catch (HibernateException e) {
            throw e;
        }
    }
}
