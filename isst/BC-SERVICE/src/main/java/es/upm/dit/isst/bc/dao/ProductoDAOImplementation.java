package es.upm.dit.isst.bc.dao;

import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.bc.model.Producto;

import javax.persistence.Query;

import org.hibernate.Session;

public class ProductoDAOImplementation implements ProductoDAO {
		private static  ProductoDAOImplementation sfs = null;
			
			private ProductoDAOImplementation() {
				
			}
			
			public static ProductoDAOImplementation getInstance() {
				   if( null == sfs ) 
				     sfs = new ProductoDAOImplementation();
				   return sfs;
				  }
			
			@SuppressWarnings("unchecked")
			@Override
			public Producto create (Producto producto) {
			  Session session = SessionFactoryService.get().openSession();
			  session.beginTransaction();
			  session.save(producto);
			  session.getTransaction().commit();
			  session.close();
			  return producto;
		
			}
			
			@SuppressWarnings("unchecked")
			@Override
			public Producto read (String nombre) {
			  Session session = SessionFactoryService.get().openSession();
			  session.beginTransaction();
			  Producto producto = session.get(Producto.class, nombre);
			  session.getTransaction().commit();
			  session.close();
			  return producto;
			}
			
			@SuppressWarnings("unchecked")
			@Override
			public void update (Producto producto) {
			  Session session = SessionFactoryService.get().openSession();
			  session.beginTransaction();
			  session.saveOrUpdate(producto);
			  session.getTransaction().commit();
			  session.close();
			}
			
			@SuppressWarnings("unchecked")
			@Override
			public void delete (Producto producto) {
			  Session session = SessionFactoryService.get().openSession();
			  session.beginTransaction();
			  session.delete(producto);
			  session.getTransaction().commit();
			  session.close();
			}
			
			@SuppressWarnings("unchecked")
			@Override
			public List<Producto> readAll () {
			  Session session = SessionFactoryService.get().openSession();
			  session.beginTransaction();
			  List<Producto> p = session.createQuery("from Producto").list();
			  session.getTransaction().commit();
			  session.close();
			  return p;
			}
}
