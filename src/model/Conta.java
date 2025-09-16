package model;
import exceptions.SaldoInsuficienteException;
import exceptions.SaldoNaoZeradoException;
import exceptions.ValorInvalidoException;
import interfaces.IConta;

public abstract class Conta implements IConta {
    // Força as classes filhas a serem instanciadas

    private static final int AGENCIA_PADRAO = 0001;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected boolean contaCriada;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.contaCriada = false;
    }

    public boolean isContaCriada() {
        return contaCriada;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public void abirConta() {
        if (this.contaCriada) {
            this.contaCriada = true;
            System.out.println("Conta criada!");
        } else {
            System.out.println("Erro! A conta ja foi criada");
        }
    }

    @Override
    public void fecharConta() {
        if (this.contaCriada == true) {
            if (this.getSaldo() == 0) {
                this.contaCriada = false;
                System.out.println("Conta encerrada com sucesso.");
            } else {
                throw new SaldoNaoZeradoException("Não é possível encerrar a conta:" +
                        " saldo deve estar zerado.");
            }
        } else {
            System.out.println("Não existe uma conta");
        }
    }

    @Override
    public void sacar(double valor) {
        if (valor > this.saldo) {
            throw new SaldoInsuficienteException(
                    "Saldo insuficiente! Tentativa de saque: R$" + valor +
                            " | Saldo disponível: R$" + this.saldo
            );
        }

        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new ValorInvalidoException(
                    "Depósito deve ser maior que zero"
            );
        }

        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void pagarConta(double valor) {
        if (valor > this.saldo) {
            throw new SaldoInsuficienteException(
                    "Saldo insuficiente! Tentativa de pagamento: R$" + valor
                            + " | Saldo disponível: R$" + this.saldo
            );
        }

        saldo -= valor;
        System.out.println("Conta Paga com sucesso.");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Saldo atual: R$" + getSaldo());
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
