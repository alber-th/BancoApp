package excecoes;

// Classe de exceção personalizada para saldo insuficiente
public class ExecaoSaldoInsuficiente extends Exception {

    // Construtor que recebe uma mensagem de erro
    public ExecaoSaldoInsuficiente(String mensagem) {
        super(mensagem);
    }
}
