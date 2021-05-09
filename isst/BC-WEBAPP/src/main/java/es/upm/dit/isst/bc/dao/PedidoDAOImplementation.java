package es.upm.dit.isst.bc.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.bc.model.Pedido;

public class PedidoDAOImplementation implements PedidoDAO {

	private static  PedidoDAOImplementation sfs = null;
	
	private PedidoDAOImplementation() {
		
	}
	
	public static PedidoDAOImplementation getInstance() {
		   if( null == sfs ) 
		     sfs = new PedidoDAOImplementation();
		   return sfs;
		  }
	
	@SuppressWarnings("unchecked")
	@Override
	public Pedido create (Pedido pedido) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.save(pedido);
	  session.getTransaction().commit();
	  session.close();
	  return pedido;

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Pedido read (int idPedido) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  Pedido pedido = session.get(Pedido.class, idPedido);
	  session.getTransaction().commit();
	  session.close();
	  return pedido;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void update (Pedido pedido) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.saveOrUpdate(pedido);
	  session.getTransaction().commit();
	  session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void delete (Pedido pedido) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.delete(pedido);
	  session.getTransaction().commit();
	  session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> readAll () {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  List<Pedido> p = session.createQuery("from Pedido").list();
	  session.getTransaction().commit();
	  session.close();
	  return p;
	}
	
	

}
