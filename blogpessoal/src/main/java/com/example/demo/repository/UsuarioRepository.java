package com.example.demo.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuario;





@Repository
public interface UsuarioRepository extends JpaRepository <Usuario , Long>{

	
	public Optional <Usuario> findByUsuario(String usuario); //optional é porque pode devolver nulo caso não encontre o usuario
	
	public Usuario findByNome(String nome);
	
	public List <Usuario> findAllByNomeContainingIgnoreCase (String nome);

	
	
	
}
