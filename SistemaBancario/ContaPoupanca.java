package SistemaBancario;
import java.util.Scanner;

public class ContaPoupanca extends ContaBancaria{

    final private double rendimento;
    private int saquesMensais;
    Scanner sc = new Scanner(System.in);


    public ContaPoupanca(Pessoa pessoa, Banco banco, int numeroConta, double saldo,String senha) {

        this.titular = pessoa;
        this.banco = banco;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.rendimento = 0.05;
        this.senha = senha;
        this.saquesMensais = 3;
    }

    public double retornaRendimento() {

        return rendimento*100;
    }

    public int retornaSaquesMensais() {

        return saquesMensais;
    }

    public void novoMes(){

        saquesMensais = 3;
        this.saldo += retornaRendimento();
        System.out.println("===Mês antigo");
        System.out.println("------------------");
        info();
        System.out.println("===Novo mês");
        info();
        System.out.println("------------------");
    }

    public void saque() {
        if (retornaSaquesMensais() == 0) {

            System.out.println("Não há mais saques disponíveis para este mês");
        } else {
            System.out.println("Quanto você deseja retirar da conta?");
            double dinheiro = sc.nextDouble();
            if(dinheiro < 0) {

                System.out.println("Valor inválido");
            } else {

                saque(dinheiro);
                saquesMensais--;
            }
        }
    }

    public void saque(double dinheiro){

         this.saldo -= dinheiro;
    }

    public void info() {

        System.out.println("\nNome do titular: " + retornaTitular().nome + "\nNome do banco: " + this.banco.retornaNome() +
                "\nNúmero da conta: " + retornaNumeroConta() + "\nSaldo disponível: " +
                retornaSaldo() + "\nSenha do usuário: "
                + retornaSenha() +  "\nRendimento mensal: " + retornaRendimento() +"%" + "\nSaques mensais disponíveis: " +
                retornaSaquesMensais());
    }


}
