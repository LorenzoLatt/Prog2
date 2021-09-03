package SistemaBancario;
import java.util.ArrayList;

public class Banco {


    final private String nome;
    final private String cnpj;
    final private int numeroBanco;
    final private ArrayList<ContaBancaria> contasBancarias;


    public Banco(String nome, String cnpj, int numeroBanco) {

        this.nome = nome;
        this.cnpj = cnpj;
        this.numeroBanco = numeroBanco;
        contasBancarias = new ArrayList<>();
    }

    public ArrayList<ContaBancaria> retornaContas() {

        return contasBancarias;
    }

    public String retornaNome() {

        return nome;
    }

    public String retornaCNPJ() {

        return cnpj;
    }

    public int retornaNumeroBanco() {

        return numeroBanco;
    }


    public void info() {
        System.out.println("\nInfo do banco:");
        System.out.println("------------------------");
        System.out.println("\nNome do banco: " + retornaNome() + "\nCNPJ: " + retornaCNPJ() + "\nNúmero do banco: "
                + retornaNumeroBanco());
        System.out.println("------------------------");
    }

    public void addContas(ContaBancaria conta) {

        contasBancarias.add(conta);
    }

    public void infoContas() { // Sim, redudante, porém decidi usar instanceof por causa do sysout("tipo de conta");
        int contador = 1;
        for(ContaBancaria conta: contasBancarias) {
            if(conta instanceof ContaCorrente) {
                System.out.println("===\nConta " + contador);
                conta.info();
                System.out.println("Tipo de conta: Corrente");
                contador++;
            } else if(conta instanceof ContaPoupanca) {
                System.out.println("===\nConta " + contador);
                conta.info();
                System.out.println("Tipo de conta: Poupança");
                contador++;
            }
        }
    }

}
