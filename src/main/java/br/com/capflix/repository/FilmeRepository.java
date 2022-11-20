package br.com.capflix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.capflix.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{

	boolean existsByCategoria_id(Long id);

	List<Filme> findByCategoria_id(Long idCategoria);
}
