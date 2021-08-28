package SistemaBancario;
import java.util.Scanner;
public class bancoMain {


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        ListaPessoas pessoas = new ListaPessoas();
        ListaBancos bancos = new ListaBancos();
        int contador;

        do{

            System.out.println("\n1->Cadastrar novo usuário");
            System.out.println("2->Consulta usuários");
            System.out.println("3->Cadastrar novo banco");
            System.out.println("4->Consulta bancos");
            System.out.println("5->Cadastrar nova conta corrente");
            System.out.println("6->Cadastrar nova conta poupança");
            System.out.println("7->Consulta conta corrente");
            System.out.println("8->Conulsta conta poupança");
            System.out.println("9->Informação das senhas cadastradas");
            System.out.println("10->Verificação de senha");
            System.out.println("11->Depositar na conta");
            System.out.println("12->Sacar da conta");
            System.out.println("13->Sacar da conta poupança");
            System.out.println("0->Encerrar programa!!!");

            System.out.println("\nO que você deseja consultar?");
            contador = sc.nextInt();
            sc.nextLine();

            switch(contador) {

                case 1 -> {

                    System.out.println("Informe nome, sobrenome, cpf e idade do usuário");
                    String nome = sc.nextLine();
                    String sobrenome = sc.nextLine();
                    String cpf = sc.nextLine();
                    int idade = sc.nextInt();

                    pessoas.contadorPessoas++;
                    pessoas.addPessoas(new Pessoa(nome,sobrenome,idade,cpf));

                }

                case 2 -> {

                    if(pessoas.contadorPessoas == 0) {

                        System.out.println("Não há pessoas cadastradas ainda no sistema");
                    } else {

                        pessoas.info();

                    }

                }

                case 3 -> {

                    System.out.println("Informe o nome do banco, CNPJ e o número do banco");
                    String nomeBanco = sc.nextLine();
                    String cnpj = sc.nextLine();
                    int numeroBanco = sc.nextInt();

                    bancos.addContasBanco(new Banco(nomeBanco,cnpj,numeroBanco));
                    bancos.contadorBancos++;

                }

                case 4 -> {
                    if(bancos.contadorBancos == 0) {

                        System.out.println("Nenhum banco cadastrado ainda");
                    } else {
                        bancos.info();
                    }
                }

                case 5 -> {
                    if(pessoas.contadorPessoas == 0 || bancos.contadorBancos == 0) {

                        System.out.println("Não há informações suficientes para cadastro ainda");
                    } else {
                        System.out.println("Informe a senha da conta, número da conta" +
                                " e o saldo atual do cliente " + pessoas.retornaPessoa().nome);
                        String senha = sc.nextLine();
                        int numeroConta = sc.nextInt();
                        double saldoAtual = sc.nextDouble();


                        ContaCorrente conta = new ContaCorrente(pessoas.retornaPessoa(), bancos.retornaBanco(),
                                numeroConta, saldoAtual, senha, 0.03);

                        pessoas.addContasCorrentes(conta);
                    }
                }

                case 6 -> {
                    if(pessoas.contadorPessoas == 0 && bancos.contadorBancos == 0) {

                        System.out.println("Não é possível fazer o cadastro ainda");
                    } else {
                        System.out.println("Qual o nome do cliente que deseja abrir uma conta poupança?");
                        String nome = sc.nextLine();
                        pessoas.info();
                        System.out.println("Qual o número da conta?");
                        int numeroConta = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Qual a senha da conta?");
                        String senha = sc.nextLine();
                        System.out.println("Qual o saldo da conta?");
                        double saldo = sc.nextDouble();
                        for (int i = 0; i < pessoas.retornaListaContasCorrente().size(); i++) {

                            if (nome.equals(pessoas.retornaListaContasCorrente().get(i).titular.nome)) {

                                ContaPoupanca conta = new ContaPoupanca(pessoas.retornaListaContasCorrente().get(i).titular,
                                        pessoas.retornaListaContasCorrente().get(i).banco, numeroConta, saldo, 0.05, senha,
                                        10);

                                bancos.addContasPoupanca(conta);
                                pessoas.addContasPoupanca(conta);
                                break;
                            }
                        }

                        pessoas.infoContasPoupanca();
                    }
                }

                case 7 -> {
                    System.out.println("\n===Informações com saldo atual");
                    pessoas.infoContas();
                    System.out.println("\n===Informações com saldo das contas ao fim do mês");
                    ContaCorrente.novoMes(pessoas);
                    pessoas.infoContas();
                }

                case 8 -> {

                    pessoas.infoContasPoupanca();
                    ContaPoupanca.novoMes(pessoas);
                }

                case 9 -> ContaCorrente.verificaSenha(pessoas);

                case 10 -> {

                    System.out.println("Qual senha você deseja verificar se está cadastrada?");
                    String senha = sc.nextLine();
                    if(ContaCorrente.verificaSenha(senha,pessoas)) {

                        System.out.println("Senha cadastrada");
                    } else {

                        System.out.println("Senha não cadastrada");
                    }

                }

                case 11 -> {

                    System.out.println("Para quem você deseja depositar?");
                    String nome = sc.nextLine();

                    ContaCorrente.deposito();
                    double dinheiro = sc.nextDouble();
                    ContaCorrente.deposito(dinheiro,pessoas,nome);

                }

                case 12 -> {
                    System.out.println("Quem deseja sacar o dinheiro?");
                    String nome = sc.nextLine();
                    ContaCorrente.verificaSenha(pessoas);
                    System.out.println("Informe a senha para realizar o saque");
                    String senha = sc.nextLine();
                    if(!ContaCorrente.verificaSenha(senha,pessoas)) {

                        System.out.println("Senha incorreta!");
                    } else {
                        ContaCorrente.saque();
                        double dinheiro = sc.nextDouble();
                        ContaCorrente.saque(dinheiro, pessoas, nome);
                    }
                }

                case 13 -> {

                    System.out.println("Qual o nome do cliente que deseja sacar o dinheiro?");
                    String nome = sc.nextLine();
                    ContaPoupanca.saque();
                    double dinheiro = sc.nextDouble();
                    ContaPoupanca.saque(bancos,dinheiro,nome);

                }

            }
        }while(contador != 0);
    }
}
