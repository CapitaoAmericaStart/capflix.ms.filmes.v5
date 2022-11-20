package br.com.capflix.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.capflix.exception.NegocioException;
import br.com.capflix.exception.TabelaDeErros;
import br.com.capflix.model.dto.FilmeEntradaDto;
import br.com.capflix.repository.FilmeRepository;

@Component
public class FilmeValidator {

	@Autowired
	private FilmeRepository repository;
	
	public void criar(FilmeEntradaDto entradaDto) {
		 // nao valida
	}

	public void alterar(Long id, FilmeEntradaDto entradaDto) {
		// nao valida
	}

	public void pagarUm(Long id) {
		// nao valida		
	}

	public void excluir(Long id) {
		if(!repository.existsById(id)) {
			throw new NegocioException(TabelaDeErros.FILME_NAO_ENCONTRADO);
		}		
	}

	public void listarPorCategoria(Long idCategoria) {
		// nao valida		
	}
}
