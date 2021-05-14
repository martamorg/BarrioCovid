package es.upm.dit.isst.bc.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import es.upm.dit.isst.bc.model.Producto;

class ProductoDAOImplementationTest {

	@Test
	final void testProducto() {
	ProductoDAO productodao = ProductoDAOImplementation.getInstance();
	Producto producto = new Producto();
	producto.setNombre("pilas");
	producto.setPrecio(Float.parseFloat("3.5"));
	producto.setStock(Integer.parseInt("10"));
	producto.setIdComercio("mercadona@gmail.com");

	
	productodao.create(producto);
	
	Producto producto2 = productodao.read("pilas");
	assertEquals(producto2.getNombre(), producto.getNombre());
	assertEquals(producto2.getPrecio(), Float.parseFloat("3.5"));
	
	producto.setStock(Integer.parseInt("5"));
	productodao.update(producto);
	producto2 = productodao.read("pilas");
	assertNotEquals(producto2.getStock(), Integer.parseInt("10"));
	
	productodao.delete(producto);
	producto2 = productodao.read("pilas");
	assertNull(producto2);
	}


}
