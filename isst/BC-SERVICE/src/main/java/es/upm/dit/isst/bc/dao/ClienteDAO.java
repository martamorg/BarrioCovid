package es.upm.dit.isst.bc.dao;

import java.util.List;

import es.upm.dit.isst.bc.model.Cliente;



public interface ClienteDAO {
	public Cliente create(Cliente cliente);
	public Cliente read(String email);
	public void update(Cliente cliente);
	public void delete(Cliente cliente);
	public List<Cliente> readAll();
	public Cliente login(String email, String password);

}
