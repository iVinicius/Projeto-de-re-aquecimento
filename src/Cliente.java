/**
 * 
 */

/**
 * @author 14108849
 *
 */
public class Cliente {
	
	private int id;
	
	private int idade;
	
	private String nome;

	public Cliente(int id, int idade) {
		super();
		this.id = id;
		this.idade = idade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
