
package com.clientebancos.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clientebancos.test.common.Constantes;
import com.clientebancos.test.dto.RespuestaDTO;
import com.clientebancos.test.interfaces.ICuentaService;

@RestController
public class CuentasRestController {

	@Autowired
	private ICuentaService cuentaService;
	
	@RequestMapping(path = "/crearCuenta/{idCliente}", method = RequestMethod.POST)
	public ResponseEntity<RespuestaDTO> crearCuenta(@PathVariable Long idCliente) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", System.getenv("CORS"));
		responseHeaders.set("Access-Control-Request-Method", "GET,POST");
		responseHeaders.set("Access-Control-Allow-Headers", "Content-Type,Authorization");
		try {
			cuentaService.crearCuenta(idCliente);
		}catch (Exception e) {
			return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.ERROR, e.getMessage(), null));
		}
		return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.OK, null, null)); 
	}
	
	@RequestMapping(path = "/cuentas/{idCliente}", method = RequestMethod.GET)
	public ResponseEntity<RespuestaDTO> cliente(@PathVariable Long idCliente){
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", System.getenv("CORS"));
		responseHeaders.set("Access-Control-Request-Method", "GET,POST");
		responseHeaders.set("Access-Control-Allow-Headers", "Content-Type,Authorization");
		try {
			var cuentas = cuentaService.cuentasPorCliente(idCliente);
			if(cuentas!= null && !cuentas.isEmpty()) {
				return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.OK, null, cuentas));
			}else {
				return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.OK, null, null));
			}
		}catch (Exception e) {
			return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.ERROR, e.getMessage(), null));
		}
	}
	
	@RequestMapping(path = "/cuenta/{id}", method = RequestMethod.GET)
	public ResponseEntity<RespuestaDTO> cuenta(@PathVariable Long id) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", System.getenv("CORS"));
		responseHeaders.set("Access-Control-Request-Method", "GET,POST");
		responseHeaders.set("Access-Control-Allow-Headers", "Content-Type,Authorization");
		try {

			var cuenta = cuentaService.consultarCuenta(id);
			if (cuenta.isPresent()) {
				return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.OK, null, cuenta));
			} else {
				return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.OK, null, null));
			}
		} catch (Exception e) {
			return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.ERROR, e.getMessage(), null));
		}
	}
	
}
