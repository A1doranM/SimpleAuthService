package mainPack;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("DBService")
@Transactional
public class DBService {

	@Autowired
	private SessionFactory sessionFactory;

	public void create(Breeder breeder) {
	 	Session session = sessionFactory.getCurrentSession();
    	session.save(breeder);
	}
	
	@SuppressWarnings("unchecked")
	public List<Breeder> readAll() {
	  	Session session = sessionFactory.getCurrentSession();
	  	Criteria criteria = session.createCriteria(Breeder.class);
	  	return (List<Breeder>) criteria.list();
	}

	public Breeder read( Long id ) {
	  	Session session = sessionFactory.getCurrentSession();
	  	return (Breeder) session.get(Breeder.class, id);
	}


	public void update(Breeder person) {
	  Session session = sessionFactory.getCurrentSession();
	  Breeder breeder = (Breeder) session.get(Breeder.class, person.getId());

	  breeder.setName(breeder.getName());
	  breeder.setAnimalType(breeder.getAnimalType());
	
	  session.save(breeder);
	 }
	
	public void delete(Integer id) {
	  Session session = sessionFactory.getCurrentSession();
	  Breeder breeder = (Breeder) session.get(Breeder.class, id);
	  session.delete(breeder);
	}
}
