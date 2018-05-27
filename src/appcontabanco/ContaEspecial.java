package appcontabanco;

public class ContaEspecial extends ContaCorrente {

    private String nomeDoGerente;

    public String getNomeDoGerente() {
        return nomeDoGerente;
    }

    public void setNomeDoGerente(String nomeDoGerente) {
        this.nomeDoGerente = nomeDoGerente;
    }

    public ContaEspecial(String nomeCliente, int numeroConta, String cpf, String nomeDoGerente) {
        super(nomeCliente, numeroConta, cpf);
        setNomeDoGerente(nomeDoGerente);
    }

    public ContaEspecial(String nomeCliente, int numeroConta, String cpf, double limite, String nomeDoGerente) {
        super(nomeCliente, numeroConta, cpf, limite);
        setNomeDoGerente(nomeDoGerente);
    }

    @Override
    public String imprimir() {
        return super.imprimir() + "\nNome do Gerente: " + this.nomeDoGerente;
    }
}
