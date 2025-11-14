package modelos;

import excecoes.ExecaoSaldoInsuficiente;
import interfaces.OperacoesBancarias;

// Classe que representa uma conta poupança
public class ContaPoupanca extends Conta implements OperacoesBancarias {

    // Rendimento mensal (0.3%)
    private double rendimentoMensal = 0.003;

    // Construtor da conta poupança
    public ContaPoupanca(String numero, String titular, double saldoInicial) {
        super(numero, titular, saldoInicial);
    }

    // Implementa o método abstrato atualizarSaldo
    @Override
    public void atualizarSaldo() {
        // Calcula o rendimento
        double rendimento = getSaldo() * rendimentoMensal;

        // Atualiza o saldo com o rendimento
        setSaldo(getSaldo() + rendimento);

        System.out.println("Saldo atualizado! Rendimento: R$ " + rendimento);
    }

    // Implementa o método transferir da interface
    @Override
    public void transferir(Conta destino, double valor) throws Exception {
        if (valor <= 0) {
            System.out.println("Valor de transferência inválido!");
            return;
        }

        if (valor > getSaldo()) {
            throw new ExecaoSaldoInsuficiente("Saldo insuficiente para transferência!");
        }

        // Retira da conta origem
        setSaldo(getSaldo() - valor);

        // Deposita na conta destino
        destino.depositar(valor);

        System.out.println("Transferência de R$ " + valor + " realizada com sucesso!");
    }

    // Implementa o método imprimirExtrato da interface
    @Override
    public void imprimirExtrato() {
        System.out.println("========== EXTRATO CONTA POUPANÇA ==========");
        System.out.println("Número da Conta: " + getNumero());
        System.out.println("Titular: " + getTitular());
        System.out.println("Saldo Atual: R$ " + getSaldo());
        System.out.println("Rendimento Mensal: " + (rendimentoMensal * 100) + "%");
        System.out.println("==========================================");
    }
}
