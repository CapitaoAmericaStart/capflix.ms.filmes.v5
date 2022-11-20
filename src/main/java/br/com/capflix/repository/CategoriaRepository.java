package br.com.capflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.capflix.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	boolean existsByNome(String nome);

	boolean existsByIdNotAndNome(Long id, String nome);
}
