package com.panvdev.apirest_prueba.modelos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String client_name;
	private String balance;
	private String estado;
	
	public Cliente() {
		
	}

	//Metodos getters y setters
	public long getId() {

		return id;
	}

	public void setId(long id) {

		this.id = id;
	}

	public String getClient_name() {

		return client_name;
	}

	public void setClient_name(String client_name) {

		this.client_name = client_name;
	}

	public String getBalance() {

		return balance;
	}

	public void setBalance(String balance) {

		this.balance = balance;
	}

	public String getEstado() {

		return estado;
	}

	public void setEstado(String estado) {

		this.estado = estado;
	}

	public static long getSerialversionuid() {

		return serialVersionUID;
	}
	
}
