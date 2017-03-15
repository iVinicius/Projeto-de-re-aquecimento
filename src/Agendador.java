import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 */

/**
 * @author 14108849
 *
 */
public class Agendador implements iAgendador {

	Stack<Cliente> clientes;

	Stack<Cliente> clientesPrioritarios;

	ArrayList<Caixa> caixas;

	ArrayList<Caixa> caixasDisponiveis;

	public Agendador() {
		clientes = new Stack<>();
		clientesPrioritarios = new Stack<>();

		caixas = new ArrayList<>(10);
		caixasDisponiveis = new ArrayList<>();
		Caixa aux;
		for (int i = 1; i <= 10; i++) {
			if (i < 5) {
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

		clientes.push(aux);

		if (prioritario) {
			clientesPrioritarios.push(aux);
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
			cliente = clientesPrioritarios.pop();
			clientes.remove(cliente);
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
					caixasDisponiveis.remove(c);
				}
			}
		} else {
			for (Caixa c : caixasDisponiveis) {
				aux = c;
				caixasDisponiveis.remove(c);
			}

		}
		return aux;
	}
}