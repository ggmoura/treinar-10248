package br.com.treinar.bb.teste;

import java.util.ArrayList;
import java.util.Vector;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.treinar.bb.model.Cliente;
import br.com.treinar.bb.model.banco.Banco;
import br.com.treinar.bb.model.banco.ContaCorrente;
import br.com.treinar.bb.model.tipodado.TipoCliente;
import br.com.treinar.bb.util.BBUtil;

public class TesteSerializacaoEnum {
	
	private BBUtil util;
	
	@Before//utilizado no lugar do contrutor, pois esta classe eh instanciada pelo
	//framework junit
	public void init() {
		util = BBUtil.getInstance();
	}
	
	@Test
	public void testeSoma() {
		int a = 1 + 1;//regra de negocio
		Assert.assertEquals(a, 2);
	}

	@Test
	public void testeSerializarBanco() {
		Banco b = criarBanco();
		String serializarBanco = util.serializarBanco(b);
		Assert.assertTrue(serializarBanco.contains("CORRENTE"));

	}
	
	@Test
	public void testeCarregarBanco() {
		String serializarBanco = util.serializarBanco(criarBanco());
		Banco b = util.converterParaBanco(serializarBanco);
		Assert.assertNotNull(b);
	}

	private Banco criarBanco() {
		Banco b = new Banco();
		b.setContas(new ArrayList<>());
		
		ContaCorrente c = new ContaCorrente();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Maria Sophia");
		cliente.setTipoCliente(TipoCliente.ESPECIAL);
		
		c.setCliente(cliente);
		c.depositar(100);
		
		b.getContas().add(c);
		return b;
	}
	
	
	
}
