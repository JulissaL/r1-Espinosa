package com.panvdev.apirest_prueba.servicios;

import java.util.List;

import com.panvdev.apirest_prueba.modelos.Cliente;

public interface IClienteServicio{

	public List<Cliente> consultar();
	
	public Cliente crear(Cliente cliente);
	
	public Cliente obtenerPorId(long id);

	public Cliente modificarId(long id, Cliente cliente);
	
	public void eliminar(long id);


}
