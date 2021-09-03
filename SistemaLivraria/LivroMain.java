package SistemaLivraria;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class LivroMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Livro> livros = new ArrayList<>();

        int contador = 6;

        do{
            
            try {
                System.out.println("\n1->Cadastro de livro");
                System.out.println("2->Info dos livros");
                System.out.println("3->Busca livros por nome");
                System.out.println("4->Busca livros por categoria");
                System.out.println("5->Busca livros por preço");
                System.out.println("0->Encerrar programa");

                System.out.println("O que você deseja consultar?");
                contador = sc.nextInt();
                sc.nextLine();


                switch (contador) {


                    case 1 -> {

                        System.out.println("Qual o nome do livro que você deseja cadastrar?");
                        String nome = sc.nextLine();
                        System.out.println("Qual o nome da editora de " + nome + "?");
                        String editora = sc.nextLine();
                        System.out.println("Qual o gênero literário de " + nome + "?");
                        String genero = sc.nextLine();
                        System.out.println("Em qual ano foi lançado " + nome + "?");
                        int ano = sc.nextInt();
                        System.out.println("Qual o valor de " + nome + "?");
                        double valor = sc.nextDouble();

                        livros.add(new Livro(nome, editora, genero, ano, valor));

                        System.out.println("\nCadastro efetuado com sucesso!");
                    }

                    case 2 -> {

                        if (livros.isEmpty()) {

                            System.out.println("Não há livro(s) cadastrado(s) no sistema ainda");
                        } else {

                            for (Livro livro : livros) {

                                livro.info();
                            }
                        }
                    }

                    case 3 -> {
                        if (livros.isEmpty()) {

                            System.out.println("Não há livro(s) cadastrado(s) no sistema ainda");
                        } else {
                            System.out.println("Qual o título do livro que você deseja pesquisar?");
                            String titulo = sc.nextLine().toUpperCase();

                            for (int i = 0; i < livros.size(); i++) {

                                if (livros.get(i).getTitulo().toUpperCase().contains(titulo)) {

                                    System.out.println("Título pesquisado -> " + titulo);
                                    System.out.println("\nInfo encontrada:");
                                    livros.get(i).info();
                                }
                            }
                        }
                    }

                    case 4 -> {

                        if (livros.isEmpty()) {

                            System.out.println("Não há livro(s) cadastrado(s) no sistema ainda");
                        } else {
                            System.out.println("Qual o gênero do livro que você deseja pesquisar?");
                            String genero = sc.nextLine().toUpperCase();

                            for (int i = 0; i < livros.size(); i++) {

                                if (livros.get(i).getCategoria().toUpperCase().contains(genero)) {

                                    System.out.println("Gênero pesquisado -> " + genero);
                                    System.out.println("\nInfo encontrada:");
                                    livros.get(i).info();
                                }
                            }
                        }
                    }

                    case 5 -> {
                        if (livros.isEmpty()) {

                            System.out.println("Não há livro(s) cadastrado(s) no sistema ainda");
                        } else {
                            System.out.println("Qual faixa de preço você deseja verificar os livros?");
                            double faixaPreco = sc.nextDouble();

                            for (Livro livro : livros) {

                                if (livro.getValor() > faixaPreco) {

                                    System.out.println("Info do livro com preço maior que " + faixaPreco);
                                    livro.info();
                                } else if (livro.getValor() < faixaPreco) {

                                    System.out.println("Info do livro com preço menor que " + faixaPreco);
                                    livro.info();
                                }
                            }

                        }
                    }
                }
            }catch (NumberFormatException | InputMismatchException exception) {
                
                System.out.println("Erro de digitação");
                sc.nextLine();
                
            }
        }while(contador != 0);


    }
}
