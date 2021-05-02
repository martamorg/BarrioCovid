package es.upm.dit.isst.bc.model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
public class Pedido implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
	private int idPedido;
	private String idComercio;
	private String idRepartidor;
	private String idCliente;
	private String  horario; 
	private String listaProductos;
	
	
	
	
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}




	public int getIdPedido() {
		return idPedido;
	}




	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}




	public String getIdComercio() {
		return idComercio;
	}




	public void setIdComercio(String idComercio) {
		this.idComercio = idComercio;
	}




	public String getIdRepartidor() {
		return idRepartidor;
	}




	public void setIdRepartidor(String idRepartidor) {
		this.idRepartidor = idRepartidor;
	}




	public String getIdCliente() {
		return idCliente;
	}




	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}




	public String getHorario() {
		return horario;
	}




	public void setHorario(String horario) {
		this.horario = horario;
	}




	public String getListaProductos() {
		return listaProductos;
	}




	public void setListaProductos(String listaProductos) {
		this.listaProductos = listaProductos;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((horario == null) ? 0 : horario.hashCode());
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
		result = prime * result + ((idComercio == null) ? 0 : idComercio.hashCode());
		result = prime * result + idPedido;
		result = prime * result + ((idRepartidor == null) ? 0 : idRepartidor.hashCode());
		result = prime * result + ((listaProductos == null) ? 0 : listaProductos.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (horario == null) {
			if (other.horario != null)
				return false;
		} else if (!horario.equals(other.horario))
			return false;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		if (idComercio == null) {
			if (other.idComercio != null)
				return false;
		} else if (!idComercio.equals(other.idComercio))
			return false;
		if (idPedido != other.idPedido)
			return false;
		if (idRepartidor == null) {
			if (other.idRepartidor != null)
				return false;
		} else if (!idRepartidor.equals(other.idRepartidor))
			return false;
		if (listaProductos == null) {
			if (other.listaProductos != null)
				return false;
		} else if (!listaProductos.equals(other.listaProductos))
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", idComercio=" + idComercio + ", idRepartidor=" + idRepartidor
				+ ", idCliente=" + idCliente + ", horario=" + horario + ", listaProductos=" + listaProductos + "]";
	}

	
	



}

