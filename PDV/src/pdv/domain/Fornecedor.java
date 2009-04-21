package pdv.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.IndexColumn;

@Entity
public class Fornecedor implements Serializable{
	
	private static final long serialVersionUID = 8599703988600978740L;

	@Id
	@Column(name="idFornecedor")
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private String endereco;
	
	@CollectionOfElements(targetElement=java.lang.String.class)
	@JoinTable(name="TelefoneFornecedor",
			joinColumns=@JoinColumn(name="idFornecedor",referencedColumnName="idFornecedor"))
	@IndexColumn(name="telefone",base=1)
	private List<String> telefones;
	
	@ManyToMany
	@JoinTable(name="FornecedorForneceProduto",
			joinColumns=@JoinColumn(name="idFornecedor",referencedColumnName="idFornecedor"),
			inverseJoinColumns=@JoinColumn(name="idProduto",referencedColumnName="idProduto"))
	private List<Produto> produtos;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public List<String> getTelefones() {
		return telefones;
	}
	
	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (id != other.id)
			return false;
		return true;
	}	

}