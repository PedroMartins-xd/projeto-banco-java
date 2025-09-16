package model;

import exceptions.SaldoInsuficienteException;

public class ContaCorrente extends Conta {

    private double valorCheque = 1000;
    private final double JUROSMENSAL = 0.10;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    public void limiteChequeEspecial(double valorGasto) {
        if (valorGasto <= this.getSaldo() + this.valorCheque) {
            if (valorGasto > this.getSaldo()) {
                this.saldo -= valorGasto;
                System.out.println("Saldo negativo: R$" + this.saldo +
                        " (utilizando cheque especial)");
            } else {
                this.saldo -= valorGasto;
                System.out.println("O saldo atual é de: R$" + this.saldo);
            }
        } else {
            throw new SaldoInsuficienteException(
                    "Saldo insuficiente! R$" + valorGasto +
                            " | Saldo disponível: R$" + this.saldo);
        }
    }

    public void aplicarJurosChequeEspecial() {
        if (this.getSaldo() < 0) {
            double calculoJuros = Math.abs(saldo) * JUROSMENSAL;
            this.saldo -= calculoJuros;
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
    }

    @Override
    public void pagarConta() {

    }
}
