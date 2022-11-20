package br.com.capflix.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.capflix.model.dto.CategoriaEntradaDto;
import br.com.capflix.model.dto.CategoriaSaidaDto;
import br.com.capflix.service.CategoriaService;
import br.com.capflix.validator.CategoriaValidator;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("categoria")
@Log4j2
@Validated
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	@Autowired
	private CategoriaValidator validator;
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	@Transactional
	public CategoriaSaidaDto criar(@Valid @RequestBody CategoriaEntradaDto entradaDto) {
		log.info("salvar: {}", entradaDto);
		
		validator.criar(entradaDto);

		return service.criar(entradaDto);
	}
	
	@PutMapping("id/{id}")
	@Transactional
	public void alterar(
			@Min(value = 1, message="valor mínimo 1")
			@PathVariable("id") Long id, 
			
			@Valid @RequestBody CategoriaEntradaDto entradaDto
			) {
		log.info("alterar: {}, {}", id, entradaDto);

		validator.alterar(id, entradaDto);
		
		service.alterar(id, entradaDto);
	}
	
	@GetMapping("id/{id}")
	@Transactional
	public CategoriaSaidaDto pagarUm(
			@Min(value = 1, message="valor mínimo 1")
			@PathVariable("id") Long id
			) {
		log.info("pagarUm: {}", id);
		
		validator.pagarUm(id);
		
		return service.pagarUm(id);
	}
	
	@DeleteMapping("id/{id}")
	@Transactional
	public void excluir(
			@Min(value = 1, message="valor mínimo 1")
			@PathVariable("id") Long id
			) {
		log.info("excluir: {}", id);
		
		validator.excluir(id);
		
		service.excluir(id);
	}
	
	@GetMapping
	@Transactional
	public List<CategoriaSaidaDto> listar() {
		log.info("listar");
		
		return service.listar();
	}
}
