package appcontabanco;

import java.util.Scanner;

public class AppContaBanco {

    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);
        GerenciarContas g = new GerenciarContas();
        ContaCorrente CC;
        ContaEspecial CE;
        ContaPoupança CP;
        int opção;

        do {
            System.out.println("\nSelecione uma das opções abaixo: ");
            System.out.println("1 - Adicionar uma conta:");
            System.out.println("2 - Remover uma conta:");
            System.out.println("3 - Buscar conta especial");
            System.out.println("4 - Buscar clientes pelo limte da conta:");
            System.out.println("5 - Buscar conta:");
            System.out.println("6 - Transferir para uma outra conta:");
            System.out.println("7 - Sacar:");
            System.out.println("8 - Depositar:");
            System.out.println("9 - Listar contas:");
            System.out.println("10 - Sair!\n");

            opção = e.nextInt();

            switch (opção) {
                case 1:
                    System.out.println("\nDigite qual tipo de conta você deseja adicionar:");
                    System.out.println("1 - Conta Corrente");
                    System.out.println("2 - Conta Especial");
                    System.out.println("3 - Conta Poupança");
                    System.out.println("4 - Voltar!\n");
                    int op = e.nextInt();
                    e.nextLine();
                    if (op == 1) {
                        System.out.println("\nDigite seu nome: ");
                        String nomeCC = e.nextLine();
                        System.out.println("Digite o número da conta: ");
                        int numeroCC = e.nextInt();
                        e.nextLine();
                        System.out.println("Digite o CPF: ");
                        String cpfCC = e.nextLine();
                        System.out.println("Se souber, digite o limite, caso contrario, digite 0:");
                        double limiteCC = e.nextDouble();
                        if (limiteCC == 0) {
                            CC = new ContaCorrente(nomeCC, numeroCC, cpfCC);
                            g.adiciontarConta(CC);
                            System.out.println("Conta adicionada!\n");
                            break;
                        } else {
                            CC = new ContaCorrente(nomeCC, numeroCC, cpfCC, limiteCC);
                            g.adiciontarConta(CC);
                            System.out.println("Conta adicionada!\n");
                            break;
                        }
                    } else if (op == 2) {
                        System.out.println("\nDigite seu nome: ");
                        String nomeCE = e.nextLine();
                        System.out.println("Digite o número da conta: ");
                        int numeroCE = e.nextInt();
                        e.nextLine();
                        System.out.println("Digite o CPF: ");
                        String cpfCE = e.nextLine();
                        System.out.println("Digite o nome do gerente:");
                        String gerenteCE = e.nextLine();
                        System.out.println("Se souber, digite o limite, caso contrario, digite 0:");
                        double limiteCE = e.nextDouble();
                        if (limiteCE == 0) {
                            CE = new ContaEspecial(nomeCE, numeroCE, cpfCE, gerenteCE);
                            g.adiciontarConta(CE);
                            System.out.println("Conta adicionada!\n");
                            break;
                        } else {
                            CE = new ContaEspecial(nomeCE, numeroCE, cpfCE, limiteCE, gerenteCE);
                            g.adiciontarConta(CE);
                            System.out.println("Conta adicionada!\n");
                            break;
                        }
                    } else if (op == 3) {
                        System.out.println("\nDigite seu nome: ");
                        String nomeCP = e.nextLine();
                        System.out.println("Digite o número da conta: ");
                        int numeroCP = e.nextInt();
                        e.nextLine();
                        System.out.println("Digite o CPF: ");
                        String cpfCP = e.nextLine();
                        CP = new ContaPoupança(nomeCP, numeroCP, cpfCP);
                        g.adiciontarConta(CP);
                        System.out.println("Conta adicionada!\n");
                        break;

                    } else {
                        break;
                    }

                case 2:
                    System.out.println("\nDigite o numero da conta que deseja remover:");
                    int numero = e.nextInt();
                    System.out.println(g.removerConta(numero));
                    break;

                case 3:
                    System.out.println(g.buscarContasEspeciais());
                    break;

                case 4:
                    System.out.println(g.buscarClienteUsandoLimite());
                    break;

                case 5:
                    System.out.println("\nDigite o numero da conta:");
                    int num = e.nextInt();
                    System.out.println(g.buscarConta(num));
                    break;

                case 6:
                    System.out.println("\nDigite o numero da sua conta:");
                    int contaFonte = e.nextInt();
                    System.out.println("Digite o numero da conta destino:");
                    int contaDestino = e.nextInt();
                    System.out.println("Digite o valor a ser transferido:");
                    double vTrans = e.nextDouble();
                    System.out.println(g.transferirValor(contaFonte, contaDestino, vTrans));
                    break;

                case 7:
                    System.out.println("\nDigite o numero da conta:");
                    int nConta = e.nextInt();
                    System.out.println("Digite o valor a ser sacado:");
                    double valorSacado = e.nextDouble();
                    System.out.println(g.sacar(nConta, valorSacado));
                    break;

                case 8:
                    System.out.println("\nDigite o numero da conta a ser depositado:");
                    int numConta = e.nextInt();
                    System.out.println("Digite o valor a ser depositado:");
                    double valorDepo = e.nextDouble();
                    System.out.println(g.depositar(numConta, valorDepo));
                    break;

                case 9:
                    System.out.println(g.listarContas());
                    break;

                case 10:
                    System.out.println("\nSaindo!");
                    break;

                default:
                    System.out.println("\nOpção inválida!");

            }

        } while (opção != 10);
    }

}
