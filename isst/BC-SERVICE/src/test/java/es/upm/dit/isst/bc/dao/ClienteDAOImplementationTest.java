package es.upm.dit.isst.bc.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import es.upm.dit.isst.bc.model.Cliente;

class ClienteDAOImplementationTest {

	@Test
	final void testCliente() {
	ClienteDAO clientedao = ClienteDAOImplementation.getInstance();
	Cliente cliente = new Cliente();
	cliente.setEmail("marata@gmail.com");
	cliente.setPassword("1234");
	cliente.setLocation("Aranjuez");
	cliente.setClient_name("Marta Moreno");
	cliente.setType(true);
	
	clientedao.create(cliente);
	
	Cliente cliente2 = clientedao.read("marata@gmail.com");
	assertEquals(cliente2.getEmail(), cliente.getEmail());
	assertEquals(cliente2.getClient_name(), "Marta Moreno");
	
	cliente.setLocation("Calle Almansa, Aranjuez");
	clientedao.update(cliente);
	cliente2 = clientedao.read("marata@gmail.com");
	assertNotEquals(cliente2.getLocation(), "Aranjuez");
	
	clientedao.delete(cliente);
	cliente2 = clientedao.read("marata@gmail.com");
	assertNull(cliente2);
	}

}
