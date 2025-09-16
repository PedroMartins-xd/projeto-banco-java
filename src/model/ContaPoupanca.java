package model;

public class ContaPoupanca extends Conta {

    private static final double RENDIMENTO = 0.01;

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public double renderJuros() {
        double juros = this.getSaldo() * RENDIMENTO;
        this.saldo += juros;
        System.out.println("Rendimento Aplicado: R$" + juros);
        System.out.println("Novo Saldo: R$" + this.saldo);
        return juros;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
    }

    @Override
    public void pagarConta() {

    }
}
