package br.com.valhala.buscacep.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valhala.buscacep.clients.viacep.ClientViaCep;
import br.com.valhala.buscacep.clients.viacep.dtos.EnderecoDto;
import br.com.valhala.buscacep.modelo.Endereco;
import br.com.valhala.buscacep.modelo.enuns.UF;

@Service
public class BuscaCepService {
	
	@Autowired
	private ClientViaCep client;
	
	public Endereco buscaEndereco(String cep) {
		
		EnderecoDto enderecoDto = client.consultaCep(cep);
		
		if (enderecoDto != null) {
			return Endereco
					.builder()
					.logradouro(enderecoDto.getLogradouro())
					.bairro(enderecoDto.getBairro())
					.cep(enderecoDto.getCep())
					.cidade(enderecoDto.getLocalidade())
					.ibge(Integer.valueOf(enderecoDto.getIbge()))
					.uf(UF.valueOf(enderecoDto.getUf()))
					.build();
		}
		
		return null;
		
	}

}
