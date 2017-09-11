package model;

public class Certificado {
	
	private int id;
	private String tipo;
	private int tempoValidade;
	private String midia;
	private double custoCertificado;
	private double custoComissao;
	private double custoMidia;
	private double preco_vista;
	private double preco_prazo;
	
	
	public double getPreco_vista() {
		return preco_vista;
	}
	public void setPreco_vista(double preco_vista) {
		this.preco_vista = preco_vista;
	}
	public double getPreco_prazo() {
		return preco_prazo;
	}
	public void setPreco_prazo(double preco_prazo) {
		this.preco_prazo = preco_prazo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getTempoValidade() {
		return tempoValidade;
	}
	public void setTempoValidade(int tempoValidade) {
		this.tempoValidade = tempoValidade;
	}
	public String getMidia() {
		return midia;
	}
	public void setMidia(String midia) {
		this.midia = midia;
	}
	public double getCustoCertificado() {
		return custoCertificado;
	}
	public void setCustoCertificado(double custoCertificado) {
		this.custoCertificado = custoCertificado;
	}
	public double getCustoComissao() {
		return custoComissao;
	}
	public void setCustoComissao(double custoComissao) {
		this.custoComissao = custoComissao;
	}
	public double getCustoMidia() {
		return custoMidia;
	}
	public void setCustoMidia(double custoMidia) {
		this.custoMidia = custoMidia;
	}
	

}
