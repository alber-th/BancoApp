package modelos;

import excecoes.ExecaoSaldoInsuficiente;
import interfaces.OperacoesBancarias;

// Classe que representa uma conta corrente
public class ContaCorrente extends Conta implements OperacoesBancarias {

    // Taxa de operação cobrada a cada saque (0.5%)
    private double taxaOperacao = 0.005;

    // Construtor da conta corrente
    public ContaCorrente(String numero, String titular, double saldoInicial) {
        super(numero, titular, saldoInicial);
    }

    // Sobrescreve o método sacar para incluir a taxa de operação
    @Override
    public void sacar(double valor) throws ExecaoSaldoInsuficiente {
        // Calcula o valor total com a taxa
        double valorComTaxa = valor + (valor * taxaOperacao);

        if (valorComTaxa > getSaldo()) {
            throw new ExecaoSaldoInsuficiente("Saldo insuficiente para realizar o saque com taxa!");
        }

        // Desconta o valor com taxa do saldo
        setSaldo(getSaldo() - valorComTaxa);
        System.out.println("Saque de R$ " + valor + " realizado (taxa: R$ " + (valor * taxaOperacao) + ")");
    }

    // Implementa o método abstrato atualizarSaldo
    @Override
    public void atualizarSaldo() {
        // Conta corrente não tem atualização automática de saldo
        System.out.println("Conta Corrente não possui atualização automática de saldo.");
    }

    // Implementa o método transferir da interface
    @Override
    public void transferir(Conta destino, double valor) throws Exception {
        if (valor <= 0) {
            System.out.println("Valor de transferência inválido!");
            return;
        }

        // Calcula o valor com taxa
        double valorComTaxa = valor + (valor * taxaOperacao);

        if (valorComTaxa > getSaldo()) {
            throw new ExecaoSaldoInsuficiente("Saldo insuficiente para transferência!");
        }

        // Retira da conta origem
        setSaldo(getSaldo() - valorComTaxa);

        // Deposita na conta destino
        destino.depositar(valor);

        System.out.println("Transferência de R$ " + valor + " realizada (taxa: R$ " + (valor * taxaOperacao) + ")");
    }

    // Implementa o método imprimirExtrato da interface
    @Override
    public void imprimirExtrato() {
        System.out.println("========== EXTRATO CONTA CORRENTE ==========");
        System.out.println("Número da Conta: " + getNumero());
        System.out.println("Titular: " + getTitular());
        System.out.println("Saldo Atual: R$ " + getSaldo());
        System.out.println("Taxa de Operação: " + (taxaOperacao * 100) + "%");
        System.out.println("==========================================");
    }
}
