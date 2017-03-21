package source;
/**
 * 
 */

/**
 * @author Vinicius_B_Rosa
 *
 */
public class Caixa {
	
	private int id;
	
	private Cliente cliente;
	
	private boolean ocupado;
	
	private boolean prioritario;
	
	public Caixa(int id, boolean prioritario){
		this.id = id;
		this.prioritario = prioritario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public boolean getprioritario() {
		return prioritario;
	}

	public boolean isOcupado() {
		if(cliente == null) {
			return false;
		}
		return true;
	}

	public boolean atender(Cliente cliente) {
		if(ocupado) {
			return false;
		}		
		this.cliente = cliente;
		ocupado = true;		
		return true;
	}
	
	public Cliente terminarAtendimento(){
		Cliente aux = cliente;
		cliente = null;
		ocupado = false;
		return aux;
	}
	
	public boolean isPrioritario(){
		return prioritario;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Caixa [id=");
		builder.append(id);
		builder.append(", cliente=");
		builder.append(cliente);
		builder.append(", ocupado=");
		builder.append(ocupado);
		builder.append(", prioritario=");
		builder.append(prioritario);
		builder.append("]");
		return builder.toString();
	}
	
}
