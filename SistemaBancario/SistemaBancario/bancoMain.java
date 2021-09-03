package SistemaBancario;
import java.util.Scanner;
import java.util.ArrayList;
public class bancoMain {

    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        ArrayList<Banco> bancos = new ArrayList<>();
        int contador;

        do {
            System.out.println("\n1->Cadastro de pessoa");
            System.out.println("2->Info de pessoa");
            System.out.println("3->Cadastro de banco");
            System.out.println("4->Info de banco");
            System.out.println("5->Cadastro de conta corrente");
            System.out.println("6->Cadastro de conta poupança");
            System.out.println("7->Info de contas de um cliente");
            System.out.println("8->Info de todas contas correntes cadastradas num banco");
            System.out.println("9->Sacar de uma conta");
            System.out.println("10->Depositar em uma conta");
            System.out.println("11->Info ao fim do mês da conta");
            System.out.println("12->Fechar conta");
            System.out.println("0->Encerrar o programa!!!");

            System.out.println("\nO que você gostaria de consultar?");
            contador = sc.nextInt();
            sc.nextLine();

            switch(contador) {


                case 1-> {

                    System.out.println("Qual o nome da pessoa?");
                    String nome = sc.nextLine();
                    System.out.println("Qual o sobrenome de " + nome +"?");
                    String sobrenome = sc.nextLine();
                    System.out.println("Qual a idade de " + nome +"?");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Qual o CPF de " + nome + "?");
                    String cpf = sc.nextLine();

                    pessoas.add(new Pessoa(nome,sobrenome,idade,cpf));

                }

                case 2-> {
                    if(pessoas.isEmpty()) {

                        System.out.println("Não há usuário cadastrado no sistema ainda");
                    } else {
                        for (int i = 0; i < pessoas.size(); i++) {

                            pessoas.get(i).infoPessoas();
                        }
                    }

                }

                case 3-> {

                    System.out.println("Qual o nome do banco?");
                    String nomeBanco = sc.nextLine();
                    System.out.println("Qual o CNPJ do banco " + nomeBanco +"?");
                    String cnpj = sc.nextLine();
                    System.out.println("Qual o número do " + nomeBanco + "?");
                    int numeroBanco = sc.nextInt();

                    bancos.add(new Banco(nomeBanco,cnpj,numeroBanco));
                }

                case 4-> {

                    if(bancos.isEmpty()) {

                        System.out.println("Não há banco(s) cadastrado(s) no sistema ainda");
                    } else {

                        for(int i = 0; i< bancos.size(); i++) {

                            bancos.get(i).info();
                        }
                    }

                }
                case 5 -> {
                    if(bancos.isEmpty() || pessoas.isEmpty()) {

                        System.out.println("Informações insuficientes para cadastro");
                    } else {
                        System.out.println("Quem deseja criar uma conta?");
                        String nomePessoa = sc.nextLine();
                        Pessoa pessoa = null;
                        Banco banco = null;

                        for (Pessoa p : pessoas) {

                            if (p.nome.equalsIgnoreCase(nomePessoa)) {

                                pessoa = p;
                                break;
                            }
                        }

                        System.out.println("Em qual banco a pessoa deseja criar?");
                        String nomeBanco = sc.nextLine();

                        for (Banco b : bancos) {

                            if (b.retornaNome().equalsIgnoreCase(nomeBanco)) {

                                banco = b;
                                break;
                            }
                        }


                        if (pessoa == null || banco == null) {

                            System.out.println("Usuário ou banco ainda não foram cadastrados");
                        } else {
                            System.out.println("Qual o número da nova conta?");
                            int numeroConta = sc.nextInt();
                            System.out.println("Qual o saldo disponível na conta?");
                            double saldo = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("Qual senha o usuário deseja cadastrar?");
                            String senha = sc.nextLine();

                            ContaCorrente conta = new ContaCorrente(pessoa, banco, numeroConta, saldo, senha, 0.03);
                            pessoa.addContas(conta);
                            banco.addContas(conta);
                        }
                    }

                }

                case 6-> {

                    if(pessoas.isEmpty() || bancos.isEmpty()) {

                        System.out.println("Não há informações suficientes para cadastro no sistema ainda");
                    } else {
                        Pessoa pessoa = null;
                        Banco banco = null;
                        System.out.println("Quem deseja criar uma conta?");
                        String nomePessoa = sc.nextLine();

                        for (Pessoa p : pessoas) {

                            if (nomePessoa.equalsIgnoreCase(p.nome)) {

                                pessoa = p;
                                break;
                            }
                        }


                        System.out.println("Em qual banco deseja criar?");
                        String nomeBanco = sc.nextLine();


                        for (Banco b : bancos) {

                            if (nomeBanco.equalsIgnoreCase(b.retornaNome())) {

                                banco = b;
                                break;
                            }
                        }


                        if (banco == null || pessoa == null) {

                            System.out.println("Não há usuários ou banco cadastrados com estes nomes");
                        } else {

                            System.out.println("Qual o número da conta?");
                            int numeroConta = sc.nextInt();
                            System.out.println("Qual o saldo disponível na conta?");
                            double saldo = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("Qual a senha que o usuário deseja cadastrar?");
                            String senha = sc.nextLine();

                            ContaPoupanca conta = new ContaPoupanca(pessoa, banco, numeroConta, saldo, senha);
                            pessoa.addContas(conta);
                            banco.addContas(conta);

                        }
                    }

                }


                case 7-> {

                    if(pessoas.isEmpty() || bancos.isEmpty()) {

                        System.out.println("Não há informações suficientes cadastradas no sistema ainda");
                    } else {
                        for (Pessoa p : pessoas) {

                            p.infoPessoas();
                        }

                        System.out.println("\nQuem deseja verificar as contas bancárias atuais?");
                        String nomePessoa = sc.nextLine();
                        for (int i = 0; i < pessoas.size(); i++) {
                            if (nomePessoa.equalsIgnoreCase(pessoas.get(i).nome)) {

                                pessoas.get(i).infoContas();
                            }
                        }
                    }
                }


                case 8-> {

                    if(pessoas.isEmpty() || bancos.isEmpty()) {

                        System.out.println("Não há informações suficientes cadastradas no sistema ainda");
                    } else {
                        for (Banco b : bancos) {

                            b.info();
                        }

                        System.out.println("\nQual nome do banco você deseja consultar?");
                        String nomeBanco = sc.nextLine();

                        for (int i = 0; i < bancos.size(); i++) {

                            if (nomeBanco.equalsIgnoreCase(bancos.get(i).retornaNome())) {

                                bancos.get(i).infoContas();
                            }
                        }
                    }

                }

                case 9->{

                    if(pessoas.isEmpty() || bancos.isEmpty()) {

                        System.out.println("Não é possível realizar a operação");
                    } else {

                        for (Pessoa p : pessoas) {

                            p.infoPessoas();
                        }
                        System.out.println("\nQuem deseja realizar o saque? Informe o nome");
                        String nomePessoa = sc.nextLine();

                        for (int i = 0; i < pessoas.size(); i++) {

                            if (nomePessoa.equalsIgnoreCase(pessoas.get(i).nome)) {

                                pessoas.get(i).infoContas();
                                break;
                            }
                        }
                            System.out.println("\nInforme o número da conta onde deseja realizar o saque");
                            int numeroConta = sc.nextInt();

                            for (int i = 0; i < pessoas.size(); i++) {

                                if (nomePessoa.equalsIgnoreCase(pessoas.get(i).nome)) {

                                    for (int j = 0; j < pessoas.get(i).retornaContas().size(); j++) {
                                        if (numeroConta == pessoas.get(i).retornaContas().get(j).retornaNumeroConta()) {

                                            pessoas.get(i).retornaContas().get(j).saque();
                                            break;
                                        }

                                    }

                                }
                            }
                        }
                    }

                case 10->{
                    if(pessoas.isEmpty() || bancos.isEmpty()) {

                        System.out.println("Não é possível realizar a operação ainda");
                    } else {
                        for (Pessoa p : pessoas) {

                            p.infoPessoas();
                        }
                        System.out.println("\nQuem deseja realizar o depósito? Informe o nome");
                        String nomePessoa = sc.nextLine();

                        for (int i = 0; i < pessoas.size(); i++) {

                            if (nomePessoa.equalsIgnoreCase(pessoas.get(i).nome)) {

                                pessoas.get(i).infoContas();
                                break;
                            }
                        }

                            System.out.println("\nInforme o número da conta onde deseja realizar o depósito");
                            int numeroConta = sc.nextInt();

                            for (int i = 0; i < pessoas.size(); i++) {

                                if (nomePessoa.equalsIgnoreCase(pessoas.get(i).nome)) {

                                    for (int j = 0; j < pessoas.get(i).retornaContas().size(); j++) {
                                        if (numeroConta == pessoas.get(i).retornaContas().get(j).retornaNumeroConta()) {

                                            pessoas.get(i).retornaContas().get(j).deposito();
                                            break;
                                        }

                                    }

                                }
                            }
                        }

                    }


                case 11-> {
                    for(int i = 0; i < pessoas.size(); i++) {

                        for(int j = 0; j < pessoas.get(i).retornaContas().size(); j++) {

                            pessoas.get(i).retornaContas().get(j).novoMes();
                        }
                    }

                }

                case 12-> {
                    if(pessoas.isEmpty() || bancos.isEmpty()) {

                        System.out.println("Não há informações suficientes ainda no sistema");
                    } else {

                        for(Banco b: bancos) {

                            b.info();
                        }
                        System.out.println("Qual o nome do banco que você deseja fechar a conta?");
                        String nomeBanco = sc.nextLine();
                        Banco banco = null;
                        for(int i = 0; i < bancos.size(); i++) {

                            if(bancos.get(i).retornaNome().equalsIgnoreCase(nomeBanco)) {

                                banco = bancos.get(i);
                                break;
                            }
                        }

                        if(banco == null) {

                            System.out.println("Banco inválido");
                        } else {

                            Pessoa pessoa = null;
                            banco.infoContas();
                            System.out.println("\nInforme o número da conta que você deseja fechar");
                            int numeroConta = sc.nextInt();

                            for (int i = 0; i < banco.retornaContas().size(); i++) {

                                if (banco.retornaContas().get(i).retornaNumeroConta() == numeroConta) {

                                    pessoa = banco.retornaContas().get(i).retornaTitular();
                                    banco.retornaContas().remove(banco.retornaContas().get(i));
                                    break;
                                }
                            }

                            if (pessoa == null) {

                                System.out.println("Erro no sistema");
                            } else {

                                for (int i = 0; i < pessoa.retornaContas().size(); i++) {

                                    if(pessoa.retornaContas().get(i).retornaNumeroConta() == numeroConta) {

                                        pessoa.retornaContas().remove(pessoa.retornaContas().get(i));
                                        break;
                                    }
                                }
                            }
                        }
                        System.out.println("Conta removida com sucesso");
                    }
                }

                case 0-> System.out.println("Programa encerrado!!!");
            }

        }while(contador != 0);
    }
}
