package com.clientebancos.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.clientebancos.test.entity.Cliente;
import com.clientebancos.test.interfaces.IClienteDao;
import com.clientebancos.test.interfaces.IClienteService;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;

	@Override
	public void crearCliente(Cliente cliente) throws Exception {

		try {
			clienteDao.save(cliente);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error");
		}

	}

	@Override
	public void actualizarCliente(Cliente clienteIn, Long id) throws Exception {
		Optional<Cliente> optional = null;
		try {
			optional = clienteDao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error");
		}
		if (optional.isPresent()) {
			try {
				optional.map(cliente -> {
					cliente.setNombres(clienteIn.getNombres().toLowerCase());
					cliente.setApellidos(clienteIn.getApellidos().toLowerCase());
					cliente.setDireccion(clienteIn.getDireccion());
					cliente.setTelefono(clienteIn.getTelefono());
					return clienteDao.save(cliente);
				});
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Error");
			}
		} else {
			throw new Exception("Cliente no existe");
		}

	}

	@Override
	public void eliminarCliente(Long id) throws Exception {
		try {
			clienteDao.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new Exception("Cliente no existe");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error");
		}

	}

	@Override
	public List<Cliente> clientes() throws Exception {
		try {
			return clienteDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error");
		}
	}

	@Override
	public Optional<Cliente> cliente(Long id) throws Exception {
		try {
			return clienteDao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error");
		}
	}

	@Override
	public List<Cliente> buscar(String nombres) throws Exception {
		try {
			return clienteDao.findByNombreContaining(nombres.toLowerCase());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error");
		}
	}

}
