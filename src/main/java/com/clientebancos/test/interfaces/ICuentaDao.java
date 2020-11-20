package com.clientebancos.test.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.clientebancos.test.entity.Cuenta;

public interface ICuentaDao extends JpaRepository<Cuenta, Long> {

	@Query(value = "select * from cuenta where cliente = :id", nativeQuery = true)
	public List<Cuenta> cuentasPorCliente(@Param("id") Long id);
	
}
