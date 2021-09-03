package SistemaBancario;

import java.util.ArrayList;

public class Pessoa{


    public String nome;
    public String sobrenome;
    public int idade;
    final private String cpf;
    final private ArrayList<ContaBancaria> contasBancarias;

    public Pessoa(String nome,String sobrenome,int idade,String cpf) {

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.cpf = cpf;
        contasBancarias = new ArrayList<>();
    }


    public String retornaNome() {

        return nome;
    }

    public int retornaIdade() {

        return idade;
    }

    public String retornaSobrenome() {

        return sobrenome;
    }

    public ArrayList<ContaBancaria> retornaContas() {

        return contasBancarias;
    }


    public String retornaCpf() {

        return cpf;
    }


    public void infoPessoas() {
        System.out.println("\n===Info da pessoa:");
        System.out.print("-----------------------------------------");
        System.out.println("\nNome: " + retornaNome() + "\nSobrenome: " + retornaSobrenome() + "\nIdade: " +
                retornaIdade() + "\nCPF: " + retornaCpf());
        System.out.print("-----------------------------------------");
    }

    public void infoContas() {
        int contador = 1;
        for(ContaBancaria conta: contasBancarias) {

            System.out.println("===Conta " + contador);
            conta.info();
            contador++;
        }
    }


    public void addContas(ContaBancaria conta) {

        contasBancarias.add(conta);
    }


}
