package test;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import source.Caixa;
import source.Cliente;

public class CaixaTest {
	
	private Caixa entity;
	
	@Before
	public void setup(){
		entity = new Caixa(1, true);
	}

	@Test
	public void testCaixaPrioritario() {
		Assert.assertTrue(entity.isPrioritario());
	}
	
	@Test
	public void testCaixaOcupado() {
		entity.atender(new Cliente("XX", 99));
		Assert.assertTrue(entity.isOcupado());
	}
	
	@Test
	public void testCaixaDisponivel1() {
		Assert.assertTrue(!entity.isOcupado());
	}
	
	@Test
	public void testCaixaDisponivel2() {
		entity.atender(new Cliente("XX", 99));
		entity.terminarAtendimento();
		Assert.assertTrue(!entity.isOcupado());
	}
	
	@Test
	public void testCaixaDisponivelNegativo() {
		Assert.assertFalse(entity.isOcupado());
	}
}