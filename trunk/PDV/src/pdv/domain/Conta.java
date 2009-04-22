package pdv.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 * 
 * @author Adriano
 *
 */

@Entity
public class Conta implements Serializable{
	
	private static final long serialVersionUID = 5936755774211656472L;

	@Id
	@Column(name="idConta")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private double valor;
	
	@ManyToMany
	@JoinTable(name="ContaPossuiProduto",
			joinColumns=@JoinColumn(name="idConta",referencedColumnName="idConta"),
			inverseJoinColumns=@JoinColumn(name="idProduto",referencedColumnName="idProduto"))
	private List<Produto> produtos;
	
	@OneToOne(mappedBy="conta")
	private Devedor devedor;
	
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
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Devedor getDevedor() {
		return devedor;
	}

	public void setDevedor(Devedor devedor) {
		this.devedor = devedor;
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
		Conta other = (Conta) obj;
		if (id != other.id)
			return false;
		return true;
	}	
	
}
