package SistemaBancario;

public class ContaCorrente extends ContaBancaria{


    final private double taxasMensais;

    public double retornaTaxasMensais() {

        return taxasMensais*100;
    }

    public ContaCorrente(Pessoa pessoa, Banco banco, int numeroConta, double saldo, String senha, double taxasMensais) {

        this.titular = pessoa;
        this.banco = banco;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.senha = senha;
        this.taxasMensais = taxasMensais;
    }

    public void novoMes(){
        this.saldo -= retornaTaxasMensais();
        System.out.println("===Mês antigo");
        System.out.println("------------------");
        info();
        System.out.println("===Novo mês");
        info();
        System.out.println("------------------");


    }

    public void info() {
        System.out.println("\nNome do titular: " + this.titular.nome + "\nNome do banco: " + this.banco.retornaNome() +
                "\nNúmero da conta: " + this.numeroConta + "\nSaldo disponível: " + this.saldo + "\nSenha do usuário: " + this.senha +
                "\nTaxas: " + retornaTaxasMensais() + "%");
    }




}
