package source;
/**
 * 
 */

/**
 * @author 14108849
 *
 */
public class Console {
	
	public static void main(String args[]){
		
		Agendador agendador = new Agendador();
		
		agendador.cadastrarCliente("Vinicius", 19);
		
		agendador.cadastrarCliente("Seu Jorge", 27);
		
		agendador.cadastrarCliente("Olavo", 70);
		
		agendador.cadastrarCliente("Luska", 65);
		
		agendador.cadastrarCliente("Chassotera", 13);
		
		String xx = agendador.proximoCliente();
		
		System.out.println(xx);
		
		xx = agendador.proximoCliente();
		
		System.out.println(xx);
		
		xx = agendador.proximoCliente();
		
		System.out.println(xx);
		
		xx = agendador.proximoCliente();
		
		System.out.println(xx);
		
		xx = agendador.proximoCliente();
		
		System.out.println(xx);
	}

}
