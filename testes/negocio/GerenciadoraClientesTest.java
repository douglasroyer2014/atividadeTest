package negocio;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;

public class GerenciadoraClientesTest {

    @Test
    public void testPesquisaCliente() {

        // criando alguns clientes
        Cliente cliente01 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
        Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 2, true);

        // inserindo os clientes criados na lista de clientes do banco
        List<Cliente> clientesDoBanco = new ArrayList<>();
        clientesDoBanco.add(cliente01);
        clientesDoBanco.add(cliente02);

        GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco);

        Cliente cliente = gerClientes.pesquisaCliente(1);

        assertThat(cliente.getId(), is(1));
        assertThat(cliente.getEmail(), is("gugafarias@gmail.com"));

    }

    @Test
    public void shouldReturnListClient() {
        // criando alguns clientes
        Cliente cliente01 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
        Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 2, true);

        // inserindo os clientes criados na lista de clientes do banco
        List<Cliente> clientesDoBanco = new ArrayList<>();
        clientesDoBanco.add(cliente01);
        clientesDoBanco.add(cliente02);

        GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco);

        List<Cliente> listaClientes = gerClientes.getClientesDoBanco();

        assertEquals(clientesDoBanco, listaClientes);
    }

    @Test
    public void shouldAddCliente() {
        Cliente client = new Cliente(1, "Rodrigo", 24, "rodrigo@gmail.com", 1, true);
        GerenciadoraClientes gerClientes = new GerenciadoraClientes(new ArrayList<>());

        gerClientes.adicionaCliente(client);

        assertEquals(gerClientes.getClientesDoBanco().size(), 1);
    }

    @Test
    public void shouldRemoveCliente() {
        Cliente client = new Cliente(1, "Rodrigo", 24, "rodrigo@gmail.com", 1, true);

        GerenciadoraClientes gerClients = new GerenciadoraClientes(new ArrayList<>(Arrays.asList(client)));

        gerClients.removeCliente(1);

        assertEquals(gerClients.getClientesDoBanco().size(), 0);
    }

    @Test
    public void shouldClienteIsActive() {
        Cliente client = new Cliente(1, "Rodrigo", 24, "rodrigo@gmail.com", 1, true);
        GerenciadoraClientes gerClients = new GerenciadoraClientes(List.of(client));

        assertTrue(gerClients.clienteAtivo(1));
    }

    @Test
    public void shouldClearAllClientesBanco() {
        Cliente cliente01 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
        Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 2, true);

        GerenciadoraClientes gerClients = new GerenciadoraClientes(new ArrayList<>(Arrays.asList(cliente01, cliente02)));

        gerClients.limpa();

        assertEquals(gerClients.getClientesDoBanco().size(), 0);
    }

    @Test(expected = IdadeNaoPermitidaException.class)
    public void shouldReturnExceptionAgeLower() throws IdadeNaoPermitidaException {
        GerenciadoraClientes gerClient = new GerenciadoraClientes(null);

        gerClient.validaIdade(14);
    }

    @Test(expected = IdadeNaoPermitidaException.class)
    public void shouldReturnExceptionAgeBigger() throws IdadeNaoPermitidaException {
        GerenciadoraClientes gerClient = new GerenciadoraClientes(null);

        gerClient.validaIdade(70);
    }
}