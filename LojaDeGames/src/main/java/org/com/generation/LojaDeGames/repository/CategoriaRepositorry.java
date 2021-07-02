package org.com.generation.LojaDeGames.repository;

import java.util.List;

import org.com.generation.LojaDeGames.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepositorry extends JpaRepository<Categoria, Long> {

	
	
   
	public List<Categoria> findAllByDescricaoContainingIgnoreCase(String descricao);
	
	
	
	
}
