package com.clientebancos.test.interfaces;

import java.util.List;
import java.util.Optional;

import com.clientebancos.test.entity.Cliente;

public interface IClienteService {
	
	public void crearCliente(Cliente cliente) throws Exception;
	
	public void actualizarCliente(Cliente cliente, Long id) throws Exception;
	
	public void eliminarCliente(Long id) throws Exception;
	
	public List<Cliente> clientes() throws Exception;
	
	public Optional<Cliente>  cliente(Long id) throws Exception;
	
	public List<Cliente> buscar(String nombres) throws Exception;

}
