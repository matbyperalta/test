package com.clientebancos.test.interfaces;

import java.util.List;

import com.clientebancos.test.entity.Cuenta;

public interface ICuentaService {

	public void crearCuenta(Long idCliente) throws Exception;
	
	public List<Cuenta> cuentasPorCliente(Long idCliente) throws Exception;
	
}
