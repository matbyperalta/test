package com.clientebancos.test.interfaces;

import com.clientebancos.test.dto.TransaccionDTO;

public interface IMovimientoService {

	public void consignar(TransaccionDTO transaccionDTO) throws Exception;
	
	public void retirar(TransaccionDTO transaccionDTO) throws Exception;
	
}
