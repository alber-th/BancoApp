package interfaces;

import modelos.Conta;

// Interface que define as operações bancárias
public interface OperacoesBancarias {

    // Método para transferir dinheiro para outra conta
    void transferir(Conta destino, double valor) throws Exception;

    // Método para imprimir o extrato da conta
    void imprimirExtrato();
}
