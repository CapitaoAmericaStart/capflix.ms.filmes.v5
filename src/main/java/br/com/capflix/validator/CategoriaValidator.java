package br.com.capflix.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.capflix.exception.NegocioException;
import br.com.capflix.exception.TabelaDeErros;
import br.com.capflix.model.dto.CategoriaEntradaDto;
import br.com.capflix.repository.CategoriaRepository;
import br.com.capflix.repository.FilmeRepository;

@Component
public class CategoriaValidator {

	@Autowired
	private CategoriaRepository repository;
	
	@Autowired
	private FilmeRepository filmeRepository;
	
	public void criar(CategoriaEntradaDto entradaDto) {
		if(repository.existsByNome(entradaDto.getNome())) {
			throw new NegocioException(TabelaDeErros.NOME_DE_CATEGORIA_JA_CADASTRADO);
		}
	}

	public void alterar(Long id, CategoriaEntradaDto entradaDto) {
		if(repository.existsByIdNotAndNome(id, entradaDto.getNome())) {
			throw new NegocioException(TabelaDeErros.NOME_DE_CATEGORIA_JA_CADASTRADO);
		}
	}

	public void pagarUm(Long id) {
		// nao valida
	}

	public void excluir(Long id) {
		if(!repository.existsById(id)) {
			throw new NegocioException(TabelaDeErros.CATEGORIA_NAO_ENCONTRADA);
		}	
		
		if(filmeRepository.existsByCategoria_id(id)) {
			throw new NegocioException(TabelaDeErros.CATEGORIA_ASSOCIADA_A_UM_FILME);
		}
	}
}
