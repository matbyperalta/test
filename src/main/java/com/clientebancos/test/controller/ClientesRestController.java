package com.clientebancos.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clientebancos.test.common.Constantes;
import com.clientebancos.test.dto.RespuestaDTO;
import com.clientebancos.test.entity.Cliente;
import com.clientebancos.test.interfaces.IClienteService;

@RestController
public class ClientesRestController {

	@Autowired
	private IClienteService clienteService;

	@RequestMapping(path = "/clientes", method = RequestMethod.GET)
	public ResponseEntity<RespuestaDTO> clientes() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", System.getenv("CORS"));
		responseHeaders.set("Access-Control-Request-Method", "GET,POST");
		responseHeaders.set("Access-Control-Allow-Headers", "Content-Type,Authorization");
		try {
			var clientes = clienteService.clientes();
			if (clientes != null && !clientes.isEmpty()) {
				return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.OK, null, clientes));
			} else {
				return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.OK, null, null));
			}
		} catch (Exception e) {
			return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.ERROR, e.getMessage(), null));
		}
	}

	@RequestMapping(path = "/cliente/{id}", method = RequestMethod.GET)
	public ResponseEntity<RespuestaDTO> cliente(@PathVariable Long id) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", System.getenv("CORS"));
		responseHeaders.set("Access-Control-Request-Method", "GET,POST");
		responseHeaders.set("Access-Control-Allow-Headers", "Content-Type,Authorization");
		try {

			var cliente = clienteService.cliente(id);
			if (cliente.isPresent()) {
				return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.OK, null, cliente));
			} else {
				return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.OK, null, null));
			}
		} catch (Exception e) {
			return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.ERROR, e.getMessage(), null));
		}
	}

	@RequestMapping(path = "/crearCliente", method = RequestMethod.POST)
	public ResponseEntity<RespuestaDTO> crearCliente(@RequestBody Cliente cliente) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", System.getenv("CORS"));
		responseHeaders.set("Access-Control-Request-Method", "GET,POST");
		responseHeaders.set("Access-Control-Allow-Headers", "Content-Type,Authorization");
		try {
			clienteService.crearCliente(cliente);
		} catch (Exception e) {
			return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.ERROR, e.getMessage(), null));
		}
		return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.OK, null, null));
	}

	@RequestMapping(path = "/actualizarCliente/{id}", method = RequestMethod.PUT)
	public ResponseEntity<RespuestaDTO> actualizarCliente(@RequestBody Cliente cliente, @PathVariable Long id) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", System.getenv("CORS"));
		responseHeaders.set("Access-Control-Request-Method", "GET,POST");
		responseHeaders.set("Access-Control-Allow-Headers", "Content-Type,Authorization");
		try {
			clienteService.actualizarCliente(cliente, id);
		} catch (Exception e) {
			return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.ERROR, e.getMessage(), null));
		}
		return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.OK, null, null));
	}

	@RequestMapping(path = "/eliminarCliente/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<RespuestaDTO> eliminarCliente(@PathVariable Long id) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", System.getenv("CORS"));
		responseHeaders.set("Access-Control-Request-Method", "GET,POST");
		responseHeaders.set("Access-Control-Allow-Headers", "Content-Type,Authorization");
		try {
			clienteService.eliminarCliente(id);
		} catch (Exception e) {
			return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.ERROR, e.getMessage(), null));
		}
		return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.OK, null, null));
	}
	
	@RequestMapping(path = "/buscarCliente/{nombre}", method = RequestMethod.GET)
	public ResponseEntity<RespuestaDTO> cliente(@PathVariable String nombre) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", System.getenv("CORS"));
		responseHeaders.set("Access-Control-Request-Method", "GET,POST");
		responseHeaders.set("Access-Control-Allow-Headers", "Content-Type,Authorization");
		try {

			var clientes = clienteService.buscar(nombre);
			if (clientes != null && !clientes.isEmpty()) {
				return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.OK, null, clientes));
			} else {
				return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.OK, null, null));
			}
		} catch (Exception e) {
			return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.ERROR, e.getMessage(), null));
		}
	}

}
