package br.com.capflix.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.capflix.exception.NegocioException;
import br.com.capflix.exception.TabelaDeErros;
import br.com.capflix.model.Categoria;
import br.com.capflix.model.dto.CategoriaEntradaDto;
import br.com.capflix.model.dto.CategoriaSaidaDto;
import br.com.capflix.model.dto.FilmeSaidaDto;
import br.com.capflix.repository.CategoriaRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	public CategoriaSaidaDto criar(CategoriaEntradaDto entradaDto) {
		try {
			Categoria categoria = mapper.map(entradaDto, Categoria.class);
			
			Categoria categoriaBanco = repository.save(categoria);
			
			return mapper.map(categoriaBanco, CategoriaSaidaDto.class);
		} catch (Exception e) {
			log.error("erro genérico: ", e);
			
			throw new NegocioException(TabelaDeErros.SISTEMA);
		} 
	}

	public void alterar(Long id, CategoriaEntradaDto entradaDto) {
		try {
			Optional<Categoria> optional = repository.findById(id);
			
			if(!optional.isPresent()) {
				throw new NegocioException(TabelaDeErros.CATEGORIA_NAO_ENCONTRADA);
			}
			
			Categoria categoriaBanco = optional.get();
			
			mapper.map(entradaDto, categoriaBanco);
	
			repository.save(categoriaBanco);
		} catch (NegocioException e) {
			throw e;
		} catch (Exception e) {
			log.error("erro genérico: ", e);
			
			throw new NegocioException(TabelaDeErros.SISTEMA);
		}
	}

	public CategoriaSaidaDto pagarUm(Long id) {
		try {
			Optional<Categoria> optional = repository.findById(id);
			
			if(!optional.isPresent()) {
				throw new NegocioException(TabelaDeErros.CATEGORIA_NAO_ENCONTRADA);
			}
			
			Categoria categoriaBanco = optional.get();
			
			return mapper.map(categoriaBanco, CategoriaSaidaDto.class);
		} catch (NegocioException e) {
			throw e;
		} catch (Exception e) {
			log.error("erro genérico: ", e);
			
			throw new NegocioException(TabelaDeErros.SISTEMA);
		}		
	}

	public void excluir(Long id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			log.error("erro genérico: ", e);
			
			throw new NegocioException(TabelaDeErros.SISTEMA);
		}		
	}

	public List<CategoriaSaidaDto> listar() {
		try {
			List<Categoria> lista = repository.findAll();
			
			return mapper.map(lista, new TypeToken<List<FilmeSaidaDto>>() {}.getType());
		} catch (Exception e) {
			log.error("erro genérico: ", e);
			
			throw new NegocioException(TabelaDeErros.SISTEMA);
		}
	}
}
