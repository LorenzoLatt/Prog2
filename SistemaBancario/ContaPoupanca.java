package SistemaBancario;

public class ContaPoupanca extends ContaBancaria{

    public static int contadorSaques = 0;
    final private double rendimento;
    private int saquesMensais;


    public ContaPoupanca(Pessoa pessoa, Banco banco, int numeroConta, double saldo, double rendimento, String senha,  int saquesMensais) {

        this.titular = pessoa;
        this.banco = banco;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.rendimento = rendimento;
        this.senha = senha;
        this.saquesMensais = saquesMensais;
    }

    public double retornaRendimento() {

        return rendimento*100;
    }

    public int retornaSaquesMensais() {

        return saquesMensais;
    }

    public static void novoMes(ListaPessoas listaPessoas){
        for(int i = 0; i < listaPessoas.retornaListaContasPoupanca().size(); i++) {

            listaPessoas.retornaListaContasPoupanca().get(i).saldo += listaPessoas.retornaListaContasPoupanca().get(i).
                    retornaRendimento();

            listaPessoas.retornaListaContasPoupanca().get(i).saquesMensais = 3;
        }

    }

    public static void saque() {

        System.out.println("Quanto você deseja retirar da conta?");

    }
    public static void saque(ListaBancos listaBancos,double dinheiro,String nome){

        if(contadorSaques == 3) {

            System.out.println("Não há mais saques disponíveis");
        } else {

            for(int i = 0; i < listaBancos.retornaListaContasPoupanca().size(); i++) {

                if(listaBancos.retornaListaContasPoupanca().get(i).titular.nome.equals(nome)) {

                    listaBancos.retornaListaContasPoupanca().get(i).saldo -= dinheiro;
                    break;
                }
            }

            contadorSaques--;
        }
    }


}
