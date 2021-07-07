package org.com.generation.farmacia.controller;
import java.util.List;

import org.com.generation.farmacia.model.Produto;
import org.com.generation.farmacia.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

	  
	  @Autowired
	  private ProdutoRepository produtorepository;
	  
	  
	  @GetMapping("/{produto}")	
	  public ResponseEntity<List<Produto>> GetAll (){
		  
		 return ResponseEntity.ok(produtorepository.findAll());
		 
	  }
	 
	  @GetMapping("/{id}")	
      public ResponseEntity<Produto> GetById (@PathVariable long id){
    	  
    	     return produtorepository.findById(id)
    	    		 .map(resp -> ResponseEntity.ok(resp))
    	    		 .orElse(ResponseEntity.notFound().build());
      }
	  
	  
	  @GetMapping("/nome/{nome}")	
		public ResponseEntity<List<Produto>> GetByNome(@PathVariable String nome){
			return ResponseEntity.ok(produtorepository.findAllByNomeContainingIgnoreCase(nome));
					
		}
	  
	  
	  @PostMapping
		public ResponseEntity<Produto>postPostagem(@RequestBody Produto produto){
			
			return ResponseEntity.status(HttpStatus.CREATED).body(produtorepository.save(produto));
					
		}
	  
	  
	  @PutMapping
	   public ResponseEntity<Produto>putPostagem(@RequestBody Produto produto){
			
			return ResponseEntity.status(HttpStatus.OK).body(produtorepository.save(produto));
			
	  }

}
