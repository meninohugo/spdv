package pdv.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
 * @author Adriano
 *
 */

@Entity
public class Funcionario implements Serializable{
	
	private static final long serialVersionUID = -7817172940336188581L;

	@Id
	@Column(name="idFuncionario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nome;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="funcionario")	
	private List<OrdemDeCompra> ordensDeCompra = new ArrayList<OrdemDeCompra>();
	
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
	
	public List<OrdemDeCompra> getOrdensDeCompra() {
		return ordensDeCompra;
	}

	public void setOrdensDeCompra(List<OrdemDeCompra> ordensDeCompra) {
		this.ordensDeCompra = ordensDeCompra;
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
		Funcionario other = (Funcionario) obj;
		if (id != other.id)
			return false;
		return true;
	}	
	
}
