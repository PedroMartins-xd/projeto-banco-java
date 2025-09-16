package model;

import model.Conta;
import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void imprimirResumo() {
        System.out.println("=== Banco: " + nome + " ===");

        for (Conta c : contas) {
            System.out.println("Conta número: " + c.getNumero() +
                    " | Titular: " + c.getCliente().getNome() +
                    " | Saldo: R$" + c.getSaldo());
        }
    }
}
