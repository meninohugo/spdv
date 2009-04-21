package pdv.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * 
 * @author Adriano
 *
 */

@Entity
public class OrdemDeCompra implements Serializable{
	
	private static final long serialVersionUID = 4063391992141140782L;

	@Id
	@Column(name="idOrdemDeCompra")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private double valor;
	
	@Column
	private Date data;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idFuncionario",referencedColumnName="idFuncionario")
	private Funcionario funcionario;
	
	@ManyToMany
	@JoinTable(name="OrdemDeCompraPossuiProduto",
			joinColumns = @JoinColumn(name="idOrdemDeCompra",referencedColumnName="idOrdemDeCompra"),
			inverseJoinColumns = @JoinColumn(name="idProduto",referencedColumnName="idProduto"))
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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
		OrdemDeCompra other = (OrdemDeCompra) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
