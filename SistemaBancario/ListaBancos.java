package SistemaBancario;
import java.util.ArrayList;
public class ListaBancos {

    public int contadorBancos = 0;
    final private ArrayList<Banco> listaBancos;
    final private ArrayList<ContaCorrente> contasCorrentes = new ArrayList<>();
    final private ArrayList<ContaPoupanca> contasPoupanca = new ArrayList<>();

    public ListaBancos() {

        listaBancos = new ArrayList<>();
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

    public void addContasBanco(Banco banco) {

        listaBancos.add(banco);
    }
    public ArrayList<Banco> retornaListaBancos() {

        return listaBancos;
    }

    public void info() {

        for(Banco banco: listaBancos) {

            System.out.println("\nNome do banco: " + banco.retornaNome() + "\nCNPJ do banco: " +
                    banco.retornaCNPJ() + "\nNúmero do banco: " + banco.retornaNumeroBanco());
        }
    }

    public Banco retornaBanco() {

        return listaBancos.get(contadorBancos - 1);
    }
}
