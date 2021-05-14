package es.upm.dit.isst.bc.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import es.upm.dit.isst.bc.model.Pedido;

class PedidoDAOImplementationTest {

	@Test
	final void testPedido() {
	PedidoDAO pedidodao = PedidoDAOImplementation.getInstance();
	Pedido pedido = new Pedido();
	pedido.setIdPedido(Integer.parseInt("2"));
	pedido.setIdComercio("mercadona@gmail.com");
	pedido.setIdRepartidor("martadom@gmail.com");
	pedido.setIdCliente("pabletem@gmail.com");
	pedido.setHorario("18/05/2021 12:00:00");
	pedido.setListaProductos("pipas, luces de navidad, pintalabios, rimmel");

	
	pedidodao.create(pedido);
	
	Pedido pedido2 = pedidodao.read(Integer.parseInt("2"));
	assertEquals(pedido2.getIdPedido(), pedido.getIdPedido());
	assertEquals(pedido2.getIdComercio(), "mercadona@gmail.com");
	
	pedido.setHorario("19/05/2021 12:00:00");
	pedidodao.update(pedido);
	pedido2 = pedidodao.read(Integer.parseInt("2"));
	assertNotEquals(pedido2.getHorario(), "18/05/2021 12:00:00");
	
	pedidodao.delete(pedido);
	pedido2 = pedidodao.read(Integer.parseInt("2"));
	assertNull(pedido2);
	}
}
