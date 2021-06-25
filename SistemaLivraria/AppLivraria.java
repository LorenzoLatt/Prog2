package SistemaLivraria;
import java.util.InputMismatchException;
import java.util.Scanner;
public class AppLivraria {

    final private ListaLivros listaLivros;
    private final Scanner sc = new Scanner(System.in);
    private int contador = 0;

    public AppLivraria() {

        listaLivros = new ListaLivros();
    }


    public void menu() {
        int numero = 8;

        do {

            try {

                System.out.println("\n1 -> Cadastrar livro");
                System.out.println("2 -> Listar livros");
                System.out.println("3 -> Buscar por nome");
                System.out.println("4 -> Buscar por categoria");
                System.out.println("5 -> Buscar por preço");
                System.out.println("0 -> Encerrar programa");
                numero = sc.nextInt();
                sc.nextLine();

                while(numero < 1 && numero != 0 || numero > 5 && numero != 8) {

                    System.out.println("Informe uma consulta válida");
                    numero  = sc.nextInt();
                    sc.nextLine();
                }


                switch (numero) {

                    case 1 -> {

                        System.out.println("Qual o título do livro que você gostaria de adicionar?");
                        String nome = sc.nextLine();
                        System.out.println("Qual o nome da editora de " + nome + "?");
                        String editora = sc.nextLine();
                        System.out.println("Qual o gênero de " + nome + "?");
                        String categoria = sc.nextLine();
                        System.out.println("Qual o ano de lançamento de " + nome + "?");
                        int ano = sc.nextInt();
                        System.out.println("Qual o preço de " + nome + "?");
                        double valor = sc.nextDouble();

                        listaLivros.addLivro(new Livro(nome.toUpperCase(), editora.toUpperCase()
                                , categoria.toUpperCase(), ano, valor));
                        contador++;
                    }

                    case 2 -> {

                        if(contador == 0) {

                            System.out.println("Nenhum livro cadastro no sistema ainda.");

                        } else {

                            listaLivros.listarLivros();
                        }

                    }
                    case 3 -> {

                        if(contador == 0) {

                            System.out.println("Nenhum livro cadastro no sistema ainda.");

                        } else {
                            System.out.println("Informe o título livro que você deseja pesquisar:");
                            String busca = sc.nextLine();
                            listaLivros.buscaNome(busca.toUpperCase());
                        }
                    }

                    case 4 -> {
                        if(contador == 0) {

                            System.out.println("Nenhum livro cadastro no sistema ainda.");

                        } else {

                            System.out.println("informe um gênero literário para pesquisar:");
                            String categoria = sc.nextLine();
                            listaLivros.buscaCategoria(categoria.toUpperCase());
                        }
                    }

                    case 5 -> {

                        if(contador == 0) {

                            System.out.println("Nenhum livro cadastro no sistema ainda.");

                        } else {

                            System.out.println("Informe um valor para pesquisar preço de livros:");
                            double valor = sc.nextDouble();
                            while (valor < 0) {

                                System.out.println("Informe um preço válido:");
                                valor = sc.nextDouble();

                            }
                            listaLivros.buscaPreco(valor);
                        }


                    }

                }
            }catch (InputMismatchException|NumberFormatException exception) {

                System.out.println("Digitação inválida");
                sc.nextLine();
            }


        }while (numero != 0);




    }

}
