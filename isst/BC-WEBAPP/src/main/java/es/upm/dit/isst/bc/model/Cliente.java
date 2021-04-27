package es.upm.dit.isst.bc.model;

import java.io.Serializable;
import java.util.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;



public class Cliente implements Serializable{

    private static final long serialVersionUID = 1L;

    
	private String email;
	private String password;
	private String location;
	private String client_name;
	private boolean type;
	
	
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getClient_name() {
		return client_name;
	}



	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}



	public boolean isType() {
		return type;
	}



	public void setType(boolean type) {
		this.type = type;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client_name == null) ? 0 : client_name.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + (type ? 1231 : 1237);
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
		Cliente other = (Cliente) obj;
		if (client_name == null) {
			if (other.client_name != null)
				return false;
		} else if (!client_name.equals(other.client_name))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (type != other.type)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Cliente [email=" + email + ", password=" + password + ", location=" + location + ", client_name="
				+ client_name + ", type=" + type + "]";
	}



	


}