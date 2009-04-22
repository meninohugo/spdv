package pdv.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Produto implements Serializable{
	
	private static final long serialVersionUID = -8008907566479063036L;

	@Id
	@Column(name="idProduto")	
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private int quantidade;
	
	@Column
	private double preco;
	
	@ManyToMany
	@JoinTable(name="OrdemDeCompraPossuiProduto",
			joinColumns=@JoinColumn(name="idProduto",referencedColumnName="idProduto"),
			inverseJoinColumns=@JoinColumn(name="idOrdemDeCompra",referencedColumnName="idOrdemDeCompra"))			
	private List<OrdemDeCompra> ordensDeCompra = new ArrayList<OrdemDeCompra>();
	
	@ManyToMany
	@JoinTable(name="FornecedorForneceProduto",
			joinColumns=@JoinColumn(name="idProduto",referencedColumnName="idProduto"),
			inverseJoinColumns=@JoinColumn(name="idFornecedor",referencedColumnName="idFornecedor"))
	private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();	
	
	@ManyToMany
	@JoinTable(name="ContaPossuiProduto",
			joinColumns=@JoinColumn(name="idProduto",referencedColumnName="idProduto"),
			inverseJoinColumns=@JoinColumn(name="idConta",referencedColumnName="idConta"))
	private List<Conta> contas = new ArrayList<Conta>();	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idFabricante",referencedColumnName="idFabricante")
	private Fabricante fabricante;
	
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
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}	
	
	public List<OrdemDeCompra> getOrdensDeCompra() {
		return ordensDeCompra;
	}

	public void setOrdensDeCompra(List<OrdemDeCompra> ordensDeCompra) {
		this.ordensDeCompra = ordensDeCompra;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}	
	
	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
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
		Produto other = (Produto) obj;
		if (id != other.id)
			return false;
		return true;
	}	
}
