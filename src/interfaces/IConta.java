package interfaces;

import model.Conta;

public interface IConta {

    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, Conta contaDestino);

    void imprimirExtrato();

    void abirConta();

    void fecharConta();

    void pagarConta(double valor);

    void consultarSaldo();

    void pagarConta();
}
