package es.upm.dit.isst.bc.model;

import java.io.Serializable;
import java.util.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


public class Comercio implements Serializable{

    private static final long serialVersionUID = 1L;

	private String email;
	private String password;
	private String shop_name;
	private String phone;
	private String location;
	
	
	
	public Comercio() {
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



	public String getShop_name() {
		return shop_name;
	}



	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((shop_name == null) ? 0 : shop_name.hashCode());
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
		Comercio other = (Comercio) obj;
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
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (shop_name == null) {
			if (other.shop_name != null)
				return false;
		} else if (!shop_name.equals(other.shop_name))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Comercio [email=" + email + ", password=" + password + ", shop_name=" + shop_name + ", phone=" + phone
				+ ", location=" + location + "]";
	}



	




}

