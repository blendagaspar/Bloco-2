package org.com.generation.farmacia.model;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;




public class Produto {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min= 5 , max= 100)
	private String Nome;
	
	
	@NotNull 
	private int estoque ;
	
	
	@NotNull
	private double preco;
	

	@NotNull
	@Size(min= 5 , max= 100)
	private String tipoDeRemedio;

	
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private String categoria;



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getNome() {
		return Nome;
	}



	public void setNome(String nome) {
		Nome = nome;
	}



	public int getEstoque() {
		return estoque;
	}



	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}



	public double getPreco() {
		return preco;
	}



	public void setPreco(double preco) {
		this.preco = preco;
	}



	public String getTipoDeRemedio() {
		return tipoDeRemedio;
	}



	public void setTipoDeRemedio(String tipoDeRemedio) {
		this.tipoDeRemedio = tipoDeRemedio;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	
}
