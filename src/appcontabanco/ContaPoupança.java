package appcontabanco;

public class ContaPoupança extends Conta {

    public ContaPoupança(String nomeCliente, int numeroConta, String cpf) {
        super(numeroConta, nomeCliente, cpf);
    }

    public void calculaRendimento(double porcentagem) {
        super.setSaldo(super.getSaldo() + ((super.getSaldo() * porcentagem) / 100));
    }
}
