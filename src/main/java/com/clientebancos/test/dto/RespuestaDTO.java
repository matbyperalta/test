package com.clientebancos.test.dto;

public class RespuestaDTO {

	private String codigo;
	private String mensaje;
	private Object datos;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Object getDatos() {
		return datos;
	}
	public void setDatos(Object datos) {
		this.datos = datos;
	}
	public RespuestaDTO(String codigo, String mensaje, Object datos) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.datos = datos;
	}
	public RespuestaDTO() {
		super();
	}
	
}
