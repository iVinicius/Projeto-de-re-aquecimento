/**
 * 
 */
package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import source.Agendador;
import source.Cliente;

/**
 * @author Vinicius_B_Rosa
 *
 */
public class AgendadorTest {

	private Agendador entity;
	
	@Before
	public void setup(){
		entity = new Agendador();
		entity.cadastrarCliente("Vinicius", 21);
		entity.cadastrarCliente("Luis", 70);
		entity.cadastrarCliente("Nego do Borel", 45);
		entity.cadastrarCliente("Bruneira", 31);
	}
	
	@Test
	public void testOrdemDeAtendimento(){
		String aux = null;
		aux = entity.proximoCliente();
		Assert.assertEquals("Luis", aux);
		
		aux = entity.proximoCliente();
		Assert.assertEquals("Vinicius", aux);
		
		aux = entity.proximoCliente();
		Assert.assertEquals("Nego do Borel", aux);
		
		aux = entity.proximoCliente();
		Assert.assertEquals("Bruneira", aux);
	}
	
	@Test
	public void testCadastrarCliente(){
		entity = new Agendador();
		Cliente aux = new Cliente("Robera", 30);
		entity.cadastrarCliente(aux);
		Assert.assertEquals(aux.getNome(), entity.proximoCliente());
	}
	
	@Test
	public void testAtendeuPrioritarioPrimeiro(){
		Assert.assertEquals("Luis", entity.proximoCliente());
	}
	
	@Test
	public void testOrdemDeChegada(){
		entity.proximoCliente();
		Assert.assertEquals("Vinicius", entity.proximoCliente());
	}
}