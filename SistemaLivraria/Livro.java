package SistemaLivraria;



public class Livro {

     final private String titulo;
     final private String editora;
     final private String categoria;
     final private int ano;
     final private double valor;


    public Livro(String titulo, String editora, String categoria, int ano, double valor) {

        this.titulo = titulo;
        this.editora = editora;
        this.categoria = categoria;
        this.ano = ano;
        this.valor = valor;
    }

    public String getTitulo()
    {
        return titulo;
    }



    public String getEditora()
    {
        return editora;
    }



    public String getCategoria()
    {
        return categoria;
    }



    public int getAno()
    {
        return ano;
    }



    public double getValor() {
        return valor;
    }


    public void info() {
        System.out.println("===Info do livro");
        System.out.println("--------------------");
        System.out.println("\nTítulo do livro: " + this.titulo + "\nEditora do livro: " + this.editora +
                "\nCategoria do livro: " + this.categoria + "\nAno do livro: " + this.ano +
                "\nValor do livro: " + this.valor);
        System.out.println("--------------------");
    }

}
