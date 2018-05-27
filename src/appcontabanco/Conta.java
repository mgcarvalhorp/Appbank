package appcontabanco;

public abstract class Conta {

    private String nomeCliente, cpf;
    private double saldo;
    private int numeroConta;
    

    public int getNumeroConta() {
        return numeroConta;
    }

    protected void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    protected void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Conta(int numeroConta, String nomeCliente, String cpf) {
        setNumeroConta(numeroConta);
        setNomeCliente(nomeCliente);
        setCpf(cpf);
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            return true;
        } else {
            return false;
        }
    }

    public String imprimir() {
        return "\nNome: " + nomeCliente
                + "\nNumero da conta: " + numeroConta
                + "\nCPF: " + cpf
                + "\nSaldo: " + saldo;
    }
}
