package org.com.generation.farmacia.controller;
import java.util.List;
import org.com.generation.farmacia.model.Categoria;
import org.com.generation.farmacia.repository.CategoriaRepository;
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
	 private CategoriaRepository categoriarepository;
	 
	 @GetMapping
	 public ResponseEntity<List<Categoria>> findAllCategoria (){
		 
		 return ResponseEntity.ok(categoriarepository.findAll());	 
	  }
	 
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<Categoria> findByAll (@PathVariable long id) {
		 
		 return categoriarepository.findById(id)
				 .map(resp -> ResponseEntity.ok(resp))
	 	         .orElse(ResponseEntity.notFound().build());	 
	  }
	
	
	
	  @GetMapping("/descricao/{descricao}")
	  public ResponseEntity<List<Categoria>> findAllByDescricaoContainingIgnoreCase (@PathVariable String descricao){
		  
		  return ResponseEntity.ok(categoriarepository.findAllByDescricaoContainingIgnoreCase(descricao));  
	   }
	
	
	  @PostMapping
	  public ResponseEntity<Categoria>postCategoria(@RequestBody Categoria categoria ){
		  	  
		  return ResponseEntity.status(HttpStatus.CREATED).body(categoriarepository.save(categoria));	  
	  }
	  
	  
	  
	  @PutMapping
	  public ResponseEntity<Categoria>putCategoria(@RequestBody Categoria categoria ){
		    
		  return ResponseEntity.ok(categoriarepository.save(categoria));	  
	  }
	
	
	  @DeleteMapping("/{id}")
		public void deleteById(@PathVariable long id) {
			
			categoriarepository.deleteById(id);
				
		}
	
	
	
	
}
