package es.upm.dit.isst.bc.dao;

import java.util.List;

import es.upm.dit.isst.bc.model.Cliente;

import javax.persistence.Query;

import org.hibernate.Session;

public class ClienteDAOImplementation implements ClienteDAO {

	private static  ClienteDAOImplementation sfs = null;
	
	private ClienteDAOImplementation() {
		
	}
	
	public static ClienteDAOImplementation getInstance() {
		   if( null == sfs ) 
		     sfs = new ClienteDAOImplementation();
		   return sfs;
		  }
	
	@SuppressWarnings("unchecked")
	@Override
	public Cliente create (Cliente cliente) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.save(cliente);
	  session.getTransaction().commit();
	  session.close();
	  return cliente;

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Cliente read (String email) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  Cliente cliente = session.get(Cliente.class, email);
	  session.getTransaction().commit();
	  session.close();
	  return cliente;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void update (Cliente cliente) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.saveOrUpdate(cliente);
	  session.getTransaction().commit();
	  session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void delete (Cliente cliente) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.delete(cliente);
	  session.getTransaction().commit();
	  session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> readAll () {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  List<Cliente> p = session.createQuery("from Cliente").list();
	  session.getTransaction().commit();
	  session.close();
	  return p;
	}
	
	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Override public Cliente login (String email, String password) { Session
	 * session = SessionFactoryService.get().openSession(); Cliente cliente = null;
	 * session.beginTransaction(); Query q = session.
	 * createQuery("select p from Cliente p where p.email = :email and p.password = :password"
	 * ); q.setParameter("email", email); q.setParameter("password", password);
	 * List<Cliente> tfgs = q.getResultList(); if (tfgs.size() > 0) cliente =
	 * (Cliente) (q.getResultList().get(0)); session.getTransaction().commit();
	 * session.close(); return cliente; }
	 */

}
