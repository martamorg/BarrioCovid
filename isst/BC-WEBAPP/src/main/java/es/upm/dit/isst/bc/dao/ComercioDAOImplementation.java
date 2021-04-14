package es.upm.dit.isst.bc.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.bc.model.Comercio;

public class ComercioDAOImplementation implements ComercioDAO {

	private static  ComercioDAOImplementation sfs = null;
	
	private ComercioDAOImplementation() {
		
	}
	
	public static ComercioDAOImplementation getInstance() {
		   if( null == sfs ) 
		     sfs = new ComercioDAOImplementation();
		   return sfs;
		  }
	
	@SuppressWarnings("unchecked")
	@Override
	public Comercio create (Comercio comercio) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.save(comercio);
	  session.getTransaction().commit();
	  session.close();
	  return comercio;

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Comercio read (String email) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  Comercio comercio = session.get(Comercio.class, email);
	  session.getTransaction().commit();
	  session.close();
	  return comercio;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void update (Comercio comercio) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.saveOrUpdate(comercio);
	  session.getTransaction().commit();
	  session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void delete (Comercio comercio) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.delete(comercio);
	  session.getTransaction().commit();
	  session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Comercio> readAll () {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  List<Comercio> p = session.createQuery("from Comercio").list();
	  session.getTransaction().commit();
	  session.close();
	  return p;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Comercio login (String email, String password) {
	  Session session = SessionFactoryService.get().openSession();
	  Comercio comercio = null;
	  session.beginTransaction();
	  Query q = session.createQuery("select p from Comercio p where p.email = :email and p.password = :password");
	  q.setParameter("email", email);
	  q.setParameter("password", password);
	  List<Comercio> tfgs = q.getResultList();
	  if (tfgs.size() > 0)
	  	comercio = (Comercio) (q.getResultList().get(0));
	  session.getTransaction().commit();
	  session.close();
	  return comercio;
	}

}
