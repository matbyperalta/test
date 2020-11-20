package com.clientebancos.test.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clientebancos.test.entity.Movimiento;

public interface IMovimientoDao extends JpaRepository<Movimiento, Long> {

}
