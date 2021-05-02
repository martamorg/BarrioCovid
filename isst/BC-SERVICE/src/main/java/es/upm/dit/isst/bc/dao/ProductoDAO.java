package es.upm.dit.isst.bc.dao;

import java.util.List;

import es.upm.dit.isst.bc.model.Producto;



public interface ProductoDAO {
	public Producto create(Producto producto);
	public Producto read(String nombre);
	public void update(Producto producto);
	public void delete(Producto producto);
	public List<Producto> readAll();

}
