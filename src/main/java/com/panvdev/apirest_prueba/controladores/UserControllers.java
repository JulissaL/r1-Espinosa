package com.panvdev.apirest_prueba.controladores;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panvdev.apirest_prueba.modelos.Cliente;
import com.panvdev.apirest_prueba.servicios.ClienteServicioImpl;

@RestController
@RequestMapping("/api/v1")
public class UserControllers {
	
	@Autowired
	ClienteServicioImpl clienteservicio;
	
	
	@GetMapping("accounts")
	//se muestra la lista de los clientes que estan en la base de datos
	public List<Cliente> obtenerClientes(){

		return clienteservicio.consultar();
	}
	
	
	@PostMapping("accounts")
	//crea un nuevo usuario en la base de datos
	public ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente cliente){
		Cliente nuevo_cliente = clienteservicio.crear(cliente);
		return new ResponseEntity<>(nuevo_cliente, HttpStatus.CREATED);
	}
	
	@GetMapping("accounts/{id}")
	//seleciona solo un usuario en la base de datos
	public ResponseEntity<Cliente> obtenerClienteId(@PathVariable long id){
		Cliente clientePorId = clienteservicio.obtenerPorId(id);
		return ResponseEntity.ok(clientePorId);
	}

	@PutMapping("accounts/{id}")
	//modifica un usuario que este en la base de datos
	public ResponseEntity<Cliente> modificarId(@PathVariable long id, @RequestBody Cliente cliente) {
		Cliente clienteModificado = clienteservicio.modificarId(id, cliente);

		if (clienteModificado != null) {
			return ResponseEntity.ok(clienteModificado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("accounts/{id}")
	//se elimina el cliente que se desea eliminar
	public ResponseEntity<HashMap<String,Boolean>> eliminarCliente(@PathVariable long id){
		this.clienteservicio.eliminar(id);
		
		HashMap<String, Boolean> estadoClienteEliminado = new HashMap<>();
		estadoClienteEliminado.put("eliminado", true);
		return ResponseEntity.ok(estadoClienteEliminado);
	}

	
	
}
