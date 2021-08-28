package SistemaBancario;
public class Pessoa{


    public String nome;
    public String sobrenome;
    public int idade;
    final private String cpf;

    public Pessoa(String nome,String sobrenome,int idade,String cpf) {

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public String retornaCpf() {

        return cpf;
    }


}
