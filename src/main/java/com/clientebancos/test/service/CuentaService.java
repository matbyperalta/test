package com.clientebancos.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.clientebancos.test.entity.Cliente;
import com.clientebancos.test.entity.Cuenta;
import com.clientebancos.test.interfaces.IClienteDao;
import com.clientebancos.test.interfaces.ICuentaDao;
import com.clientebancos.test.interfaces.ICuentaService;

@Service
public class CuentaService implements ICuentaService {

	@Autowired
	private ICuentaDao cuentaDao;
	@Autowired
	private IClienteDao clienteDao;
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void crearCuenta(Long idCliente) throws Exception {
		Optional<Cliente> optional = null;
		try {
			optional = clienteDao.findById(idCliente);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error");
		}
		if (optional.isPresent()) {
			Cuenta cuenta = new Cuenta();
			cuenta.setCliente(optional.get().getId());
			cuenta.setSaldo(0d);
			try {
				cuentaDao.save(cuenta);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Error");
			}
		} else {
			throw new Exception("Cliente no existe");
		}

	}

	@Override
	public List<Cuenta> cuentasPorCliente(Long idCliente) throws Exception {
		List<Cuenta> cuentas = null;
		try {
			cuentas = cuentaDao.cuentasPorCliente(idCliente);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error");
		}

		if (cuentas != null && !cuentas.isEmpty()) {
			return cuentas;
		} else {
			throw new Exception("No hay cuentas");
		}

	}

}
