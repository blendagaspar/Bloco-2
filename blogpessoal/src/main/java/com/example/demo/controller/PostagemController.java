package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.model.Postagem;
import com.example.demo.repository.PostagemRepository;

@RestController
@RequestMapping("/postagem")
@CrossOrigin("*")
public class PostagemController {  // o video so chega até aqui

	@Autowired
	private PostagemRepository repository; // não está no video
	
	//consultar dados da tabela(GET)
	@GetMapping
	public ResponseEntity<List<Postagem>> GetAll () { //n esta no video
		return ResponseEntity.ok(repository.findAll()); // Se deu certo vai aparecer o 200 não está no video
	
	}	
		//consultar id  usando lambda(GET)
		@GetMapping("/{id}")
		public ResponseEntity<Postagem> GetById (@PathVariable long id) {
			return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	
	}
    
		//pesquisar por titulo (GET)
	@GetMapping("/titulo/{titulo}")	
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
				
	}
	
	//criar postagem (Post)
	@PostMapping
	public ResponseEntity<Postagem>postPostagem(@RequestBody Postagem postagem){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
				
	}
	
	
	
	//Editar uma postagem (PUT)- precisa passar o Id sempre
   @PutMapping
   public ResponseEntity<Postagem>putPostagem(@RequestBody Postagem postagem){
		
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
		
  }
	
   
   
   //deletar postagem (delete) usa o id no caminho e não do body 
   @DeleteMapping("/{id}")
	public void deletePostagem(@PathVariable long id) {
		
		repository.deleteById(id);
			
	}
	
		
		
}