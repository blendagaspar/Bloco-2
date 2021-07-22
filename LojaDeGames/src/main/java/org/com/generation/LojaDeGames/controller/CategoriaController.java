package org.com.generation.LojaDeGames.controller;

import java.util.List;
import org.com.generation.LojaDeGames.model.Categoria;
import org.com.generation.LojaDeGames.repository.CategoriaRepositorry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepositorry CategoriaRepositorry;
	
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAllCategoria () {
		
		return ResponseEntity.ok(CategoriaRepositorry.findAll());
    }
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findByIDCategoria (@PathVariable long id) {
		return CategoriaRepositorry.findById(id)
			.map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity.notFound().build());
	}
	
	//get
	@GetMapping("/descricao/{descricao}")	
	public ResponseEntity<List<Categoria>> findAllByDescricaoContainingIgnoreCase(@PathVariable String descricao) {
		return ResponseEntity.ok(CategoriaRepositorry.findAllByDescricaoContainingIgnoreCase(descricao));
					
	}
	
	//post
	@PostMapping
	public ResponseEntity<Categoria>postCategoria(@RequestBody Categoria categoria){
			
		return ResponseEntity.status(HttpStatus.CREATED).body(CategoriaRepositorry.save(categoria));
	}
	  
	//put
	@PutMapping
	public ResponseEntity<Categoria>putCategoria(@RequestBody Categoria categoria){
			
			return ResponseEntity.ok(CategoriaRepositorry.save(categoria));
			
	  }
	
	//delete
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable long id) {
		
		CategoriaRepositorry.deleteById(id);
			
	}
	
			
}