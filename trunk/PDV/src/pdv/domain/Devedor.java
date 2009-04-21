package pdv.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.IndexColumn;

/**
 * 
 * @author Adriano
 *
 */

public class Devedor implements Serializable{
	
	private static final long serialVersionUID = 6653036473173460372L;

	@Id
	@Column(name="idDevedor")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private String endereco;
	
	@CollectionOfElements(targetElement=java.lang.String.class)
	@JoinTable(name="TelefoneDevedor",
			joinColumns=@JoinColumn(name="idDevedor",referencedColumnName="idDevedor"))
	@IndexColumn(name="telefone",base=1)
	private List<String> telefones;
		
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
		Devedor other = (Devedor) obj;
		if (id != other.id)
			return false;
		return true;
	}	
	
}
