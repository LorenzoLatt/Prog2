package SistemaBancario;
import java.util.ArrayList;

public class ListaPessoas {

    public int contadorPessoas = 0;
    final private ArrayList<Pessoa> pessoas;
    final private ArrayList<ContaCorrente> contasCorrentes = new ArrayList<>();
    final private ArrayList<ContaPoupanca> contasPoupanca = new ArrayList<>();

    public ListaPessoas() {

        pessoas = new ArrayList<>();
    }

    public void addPessoas(Pessoa pessoa) {

        pessoas.add(pessoa);
    }

    public void addContasCorrentes(ContaCorrente conta) {

        contasCorrentes.add(conta);
    }

    public void addContasPoupanca(ContaPoupanca conta) {

        contasPoupanca.add(conta);
    }

    public ArrayList<ContaCorrente> retornaListaContasCorrente() {

        return contasCorrentes;
    }

    public ArrayList<ContaPoupanca> retornaListaContasPoupanca() {

        return contasPoupanca;
    }


    public void info() {

        for (Pessoa pessoa : pessoas) {
            System.out.println("\nNome: " + pessoa.nome.toUpperCase() + "\nSobrenome: " +
                    pessoa.sobrenome.toUpperCase() + "\nIdade: " +
                    pessoa.idade + "\nCPF: " + pessoa.retornaCpf());
        }
    }


    public Pessoa retornaPessoa() {

        return pessoas.get(contadorPessoas - 1);

    }

    public void infoContas() {

        for (ContaBancaria conta : contasCorrentes) {

            System.out.println("\nTitular: " + conta.titular.nome + "\nBanco: " + conta.banco.retornaNome() + "\nNúmero da conta: " +
                    conta.numeroConta + "\nSaldo disponível: " + conta.saldo + "\nSenha: " + conta.senha);
        }
    }

    public void infoContasPoupanca() {

        for(ContaPoupanca conta: contasPoupanca) {

            System.out.println("\nTitular: " + conta.titular.nome + "\nBanco: " + conta.banco.retornaNome() + "\nNúmero da conta: " +
                    conta.numeroConta + "\nSaldo disponível: " + conta.saldo + "\nSenha: " + conta.senha + "\nRendimento: " +
                    conta.retornaRendimento() +"%" + "\nNro de saques mensais disponíveis: " + conta.retornaSaquesMensais());
        }

    }

}