package com.panvdev.apirest_prueba.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.panvdev.apirest_prueba.modelos.Cliente;

@Repository
//La interfaz ClienteRepositorio se utilizará para interactuar con la entidad UserModels.
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
