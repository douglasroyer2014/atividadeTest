import negocio.GerenciadoraClientesTest;
import negocio.GerenciadoraContasTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@SuiteClasses({
        GerenciadoraClientesTest.class,
        GerenciadoraContasTest.class
})

public class JunitTestSuite {
}
