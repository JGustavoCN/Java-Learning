package poo.projeto;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
        ArrayList<Professor> listaProfessor = new ArrayList<Professor>();
        ArrayList<Psicologo> listaPsicologo = new ArrayList<Psicologo>();
        ArrayList<Pedagogo> listaPedagogo = new ArrayList<Pedagogo>();
        ArrayList<Tecnico> listaTecnico = new ArrayList<Tecnico>();

        int escolha;
        String nome;
        String dataNasc;
        String locDeNasc;
        char sexo;
        int cpf;

        Menu menu = new Menu();

        // Charset que pode ser usados CP850 Windows-1252 ISO-8859-1 latin1
        Scanner scanner = new Scanner(System.in, "latin1");

        System.out.print(menu.getMenu());
        escolha = Integer.parseInt(scanner.nextLine());

        while (escolha != 0) {
            switch (escolha) {
                case 1:
                    
                    System.out.println("==================");
                    System.out.println("| CADASTRO ALUNO |");
                    System.out.println("==================");

                    Aluno aluno = new Aluno();

                    System.out.println("Digite o nome do aluno:");
                    nome = scanner.nextLine();
                    aluno.setNome(nome);

                    System.out.println("Digite a data de nascimento:");
                    dataNasc = scanner.nextLine();
                    aluno.setDataNascimento(dataNasc);

                    System.out.println("Digite o local de nascimento:");
                    locDeNasc = scanner.nextLine();
                    aluno.setLocalNascimento(locDeNasc);

                    System.out.println("Digite o seu sexo: ");
                    sexo = scanner.nextLine().toUpperCase().charAt(0);
                    aluno.setSexo(sexo);

                    System.out.println("Digite o cpf: ");
                    cpf = Integer.parseInt(scanner.nextLine());
                    aluno.setCpf(cpf);

                    listaAlunos.add(aluno);

                    break;
                case 2:
                    System.out.println("================");
                    System.out.println("| LISTAR ALUNO |");
                    System.out.println("================");
                    break;
                case 3:
                    
                    System.out.println("======================");
                    System.out.println("| CADASTRO PROFESSOR |");
                    System.out.println("======================");
                    
                    Professor professor = new Professor();

                    System.out.println("Digite o nome: ");
                    nome = scanner.nextLine();
                    professor.setNome(nome);

                    System.out.println("Digite a data de nascimento: ");
                    dataNasc = scanner.nextLine();
                    professor.setDataNascimento(dataNasc);

                    System.out.println("Digite o local de nascimento: ");
                    locDeNasc = scanner.nextLine();
                    professor.setLocalNascimento(locDeNasc);

                    System.out.println("Digite o seu sexo: ");
                    sexo = scanner.nextLine().toUpperCase().charAt(0);
                    professor.setSexo(sexo);

                    System.out.println("Digite o cpf: ");
                    cpf = Integer.parseInt(scanner.nextLine());
                    professor.setCpf(cpf);

                    listaProfessor.add(professor);

                    break;
                case 4:
                    System.out.println("====================");
                    System.out.println("| LISTAR PROFESSOR |");
                    System.out.println("====================");
                    break;
                case 5:
                    
                    System.out.println("======================");
                    System.out.println("| CADASTRO PSICOLÓGO |");
                    System.out.println("======================");
                    
                    Psicologo psicologo = new Psicologo();

                    System.out.println("Digite o nome: ");
                    nome = scanner.nextLine();
                    psicologo.setNome(nome);

                    System.out.println("Digite a data de nascimento: ");
                    dataNasc = scanner.nextLine();
                    psicologo.setDataNascimento(dataNasc);

                    System.out.println("Digite o local de nascimento: ");
                    locDeNasc = scanner.nextLine();
                    psicologo.setLocalNascimento(locDeNasc);

                    System.out.println("Digite o seu sexo: ");
                    sexo = scanner.nextLine().toUpperCase().charAt(0);
                    psicologo.setSexo(sexo);

                    System.out.println("Digite o cpf: ");
                    cpf = Integer.parseInt(scanner.nextLine());
                    psicologo.setCpf(cpf);
                    
                    listaPsicologo.add(psicologo);

                    break;
                case 6:
                    System.out.println("====================");
                    System.out.println("| LISTAR PSICÓLOGO |");
                    System.out.println("====================");
                    break;
                case 7:
                    
                    System.out.println("======================");
                    System.out.println("| CADASTRAR PEDAGOGO |");
                    System.out.println("======================");

                    Pedagogo pedagogo = new Pedagogo();
                    
                    System.out.println("Digite o nome: ");
                    nome = scanner.nextLine();
                    pedagogo.setNome(nome);

                    System.out.println("Digite a data de nascimento: ");
                    dataNasc = scanner.nextLine();
                    pedagogo.setDataNascimento(dataNasc);

                    System.out.println("Digite o local de nascimento: ");
                    locDeNasc = scanner.nextLine();
                    pedagogo.setLocalNascimento(locDeNasc);

                    System.out.println("Digite o seu sexo: ");
                    sexo = scanner.nextLine().toUpperCase().charAt(0);
                    pedagogo.setSexo(sexo);

                    System.out.println("Digite o cpf: ");
                    cpf = Integer.parseInt(scanner.nextLine());
                    pedagogo.setCpf(cpf);
                    
                    listaPedagogo.add(pedagogo);

                    break;
                case 8:
                    System.out.println("===================");
                    System.out.println("| LISTAR PEDAGOGO |");
                    System.out.println("===================");
                    break;
                case 9:
                    
                    System.out.println("====================");
                    System.out.println("| CADASTRO TECNICO |");
                    System.out.println("====================");

                    Tecnico tecnico = new Tecnico();
                    
                    System.out.println("Digite o nome: ");
                    nome = scanner.nextLine();
                    tecnico.setNome(nome);

                    System.out.println("Digite a data de nascimento: ");
                    dataNasc = scanner.nextLine();
                    tecnico.setDataNascimento(dataNasc);

                    System.out.println("Digite o local de nascimento: ");
                    locDeNasc = scanner.nextLine();
                    tecnico.setLocalNascimento(locDeNasc);

                    System.out.println("Digite o seu sexo: ");
                    sexo = scanner.nextLine().toUpperCase().charAt(0);
                    tecnico.setSexo(sexo);

                    System.out.println("Digite o cpf: ");
                    cpf = Integer.parseInt(scanner.nextLine());
                    tecnico.setCpf(cpf);
                    
                    listaTecnico.add(tecnico);
                    
                    break;
                case 10:
                    System.out.println("==================");
                    System.out.println("| LISTAR TECNICO |");
                    System.out.println("==================");
                    break;
            }

            System.out.print(menu.getMenu());
            escolha = Integer.parseInt(scanner.nextLine());

            if (escolha == 0) {
                System.out.println("Saindo...");
            }
        }
        //scanner.close();
    }
}
