package SistemaBancario;

public class ContaCorrente extends ContaBancaria{


    final private double taxasMensais;

    public double retornaTaxasMensais() {

        return taxasMensais;
    }


    public ContaCorrente(Pessoa pessoa, Banco banco, int numeroConta, double saldo, String senha, double taxasMensais) {

        this.titular = pessoa;
        this.banco = banco;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.senha = senha;
        this.taxasMensais = saldo*taxasMensais;
    }

    public static void novoMes(ListaPessoas listaPessoas){

        for(int i = 0; i < listaPessoas.retornaListaContasCorrente().size(); i++) {

            listaPessoas.retornaListaContasCorrente().get(i).saldo = (listaPessoas.retornaListaContasCorrente().get(i).
                    saldo - listaPessoas.retornaListaContasCorrente().get(i).taxasMensais);

        }

    }

}
