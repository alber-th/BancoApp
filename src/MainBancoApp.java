import modelos.Conta;
import modelos.ContaCorrente;
import modelos.ContaPoupanca;
import excecoes.ExecaoSaldoInsuficiente;

// Classe principal do sistema bancário
public class MainBancoApp {

    public static void main(String[] args) {

        System.out.println("=== SISTEMA DE GESTÃO BANCÁRIA ===\n");

        // Criar conta corrente
        ContaCorrente cc1 = new ContaCorrente("1001", "João Silva", 1000.0);

        // Criar conta poupança
        ContaPoupanca cp1 = new ContaPoupanca("2001", "Maria Santos", 2000.0);

        System.out.println("--- Contas Criadas ---");
        cc1.imprimirExtrato();
        System.out.println();
        cp1.imprimirExtrato();
        System.out.println();

        // Teste1: Depósito
        System.out.println("--- TESTE 1: Depósitos ---");
        cc1.depositar(500.0);
        cp1.depositar(300.0);
        System.out.println();

        // Teste2: Saque normal
        System.out.println("--- TESTE 2: Saques ---");
        try {
            cc1.sacar(200.0);
            cp1.sacar(100.0);
        } catch (ExecaoSaldoInsuficiente e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println();

        // Teste3: Saque saldo insuficiente
        System.out.println("--- TESTE 3: Saque com Saldo Insuficiente ---");
        try {
            cc1.sacar(5000.0);
        } catch (ExecaoSaldoInsuficiente e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println();

        // Teste4: Transferência
        System.out.println("--- TESTE 4: Transferência ---");
        try {
            cp1.transferir(cc1, 400.0);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println();

        // Teste5: Transferência com saldo insuficiente
        System.out.println("--- TESTE 5: Transferência com Saldo Insuficiente ---");
        try {
            cc1.transferir(cp1, 10000.0);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println();

        // Teste6: Atualizar saldo (rendimento)
        System.out.println("--- TESTE 6: Atualização de Saldo ---");
        cp1.atualizarSaldo();
        cc1.atualizarSaldo();
        System.out.println();

        // Extrato final
        System.out.println("--- EXTRATOS FINAIS ---");
        cc1.imprimirExtrato();
        System.out.println();
        cp1.imprimirExtrato();
    }
}
