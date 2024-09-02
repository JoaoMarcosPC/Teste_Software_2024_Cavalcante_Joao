import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.fail;

public class InicialTest {

    private Inicial conta;
    public double depositoInicial = 100.00;
    public double saqueValido = 70.00;
    public double saqueInvalido = 150.00;

    @BeforeEach
    public void inicializarConta() {
        conta = new Inicial();
        conta.ativar();
    }

    // Método utilizado na Pergunta
    @Test
    @DisplayName("Não Deve Depositar Com Conta Inativa")
    public void naoDeveDepositarComContaInativa() {
        try {
            conta.desativar();
            conta.depositar(depositoInicial);
        } catch(Exception e) {
            fail("Should not have thrown any exception");
        }

    }



    // Métodos utilizados na Resposta Correta
    @Test
    @DisplayName("Não Deve Sacar Com Conta Inativa")
    public void naoDeveSacarComContaInativa() {
        try {

            conta.depositar(depositoInicial);
            conta.desativar();
            conta.sacar(saqueValido);

        } catch(Exception e) {
            fail("Should not have thrown any exception");
        }
    }

    @Test
    @DisplayName("Não Deve Sacar se Valor do Saque for Inválido")
    public void naoDeveSacarSeSaqueInvalido() {
        try {
            conta.depositar(depositoInicial);
            conta.sacar(saqueInvalido);

        } catch(Exception e) {
            fail("Should not have thrown any exception");
        }
    }



    // Método utilizado na Resposta Mais Votada
    @Test
    @DisplayName("Não Deve Sacar Com Conta Ativa e Saldo Insuficiente")
    public void naoDeveSacarComContaAtivaSaldoInsuficiente() {

        conta.depositar(depositoInicial);

        //Assertions.assertThrows(RuntimeException.class, () -> conta.sacar(saqueValido));
        Assertions.assertThrows(RuntimeException.class, () -> conta.sacar(saqueInvalido));
    }

}
