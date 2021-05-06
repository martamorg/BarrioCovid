package es.upm.dit.isst.bc.dao;

import java.util.List;

import es.upm.dit.isst.bc.model.Comercio;



public interface ComercioDAO {
	public Comercio create(Comercio comercio);
	public Comercio read(String email);
	public void update(Comercio comercio);
	public void delete(Comercio comercio);
	public List<Comercio> readAll();
	public Comercio login(String email, String password);

}
