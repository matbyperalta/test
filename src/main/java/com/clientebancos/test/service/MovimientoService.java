package com.clientebancos.test.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clientebancos.test.common.Constantes;
import com.clientebancos.test.dto.TransaccionDTO;
import com.clientebancos.test.entity.Cuenta;
import com.clientebancos.test.entity.Movimiento;
import com.clientebancos.test.interfaces.ICuentaDao;
import com.clientebancos.test.interfaces.IMovimientoDao;
import com.clientebancos.test.interfaces.IMovimientoService;

@Service
public class MovimientoService implements IMovimientoService {

	@Autowired
	private IMovimientoDao movimientoDao;
	@Autowired
	private ICuentaDao cuentaDao;

	@Override
	@Transactional(rollbackFor = {Exception.class})
	public void consignar(TransaccionDTO transaccionDTO) throws Exception{

		Optional<Cuenta> optional = null;
		try {
			optional = cuentaDao.findById(transaccionDTO.getCuenta());
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error");
		}
		
		if (optional.isPresent()) {
			Movimiento movimiento = new Movimiento();
			movimiento.setFecha(new Date());
			movimiento.setTipo(Constantes.CREDITO);
			movimiento.setValor(transaccionDTO.getValor());
			movimiento.setCuenta(transaccionDTO.getCuenta());
			
			Cuenta cuenta = optional.get();
			cuenta.setSaldo(cuenta.getSaldo()+transaccionDTO.getValor());
			
			try {
				movimientoDao.save(movimiento);
				cuentaDao.save(cuenta);
			}catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Error");
			}
		}else {
			throw new Exception("Cuenta no existe");
		}

	}

	@Override
	@Transactional(rollbackFor = {Exception.class})
	public void retirar(TransaccionDTO transaccionDTO) throws Exception{
		Optional<Cuenta> optional = null;
		Cuenta cuenta = null;
		try {
			optional = cuentaDao.findById(transaccionDTO.getCuenta());
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error");
		}
		if (optional.isPresent()) {
			cuenta = optional.get();
			Movimiento movimiento = new Movimiento();
			movimiento.setFecha(new Date());
			movimiento.setTipo(Constantes.DEBITO);
			movimiento.setValor(transaccionDTO.getValor());
			movimiento.setCuenta(transaccionDTO.getCuenta());
			if((cuenta.getSaldo() - transaccionDTO.getValor()) < 0) {
				throw new Exception("Saldo no disponible");
			}
			cuenta.setSaldo(cuenta.getSaldo()-transaccionDTO.getValor());
			try {
				movimientoDao.save(movimiento);
				cuentaDao.save(cuenta);
			}catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Error");
			}
		}else {
			throw new Exception("Cuenta no existe");
		}

	}

}
