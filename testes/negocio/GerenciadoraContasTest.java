package negocio;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

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
        GerenciadoraContas gerContas = new GerenciadoraContas(new ArrayList<>());

        gerContas.adicionaConta(conta1);

        assertEquals(gerContas.getContasDoBanco().size(), 1);
    }

    @Test
    public void shouldRemoveConta() {
        ContaCorrente conta1 = new ContaCorrente(1, 200, true);
        ContaCorrente conta2 = new ContaCorrente(2, 200, true);

        GerenciadoraContas gerContas = new GerenciadoraContas(new ArrayList<>(Arrays.asList(conta1, conta2)));

        gerContas.removeConta(1);

        assertEquals(gerContas.getContasDoBanco().size(), 1);
    }

    @Test
    public void shouldReturnFalseBecauseContaDisable() {
        ContaCorrente conta = new ContaCorrente(1, 200, false);

        GerenciadoraContas gerContas = new GerenciadoraContas(List.of(conta));

        assertFalse(gerContas.contaAtiva(1));
    }

    @Test
    public void shouldTransferValueToAnotherConta() {
        ContaCorrente conta1 = new ContaCorrente(1, 200, true);
        ContaCorrente conta2 = new ContaCorrente(2, 200, true);

        GerenciadoraContas gerContas = new GerenciadoraContas(new ArrayList<>(Arrays.asList(conta1, conta2)));

        assertTrue(gerContas.transfereValor(1, 100, 2));
        assertEquals(gerContas.pesquisaConta(1).getSaldo(), 100.0, 0.001);
        assertEquals(gerContas.pesquisaConta(2).getSaldo(), 300.0, 0.001);
    }
}