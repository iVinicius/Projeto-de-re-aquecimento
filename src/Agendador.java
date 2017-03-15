import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 */

/**
 * @author 14108849
 *
 */
public class Agendador implements iAgendador {

	Queue<Cliente> clientes;

	Queue<Cliente> clientesPrioritarios;

	ArrayList<Caixa> caixas;

	ArrayList<Caixa> caixasDisponiveis;

	public Agendador() {
		clientes = new LinkedList<>();
		clientesPrioritarios = new LinkedList<>();

		caixas = new ArrayList<>(10);
		caixasDisponiveis = new ArrayList<>();
		Caixa aux;
		for (int i = 1; i <= 10; i++) {
			if (i <= 5) {
				aux = new Caixa(i, true);
			} else {
				aux = new Caixa(i, false);
			}
			caixas.add(aux);
			caixasDisponiveis.add(aux);
		}
	}

	@Override
	public void cadastrarCliente(String nome, int idade) {
		boolean prioritario = idade >= 65 ? true : false;

		Cliente aux = new Cliente(nome, idade);

		clientes.add(aux);

		if (prioritario) {
			clientesPrioritarios.add(aux);
		}
	}

	@Override
	public String proximoCliente() {
		if (clientes.isEmpty()) {
			return "";
		}

		boolean temPrioritarios = clientesPrioritarios.size() > 0 ? true : false;
		Caixa caixa = null;
		Cliente cliente = null;

		if (temPrioritarios) {
			cliente = clientesPrioritarios.poll();
			clientes.remove(cliente);
		} else{
			cliente = clientes.poll();
		}
		
		caixa = this.primeiroCaixaDisponivel(temPrioritarios);

		caixa.atender(cliente);
		
		return cliente.getNome();
	}

	private Caixa primeiroCaixaDisponivel(boolean clientePrioritario) {
		Caixa aux = null;
		if (clientePrioritario) {
			for (Caixa c : caixasDisponiveis) {
				if (c.isPrioritario()) {
					aux = c;
					break;
				}
			}
			caixasDisponiveis.remove(aux);
		} else {
			for (Caixa c : caixasDisponiveis) {
				aux = c;
				break;
			}
			caixasDisponiveis.remove(aux);
		}
		return aux;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Agendador [clientes=");
		builder.append(clientes);
		builder.append(", clientesPrioritarios=");
		builder.append(clientesPrioritarios);
		builder.append(", caixas=");
		builder.append(caixas);
		builder.append(", caixasDisponiveis=");
		builder.append(caixasDisponiveis);
		builder.append("]");
		return builder.toString();
	}
}