package com.clientebancos.test.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cuenta {

	@Id
	@GeneratedValue
	private Long id;
	private Double saldo;
	private Long cliente;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public Long getCliente() {
		return cliente;
	}
	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}
	public Cuenta(Long id, Double saldo, Long cliente) {
		super();
		this.id = id;
		this.saldo = saldo;
		this.cliente = cliente;
	}
	public Cuenta() {
		super();
	}
	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", saldo=" + saldo + ", cliente=" + cliente + "]";
	}
	
	
}
