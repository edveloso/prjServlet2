package modelo;

public class Autor {
	
	private Integer codigo;
	
	private String nome;
	
	private String nacionalidade;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	@Override
	public String toString() {
		return "Autor [codigo=" + codigo + ", nome=" + nome
				+ ", nacionalidade=" + nacionalidade + "]";
	}
	
	
	public boolean equals(Object obj) {
		Autor autor = (Autor) obj;
		if(autor.getCodigo().equals(this.codigo))
			return true;
		
		return false;
	}
	

}






