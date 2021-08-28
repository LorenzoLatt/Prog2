package SistemaBancario;

public class Banco {

    final private String nome;
    final private String cnpj;
    final private int numeroBanco;

    public Banco(String nome, String cnpj, int numeroBanco) {

        this.nome = nome;
        this.cnpj = cnpj;
        this.numeroBanco = numeroBanco;
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

    public void infoContas(){}

    public void criarConta(){}

    public void fecharConta(){}

}
