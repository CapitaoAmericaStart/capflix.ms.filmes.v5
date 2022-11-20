package br.com.capflix.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TabelaDeErros {

	VALIDACAO(HttpStatus.BAD_REQUEST, "1001-1000", "dados de requisição inválidos"),
	FILME_NAO_ENCONTRADO(HttpStatus.NOT_FOUND, "1001-2000", "filme não encontrado"),	
	CATEGORIA_NAO_ENCONTRADA(HttpStatus.NOT_FOUND, "1001-2100", "categoria não encontrada"),	
	NOME_DE_CATEGORIA_JA_CADASTRADO(HttpStatus.PRECONDITION_FAILED, "1001-4100", "nome de categoria já cadastrado"),
	CATEGORIA_ASSOCIADA_A_UM_FILME(HttpStatus.PRECONDITION_FAILED, "1001-4101", "categoria associada à um filme"),
	SISTEMA(HttpStatus.INTERNAL_SERVER_ERROR, "1001-5000", "sitema indisponível");
	
	private final HttpStatus codigoHttp;
	private final String codigoDeErro;
	private final String mensagem;
}
