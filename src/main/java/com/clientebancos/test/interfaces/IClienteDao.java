package com.clientebancos.test.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.clientebancos.test.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long> {
	
	@Query(value = "select * from cliente where nombres like CONCAT('%',:clienteNombre,'%')", nativeQuery = true)
	public List<Cliente> findByNombreContaining(@Param("clienteNombre") String clienteNombre);
	

}
