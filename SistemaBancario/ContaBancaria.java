package SistemaBancario;
import java.util.Scanner;

public abstract class ContaBancaria{

    protected int numeroConta;
    protected double saldo;
    protected String senha;
    protected Pessoa titular;
    protected Banco banco;
     Scanner sc = new Scanner(System.in);

    public String retornaSenha() {

        return senha;
    }

    public int retornaNumeroConta() {

        return numeroConta;
    }

    public double retornaSaldo() {

        return saldo;
    }

    public Pessoa retornaTitular() {

        return titular;
    }


    public Banco retornaBanco() {

        return banco;
    }



    public void saque() {

        System.out.println("Quanto você gostaria de sacar?");
        double dinheiro = sc.nextDouble();
        if(dinheiro < 0) {

            System.out.println("Valor inválido");
        } else {
            sc.nextLine();

            if (verificaSenha()) {

                this.saldo -= dinheiro;
                System.out.println("===Nova info da conta");
                info();
            }
        }

    }
    public void deposito() {

        System.out.println("\nQuanto você gostaria de depositar?");
        double dinheiro = sc.nextDouble();
        if(dinheiro < 0) {

            System.out.println("Valor inválido");
        } else {
            deposito(dinheiro);
            System.out.println("==Nova info da conta");
            info();
        }
    }

    public void deposito(double dinheiro) {

         this.saldo += dinheiro;
    }


    public boolean verificaSenha() {

        System.out.println("Qual a senha da conta?");
        String senha = sc.nextLine();
        if(verificaSenha(senha)){

            return true;
        } else {

            System.out.println("Senha incorreta");

            return false;
        }
    }

    public boolean verificaSenha(String senha) {

        return senha.equals(this.senha);
    }

    public abstract void info();

    public abstract void novoMes();
}
