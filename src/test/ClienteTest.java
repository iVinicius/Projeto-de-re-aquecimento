package test;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import source.Cliente;

public class ClienteTest {
	
	private Cliente entity;
	
	@Before
	public void setup(){
		entity = new Cliente("Vinicius", 21);
	}

	@Test
	public void testGetNome() {
		Assert.assertEquals("Vinicius", entity.getNome());
	}
	
	@Test
	public void testGetIdade() {
		Assert.assertEquals(21, entity.getIdade());
	}
}