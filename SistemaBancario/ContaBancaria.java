package SistemaBancario;

public abstract class ContaBancaria {

    protected int numeroConta;
    protected double saldo;
    protected String senha;
    protected Pessoa titular;
    protected Banco banco;

    public String retornaSenha() {

        return senha;
    }
    public static void saque() {

        System.out.println("Quanto você gostaria de sacar?");

    }

    public static void saque(double dinheiro, ListaPessoas listaPessoas, String nome) {

        for(int i = 0; i < listaPessoas.retornaListaContasCorrente().size(); i++) {

            if(listaPessoas.retornaListaContasCorrente().get(i).titular.nome.equals(nome)) {

                listaPessoas.retornaListaContasCorrente().get(i).saldo -= dinheiro;
                break;
            }
        }


    }

    public static void deposito(){

        System.out.println("Quanto você quer depositar?");
    }

    public static void deposito(double dinheiro, ListaPessoas listaPessoas,String nome){

        for(int i = 0; i < listaPessoas.retornaListaContasCorrente().size(); i++) {

            if(listaPessoas.retornaListaContasCorrente().get(i).titular.nome.equals(nome)) {

                listaPessoas.retornaListaContasCorrente().get(i).saldo += dinheiro;
                break;
            }
        }
    }

    public static boolean verificaSenha(String senha,ListaPessoas listaPessoas) {

        for (int i = 0; i < listaPessoas.retornaListaContasCorrente().size(); i++) {

            if (listaPessoas.retornaListaContasCorrente().get(i).retornaSenha().equals(senha)) {

                return true;
            }
        }
        return false;
    }
    public static void verificaSenha(ListaPessoas listaPessoas){

        System.out.println("Informe as senhas dos clientes");

        for(int i = 0; i < listaPessoas.retornaListaContasCorrente().size(); i++) {

            System.out.println("\nNome do cliente: " + listaPessoas.retornaListaContasCorrente().
                    get(i).titular.nome + "\nSenha: " + listaPessoas.retornaListaContasCorrente().get(i).
                    senha);

        }

    }



}
