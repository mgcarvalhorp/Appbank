package appcontabanco;

import java.util.ArrayList;

public class GerenciarContas {

    private ArrayList<Conta> c = new ArrayList<>();

    public void adiciontarConta(Conta C) {
        c.add(C); 
    }

    public boolean removerConta(int numeroConta) {
        boolean b = false;
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i).getNumeroConta() == numeroConta) {
                c.remove(i);
                return true;
            }
        }
        return false;
    }

    public String buscarContasEspeciais() {
        String S = "";
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i) instanceof ContaEspecial) {
                S += c.get(i).imprimir() + "\n" + "\n";
            }
        }
        return S;
    }

    public String buscarClienteUsandoLimite() {
        String S = "";
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i) instanceof ContaCorrente) {
                ContaCorrente CC = (ContaCorrente) c.get(i);
                if (CC.usandoLimite() == true) {
                    S += CC.imprimir();
                }
            }
            if(c.get(i) instanceof ContaEspecial){
                ContaEspecial CE = (ContaEspecial) c.get(i);
                if(CE.usandoLimite() == true){
                    S += CE.imprimir();
                }
            }
        }
        
        return S;
        
        
    }

    public Conta buscarConta(int numeroConta) {
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i).getNumeroConta() == numeroConta) {
                return c.get(i);
            }
        }
        return null;
    }

    public boolean transferirValor(int numeroContaFonte, int numeroContaDestino, double valor) {
        Conta fonte = buscarConta(numeroContaFonte);
        Conta destino = buscarConta(numeroContaDestino);
        if (destino != null && fonte != null) {
            if (fonte.getSaldo() >= valor) {
                destino.setSaldo(destino.getSaldo() + valor);
                fonte.setSaldo(fonte.getSaldo() - valor);
                return true;
            }
        }
        return false;
    }

    public boolean sacar(int numeroConta, double valorSacado) {
        Conta b = buscarConta(numeroConta);
        if (b != null) {
            return b.sacar(valorSacado);
        } else {
            return false;
        }
    }

    public boolean depositar(int numeroConta, double valorDepositado) {
        Conta b = buscarConta(numeroConta);
        if(b != null){
        return b.depositar(valorDepositado);
        }
        else return false;
    }

    public String listarContas() {
        String s = "";
        for (int i = 0; i < c.size(); i++) {
            s += c.get(i).imprimir() + "\n" + "\n";
        }
        return s;
    }
}
