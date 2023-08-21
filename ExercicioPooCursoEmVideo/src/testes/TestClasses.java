package testes;

import dominio.Livro;
import dominio.Pessoa;
import java.util.Scanner;

public class TestClasses {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Quantos livros: ");
        int qntLivros = Integer.parseInt(teclado.nextLine());
        System.out.print("Quantas Pessoas: ");
        int qntPessoas = Integer.parseInt(teclado.nextLine());
        Pessoa[] pessoas = new Pessoa[qntPessoas];
        Livro[] livros = new Livro[qntLivros];

        for (int i = 0; i < pessoas.length; i++) {
            pessoas[i] = new Pessoa();
        }

        for (int i = 0; i < livros.length; i++) {
            livros[i] = new Livro();
        }

        System.out.println("---> Pessoas: ");
        for (Pessoa pessoa : pessoas) {
            System.out.println("------------------------------");
            System.out.print("Digite o nome: ");
            pessoa.setNome(teclado.nextLine());
            System.out.print("Digite a idade: ");
            pessoa.setIdade(Integer.parseInt(teclado.nextLine()));
            System.out.print("Digite o sexo: ");
            pessoa.setSexo(teclado.nextLine().charAt(0));
            System.out.println("---------------------------------");
        }

        System.out.println("---> Livros: ");

        for (int i = 0; i < livros.length; i++) {
            System.out.println("----------------------------------------");
            System.out.print("Digite o nome: ");
            livros[i].setNome(teclado.nextLine());
            System.out.print("Digite o autor: ");
            livros[i].setAutor(teclado.nextLine());
            System.out.print("Digite o total de paginas: ");
            livros[i].setTotalPag(Integer.parseInt(teclado.nextLine()));
            System.out.println("--------------------------------------------");
        }

        for (Pessoa pessoa : pessoas) {

            int quantidade;
            int opcao;

            for (int i = 0; i < livros.length; i++) {
                System.out.println((i + 1) + "° livro: ");
                livros[i].detalhes();

            }

            System.out.println("Leitor: " + pessoa.getNome());
            System.out.print("Quantos livros vai ler? ");
            quantidade = Integer.parseInt(teclado.next());

            for (int i = 0; i < quantidade; i++) {
                System.out.print("Escolha qual sera o " + (i + 1) + "° livro: ");
                opcao = Integer.parseInt(teclado.next());
                switch (opcao) {
                    case 1:
                        livros[0].setLeitor(pessoa);
                        pessoa.setLivros(livros[0]);
                        break;
                    case 2:
                        livros[1].setLeitor(pessoa);
                        pessoa.setLivros(livros[1]);
                        break;
                    case 3:
                        livros[2].setLeitor(pessoa);
                        pessoa.setLivros(livros[2]);
                        break;
                }
            }
        }
        System.out.println("==============================================");
        for (Livro livro : livros) {
            livro.detalhes();
        }
        for (Pessoa pessoa : pessoas) {
            pessoa.detalhes();
        }
    }
}
