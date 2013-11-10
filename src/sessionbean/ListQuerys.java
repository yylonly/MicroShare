package sessionbean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import model.User;
import result.ListResult;

/**
 * Session Bean implementation class ListQuerys
 */
@Stateless
@LocalBean
public class ListQuerys {

	@PersistenceUnit(unitName = "EHR")
	EntityManagerFactory emf;
	
	
    /**
     * Default constructor. 
     */
    public ListQuerys() {
        // TODO Auto-generated constructor stub
    }
    public List<ListResult> listAll(User user)
    {	
    	Query query = emf.createEntityManager().createQuery("select new result.ListResult(l.id, l.description, l.sqlquery, url.url) " +
    				"from Querylist l, Urlforwebservice url,  Querytorole qtor, Role r, User u " +
    				"where l.urlforwebservice1 = url and qtor.querylist = l and qtor.role = r and u.roleBean = r and " +
    				"u.username = :name"); 
    	query.setParameter("name", user.getUsername());
    	List<ListResult> result = query.getResultList();
    	return result;
    }
}
