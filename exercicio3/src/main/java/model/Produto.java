package model;

public class Produto {
	private int codigo;
	private String nome;
	private String tipo;
	
	public Produto() {
		this.codigo = 0000;
		this.nome = "";
		this.tipo = "";
	}
	
	public Produto(int codigo, String nome, String tipo) {
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome + ", tipo=" + tipo + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.getCodigo() == ((Produto) obj).getCodigo());
	}
}
