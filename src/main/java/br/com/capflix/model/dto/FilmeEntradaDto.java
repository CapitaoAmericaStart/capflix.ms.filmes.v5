package br.com.capflix.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FilmeEntradaDto {
	
	@NotBlank(message="obrigatório")
	@Size(max=200, message="máximo 200 caracteres")
	private String nome;
	
	@Size(max=500, message="máximo 500 caracteres")
	private String descricao;
	
	@NotBlank(message="obrigatório")
	@URL(message="inválido")
	@Size(max=200, message="máximo 200 caracteres")
	private String url;
	
	@NotNull(message="obrigatório")
	@Min(value = 1, message="valor mínimo 1")
	private Long idCategoria;
}
