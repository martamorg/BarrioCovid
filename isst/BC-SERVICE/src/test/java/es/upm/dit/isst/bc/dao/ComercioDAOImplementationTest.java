package es.upm.dit.isst.bc.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import es.upm.dit.isst.bc.model.Comercio;

class ComercioDAOImplementationTest {

	@Test
	final void testComercio() {
	ComercioDAO comerciodao = ComercioDAOImplementation.getInstance();
	Comercio comercio = new Comercio();
	comercio.setEmail("carrefour@gmail.com");
	comercio.setPassword("1234");
	comercio.setShop_name("Carrefour");
	comercio.setPhone("912345678");
	comercio.setLocation("Avenida de Bruselas");

	
	comerciodao.create(comercio);
	
	Comercio comercio2 = comerciodao.read("carrefour@gmail.com");
	assertEquals(comercio2.getEmail(), comercio.getEmail());
	assertEquals(comercio2.getShop_name(), "Carrefour");
	
	comercio.setLocation("Avenida de Bonn");
	comerciodao.update(comercio);
	comercio2 = comerciodao.read("carrefour@gmail.com");
	assertNotEquals(comercio2.getLocation(), "Avenida de Bruselas");
	
	comerciodao.delete(comercio);
	comercio2 = comerciodao.read("carrefour@gmail.com");
	assertNull(comercio2);
	}
}
