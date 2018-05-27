package appcontabanco;

public class ContaCorrente extends Conta {

    private double limite;

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public ContaCorrente(String nomeCliente, int numeroConta, String cpf) {
        super(numeroConta, nomeCliente, cpf);
    }

    public ContaCorrente(String nomeCliente, int numeroConta, String cpf, double limite) {
        super(numeroConta, nomeCliente, cpf);
        setLimite(limite);
    }

    public boolean usandoLimite() {
        if (super.getSaldo() < 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean sacar(double valor) {
        if(getSaldo() + limite >= valor) {
            setSaldo(getSaldo() - valor);
            return true;
        }
        else return false;
    }

    @Override
    public String imprimir() {
        return super.imprimir() + "\nLimite: " + this.limite;
    }

}
