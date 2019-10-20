package br.com.valhala.buscacep.clients.viacep;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.valhala.buscacep.clients.viacep.dtos.EnderecoDto;

@FeignClient(name = "clientViaCep", url = "http://viacep.com.br/ws")
public interface ClientViaCep {

	@RequestMapping(value = "/{cep}/json/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	EnderecoDto consultaCep(@PathVariable("cep") String cep);

}
