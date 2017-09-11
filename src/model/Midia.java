package model;

public class Midia {
	
	private int id;
	private String descricao;
	private double custo;
	private double preco_venda;
	private int quantidade;
	private double valor_comissao;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getCusto() {
		return custo;
	}
	public void setCusto(double custo) {
		this.custo = custo;
	}
	public double getPreco_venda() {
		return preco_venda;
	}
	public void setPreco_venda(double preco_venda) {
		this.preco_venda = preco_venda;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValor_comissao() {
		return valor_comissao;
	}
	public void setValor_comissao(double valor_comissao) {
		this.valor_comissao = valor_comissao;
	}

}
