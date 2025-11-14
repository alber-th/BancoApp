package modelos;

import excecoes.ExecaoSaldoInsuficiente;

// Classe abstrata conta bancária
public abstract class Conta {

    // Atributos privados
    private String numero;
    private String titular;
    private double saldo;

    // Construtor da conta
    public Conta(String numero, String titular, double saldoInicial) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // Método para depositar dinheiro na conta
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo = this.saldo + valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor de depósito inválido!");
        }
    }

    // Método para sacar dinheiro da conta
    public void sacar(double valor) throws ExecaoSaldoInsuficiente {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido!");
            return;
        }

        if (valor > this.saldo) {
            throw new ExecaoSaldoInsuficiente("Saldo insuficiente para realizar o saque!");
        }

        this.saldo = this.saldo - valor;
        System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
    }

    // Método para obter o saldo
    public double getSaldo() {
        return this.saldo;
    }

    // Método para obter o número da conta
    public String getNumero() {
        return this.numero;
    }

    // Método para obter o titular da conta
    public String getTitular() {
        return this.titular;
    }

    // Método para alterar o saldo (protegido para uso nas subclasses)
    protected void setSaldo(double novoSaldo) {
        this.saldo = novoSaldo;
    }

    // Método abstrato que deve ser implementado nas subclasses
    public abstract void atualizarSaldo();
}
