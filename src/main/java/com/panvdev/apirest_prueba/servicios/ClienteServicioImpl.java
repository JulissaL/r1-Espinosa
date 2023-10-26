package com.panvdev.apirest_prueba.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panvdev.apirest_prueba.modelos.Cliente;
import com.panvdev.apirest_prueba.repositorios.ClienteRepositorio;

@Service
public class ClienteServicioImpl implements IClienteServicio{
	
	@Autowired
	ClienteRepositorio clienterepositorio;

	@Override
	public List<Cliente> consultar() {

		return clienterepositorio.findAll();
	}

	@Override
	public Cliente crear(Cliente cliente) {

		return clienterepositorio.save(cliente);
	}

	@Override
	public Cliente obtenerPorId(long id) {

		return clienterepositorio.findById(id).orElse(null);
	}

	@Override
	public Cliente modificarId(long id, Cliente cliente) {
		// Verifica si el cliente con el ID proporcionado existe
		Cliente clienteExistente = clienterepositorio.findById(id).orElse(null);

		if (clienteExistente == null) {
			return null; // Puedes manejar el caso en el que el cliente no exista
		}

		// Actualiza los datos del cliente existente con los nuevos datos
		clienteExistente.setClient_name(cliente.getClient_name());
		clienteExistente.setBalance(cliente.getBalance());
		clienteExistente.setEstado(cliente.getEstado());
		// Agrega más campos que necesites actualizar

		// Guarda los cambios en la base de datos
		return clienterepositorio.save(clienteExistente);
	}

	@Override
	public void eliminar(long id) {
		clienterepositorio.deleteById(id);
		
	}

}
