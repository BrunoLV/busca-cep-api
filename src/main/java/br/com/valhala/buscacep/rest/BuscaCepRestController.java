package br.com.valhala.buscacep.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.valhala.buscacep.modelo.Endereco;
import br.com.valhala.buscacep.services.BuscaCepService;

@RestController
@RequestMapping("buscaCep")
public class BuscaCepRestController {
	
	@Autowired
	private BuscaCepService service;
	
	@GetMapping(value = "/{cep}")
	public ResponseEntity<Endereco> buscaCep(@PathVariable("cep") String cep) {
		
		Endereco endereco = service.buscaEndereco(cep);
		if (endereco != null) {
			return new ResponseEntity<Endereco>(endereco, HttpStatus.OK);
		}
		
		return new ResponseEntity<Endereco>(HttpStatus.NOT_FOUND);
		
	}

}
