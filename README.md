Funcionalidades

Criação de clientes e contas (corrente e poupança)

Depósitos, saques e transferências entre contas

Uso de cheque especial com saldo negativo

Aplicação de juros em saldo negativo (cheque especial) e rendimentos da poupança

Tratamento de exceções personalizadas (SaldoInsuficienteException, ValorInvalidoException)

Impressão de extratos individuais e resumo do banco

Projeto organizado em pacotes (model, view, interfaces, exceptions)

Estrutura do Projeto
projeto-banco-java/
│
├─ model/          → Classes principais (Conta, ContaCorrente, ContaPoupanca, Banco, Cliente)
├─ view/           → Classe Main com simulação do sistema
├─ interfaces/     → Interface IConta
├─ exceptions/     → Exceções personalizadas
└─ README.md       → Documentação do projeto

Como Executar

Clone o repositório:

git clone [<URL_DO_REPOSITORIO>](https://github.com/PedroMartins-xd/projeto-banco-java)


Abra o projeto em sua IDE Java (IntelliJ, Eclipse ou VS Code com extensão Java).

Execute a classe view.Main para simular o sistema bancário e ver todas as funcionalidades em ação.

Demonstração

Exemplo de execução no console:

=== Extrato Pedro Conta Corrente ===
Saldo: R$300.0
=== Extrato Pedro Poupança ===
Saldo: R$1200.0
=== Extrato Ana Conta Corrente ===
Saldo: R$300.0


Inclua prints reais do seu console aqui para deixar mais visual.

Tecnologias Utilizadas

Java 17+

Orientação a Objetos (POO)

Interfaces e Classes Abstratas

Exceções Personalizadas

Estruturação em Pacotes
