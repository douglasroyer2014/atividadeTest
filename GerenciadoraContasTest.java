package negocio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class GerenciadoraContasTest {

	@Test
	public void shouldSearchConta() {
		ContaCorrente conta1 = new ContaCorrente(1, 200, true);
		ContaCorrente conta2 = new ContaCorrente(2, 200, true);
		
		GerenciadoraContas gerContas = new GerenciadoraContas(List.of(conta1, conta2));
		
		assertEquals(gerContas.pesquisaConta(1), conta1);
	}
	
	@Test
	public void shouldReturnConta() {
		ContaCorrente conta1 = new ContaCorrente(1, 200, false);
		GerenciadoraContas gerContas = new GerenciadoraContas(List.of());
		
		gerContas.adicionaConta(conta1);
		
		assertEquals(gerContas.getContasDoBanco().size(), 1);
	}
	
	@Test
	public void shouldRemoveConta() {
		ContaCorrente conta1 = new ContaCorrente(1, 200, true);
		ContaCorrente conta2 = new ContaCorrente(2, 200, true);
		
		GerenciadoraContas gerContas = new GerenciadoraContas(List.of(conta1, conta2));
		
		gerContas.removeConta(1);
		
		assertEquals(gerContas.getContasDoBanco().size(), 0);
	}
	
	@Test
	public void shouldReturnFalseBecauseContaDisable() {
		ContaCorrente conta = new ContaCorrente(1, 200, false);
		
		GerenciadoraContas gerContas = new GerenciadoraContas(List.of(conta));
		
		assertFalse(gerContas.contaAtiva(1));
	}
	
	@Test
	public void test() {
		ContaCorrente conta1 = new ContaCorrente(1, 200, true);
		ContaCorrente conta2 = new ContaCorrente(2, 200, true);
		
		GerenciadoraContas gerContas = new GerenciadoraContas(List.of(conta1, conta2));
		
		assertTrue(gerContas.transfereValor(1, 100, 2));
		assertEquals(gerContas.pesquisaConta(1).getSaldo(), 300);
		assertEquals(gerContas.pesquisaConta(2).getSaldo(), 100);
	}
}
