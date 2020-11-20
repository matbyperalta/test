package com.clientebancos.test.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Movimiento {
	
	@Id
	@GeneratedValue
	private Long id;
	private String tipo;
	private Date fecha;
	private Double valor;
	private Long cuenta;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Long getCuenta() {
		return cuenta;
	}
	public void setCuenta(Long cuenta) {
		this.cuenta = cuenta;
	}
	public Movimiento(Long id, String tipo, Date fecha, Double valor, Long cuenta) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.fecha = fecha;
		this.valor = valor;
		this.cuenta = cuenta;
	}
	public Movimiento() {
		super();
	}
	@Override
	public String toString() {
		return "Movimiento [id=" + id + ", tipo=" + tipo + ", fecha=" + fecha + ", valor=" + valor + "]";
	}
	
}
