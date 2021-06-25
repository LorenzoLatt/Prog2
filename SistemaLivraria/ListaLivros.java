package SistemaLivraria;
import java.util.ArrayList;

public class ListaLivros {

    final private ArrayList<Livro> listaLivros;

    public ListaLivros() {

        listaLivros = new ArrayList<>();
    }

    public void addLivro(Livro livro) {


        listaLivros.add(livro);
    }


    public void buscaNome(String busca) {

        System.out.println("LIVRO PESQUISADO - " + busca);
        System.out.println("RESULTADOS:");
        System.out.println("--------------");

        listaLivros.stream().map(Livro::getTitulo).
                filter(titulo -> titulo.contains(busca)).forEach(System.out::println);
        System.out.println("---------------");
    }

    public void buscaCategoria(String busca) {

        System.out.println("CATEGORIA PESQUISADA - " + busca);
        System.out.println("RESULTADOS:");
        System.out.println("----------------");

        listaLivros.stream().filter(n -> n.getCategoria().contains(busca.toUpperCase())).
                map(Livro::getTitulo).forEach(System.out::println);
        System.out.println("----------------");

    }

    public void buscaPreco(double valor) {

        if(valor <= 50) {

            System.out.println("LIVROS NA FAIXA OU ABAIXO DE R$ " + valor);
            System.out.println("---------------");

            listaLivros.stream().filter(n -> n.getValor() <= 50).
                    map(Livro::getTitulo).forEach(System.out::println);
            System.out.println("--------------");

        } else {
            System.out.println("LIVROS NA FAIXA OU ACIMA DE R$ " + valor);
            System.out.println("--------------");
            listaLivros.stream().filter(n -> n.getValor() > 50).
                    map(Livro::getTitulo).forEach(System.out::println);
            System.out.println("--------------");

        }


    }

    public void listarLivros() {

        for(Livro obj: listaLivros) {

            System.out.println("LIVRO:");
            System.out.println("-----------");
            System.out.println("\nTítulo: " + obj.getTitulo());
            System.out.println("\nEditora: " + obj.getEditora());
            System.out.println("\nCategoria: " + obj.getCategoria());
            System.out.println("\nAno de lançamento: " + obj.getAno());
            System.out.println("\nPreço: R$ " + obj.getValor());
            System.out.println("-----------");

        }


    }


}

