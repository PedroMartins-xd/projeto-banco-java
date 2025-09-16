package view;

import exceptions.SaldoNaoZeradoException;
import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import model.Banco;
import exceptions.SaldoInsuficienteException;
import exceptions.ValorInvalidoException;

public class Main {

    public static void main(String[] args) {

        // Criando o banco
        Banco banco = new Banco("Banco do Pedro");

        // Criando clientes
        Cliente pedro = new Cliente();
        pedro.setNome("Pedro");

        Cliente ana = new Cliente();
        ana.setNome("Ana");

        // Criando contas para os clientes
        ContaCorrente ccPedro = new ContaCorrente(pedro);
        ContaPoupanca poupancaPedro = new ContaPoupanca(pedro);
        Conta ccAna = new ContaCorrente(ana);

        // Adicionando contas ao banco
        banco.adicionarConta(ccPedro);
        banco.adicionarConta(poupancaPedro);
        banco.adicionarConta(ccAna);

        try {
            // Depósitos iniciais
            ccPedro.depositar(500);
            poupancaPedro.depositar(1000);
            ccAna.depositar(300);

            // Transferência
            ccPedro.transferir(200, poupancaPedro);

            // Saque usando cheque especial
            ccPedro.limiteChequeEspecial(400); // saldo negativo

            // Aplicando juros do cheque especial
            ccPedro.aplicarJurosChequeEspecial();

            // Render juros da poupança
            double juros = poupancaPedro.renderJuros();
            poupancaPedro.depositar(juros);

            // Imprimindo extratos
            System.out.println("=== Extrato Pedro Conta Corrente ===");
            ccPedro.imprimirExtrato();

            System.out.println("=== Extrato Pedro Poupança ===");
            poupancaPedro.imprimirExtrato();

            System.out.println("=== Extrato Ana Conta Corrente ===");
            ccAna.imprimirExtrato();

            // Mostrando resumo do banco
            System.out.println("=== Resumo do Banco ===");
            banco.imprimirResumo();

        } catch (SaldoInsuficienteException | ValorInvalidoException |
                 SaldoNaoZeradoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
