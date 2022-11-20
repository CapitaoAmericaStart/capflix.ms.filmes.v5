package br.com.capflix.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoriaEntradaDto {
	
	@NotBlank(message="obrigatório")
	@Size(max=200, message="máximo 200 caracteres")
	private String nome;
}
