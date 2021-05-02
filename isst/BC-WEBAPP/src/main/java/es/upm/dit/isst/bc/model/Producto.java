package es.upm.dit.isst.bc.model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;



public class Producto implements Serializable{

    private static final long serialVersionUID = 1L;

    
	private String nombre;
	private float precio;
	private int stock;
	private String idComercio;
	
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public String getIdComercio() {
		return idComercio;
	}


	public void setIdComercio(String idComercio) {
		this.idComercio = idComercio;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idComercio == null) ? 0 : idComercio.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + Float.floatToIntBits(precio);
		result = prime * result + stock;
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
		Producto other = (Producto) obj;
		if (idComercio == null) {
			if (other.idComercio != null)
				return false;
		} else if (!idComercio.equals(other.idComercio))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Float.floatToIntBits(precio) != Float.floatToIntBits(other.precio))
			return false;
		if (stock != other.stock)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + ", idComercio=" + idComercio
				+ "]";
	}
	
	
	
}
