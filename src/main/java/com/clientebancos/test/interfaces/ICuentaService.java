package com.clientebancos.test.interfaces;

import java.util.List;
import java.util.Optional;

import com.clientebancos.test.entity.Cuenta;

public interface ICuentaService {

	public void crearCuenta(Long idCliente) throws Exception;
	
	public List<Cuenta> cuentasPorCliente(Long idCliente) throws Exception;
	
	public Optional<Cuenta> consultarCuenta(Long idCuenta) throws Exception;
	
}
