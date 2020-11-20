package com.clientebancos.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clientebancos.test.common.Constantes;
import com.clientebancos.test.dto.RespuestaDTO;
import com.clientebancos.test.dto.TransaccionDTO;
import com.clientebancos.test.interfaces.IMovimientoService;

@RestController
public class MovimientoController {

	@Autowired
	private IMovimientoService movimientoService;
	
	@RequestMapping(path = "/consignar", method = RequestMethod.POST)
	public ResponseEntity<RespuestaDTO> consignar(@RequestBody TransaccionDTO transaccionDTO) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", System.getenv("CORS"));
		responseHeaders.set("Access-Control-Request-Method", "GET,POST");
		responseHeaders.set("Access-Control-Allow-Headers", "Content-Type,Authorization");
		try {
			movimientoService.consignar(transaccionDTO);
		}catch (Exception e) {
			return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.ERROR, e.getMessage(), null));
		}
		return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.OK, null, null));
	} 
	
	@RequestMapping(path = "/retirar", method = RequestMethod.POST)
	public ResponseEntity<RespuestaDTO> retirar(@RequestBody TransaccionDTO transaccionDTO) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", System.getenv("CORS"));
		responseHeaders.set("Access-Control-Request-Method", "GET,POST");
		responseHeaders.set("Access-Control-Allow-Headers", "Content-Type,Authorization");
		try {
			movimientoService.retirar(transaccionDTO);
		}catch (Exception e) {
			return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.ERROR, e.getMessage(), null)); 
		}
		return ResponseEntity.ok().headers(responseHeaders).body(new RespuestaDTO(Constantes.OK, null, null)); 
	} 
	
}
