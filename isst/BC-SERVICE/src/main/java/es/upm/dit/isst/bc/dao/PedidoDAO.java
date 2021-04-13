package es.upm.dit.isst.bc.dao;

import java.util.List;

import es.upm.dit.isst.bc.model.Pedido;



public interface PedidoDAO {
	public Pedido create(Pedido pedido);
	public Pedido read(String idPedido);
	public void update(Pedido pedido);
	public void delete(Pedido pedido);
	public List<Pedido> readAll();
	

}