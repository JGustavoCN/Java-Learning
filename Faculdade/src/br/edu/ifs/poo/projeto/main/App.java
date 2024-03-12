package br.edu.ifs.poo.projeto.main;

import br.edu.ifs.poo.projeto.model.*;
import br.edu.ifs.poo.projeto.util.Menu;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        ArrayList<Aluno> listaAlunos = new ArrayList<>();
        ArrayList<Professor> listaProfessor = new ArrayList<>();
        ArrayList<Psicologo> listaPsicologos = new ArrayList<>();
        ArrayList<Pedagogo> listaPedagogo = new ArrayList<>();
        ArrayList<Tecnico> listaTecnico = new ArrayList<>();
        ArrayList<Candidato> listaCandidatos = new ArrayList<>();
        ArrayList<Responsavel> listaResponsavel = new ArrayList<>();
        ArrayList<Zelador> listaZelador = new ArrayList<>();
        ArrayList<Monitor> listaMonitores = new ArrayList<>();
        ArrayList<Secretaria> listaSecretaria = new ArrayList<>();

        String nome;
        String dataNasc;
        String locDeNasc;
        long cpf;
        char sexo;

        Scanner teclado = new Scanner(System.in, "latin1").useDelimiter("\n");
        int escolha;

        Menu menu = new Menu();

        System.out.print(menu.getMenu());
        escolha = teclado.nextInt();
        System.out.println(" ");

        while (escolha != 0) {
            switch (escolha) {
                case 1:
                    System.out.println("==================");
                    System.out.println("| CADASTRO ALUNO |");
                    System.out.println("==================");
                    System.out.println(" ");

                    Aluno aluno = new Aluno();

                    System.out.println("Digite o nome do aluno:");
                    nome = teclado.next();
                    aluno.setNome(nome);

                    System.out.println("Digite a data de nascimento:");
                    dataNasc = teclado.next();
                    aluno.setDataNascimento(dataNasc);

                    System.out.println("Digite o local de nascimento:");
                    locDeNasc = teclado.next();
                    aluno.setLocalNascimento(locDeNasc);

                    System.out.println("Digite o sexo do aluno:");
                    sexo = teclado.next().charAt(0);
                    aluno.setSexo(sexo);

                    System.out.println("Digite o CPF:");
                    cpf = teclado.nextLong();
                    aluno.setCpf(cpf);

                    System.out.println("Digite a primeira nota do aluno: ");
                    double nota1 = teclado.nextDouble();
                    aluno.setNota1(nota1);

                    System.out.println("Digite a segunda nota do aluno: ");
                    double nota2 = teclado.nextDouble();
                    aluno.setNota2(nota2);

                    listaAlunos.add(aluno);

                    break;
                case 2:
                    System.out.println("================");
                    System.out.println("| LISTAR ALUNO |");
                    System.out.println("================");
                    System.out.println(" ");

                    System.out.println(listaAlunos);
                    break;
                case 3:
                    System.out.println("======================");
                    System.out.println("| CADASTRO PROFESSOR |");
                    System.out.println("======================");
                    System.out.println(" ");

                    Professor professor = new Professor();

                    System.out.println("Digite o nome do professor:");
                    nome = teclado.next();
                    professor.setNome(nome);

                    System.out.println("Digite a data de nascimento:");
                    dataNasc = teclado.next();
                    professor.setDataNascimento(dataNasc);

                    System.out.println("Digite o local de nascimento: ");
                    locDeNasc = teclado.next();
                    professor.setLocalNascimento(locDeNasc);

                    System.out.println("Digite o sexo do professor:");
                    sexo = teclado.next().charAt(0);
                    professor.setSexo(sexo);

                    System.out.println("Digite o CPF:");
                    cpf = teclado.nextLong();
                    professor.setCpf(cpf);

                    System.out.println("Digite a formação do professor: ");
                    String formacao = teclado.next();
                    professor.setFormacao(formacao);

                    System.out.println("Digite a quantidade de disciplinas: ");
                    int disciplinas = teclado.nextInt();
                    professor.setQuantDisciplinas(disciplinas);

                    listaProfessor.add(professor);
                    break;
                case 4:
                    System.out.println("====================");
                    System.out.println("| LISTAR PROFESSOR |");
                    System.out.println("====================");
                    System.out.println(" ");

                    System.out.println(listaProfessor);
                    break;
                case 5:
                    System.out.println("======================");
                    System.out.println("| CADASTRO PSICOLÓGO |");
                    System.out.println("======================");
                    System.out.println(" ");
                    Psicologo psicologo = new Psicologo();

                    System.out.println("Digite o nome do psicólogo: ");
                    nome = teclado.next();
                    psicologo.setNome(nome);

                    System.out.println("Digite a data de nascimento:");
                    dataNasc = teclado.next();
                    psicologo.setDataNascimento(dataNasc);

                    System.out.println("Digite o local de nascimento: ");
                    locDeNasc = teclado.next();
                    psicologo.setLocalNascimento(locDeNasc);

                    System.out.println("Digite o sexo do psicólogo:");
                    sexo = teclado.next().charAt(0);
                    psicologo.setSexo(sexo);

                    System.out.println("Digite o CPF:");
                    cpf = teclado.nextLong();
                    psicologo.setCpf(cpf);

                    System.out.println("Digite a especialidade do psicólogo:");
                    String especialidade = teclado.next();
                    psicologo.setEspecialidade(especialidade);

                    System.out.println("Digite o CRP do psicólogo:");
                    int crp = teclado.nextInt();
                    psicologo.setCrp(crp);

                    listaPsicologos.add(psicologo);

                    break;
                case 6:
                    System.out.println("====================");
                    System.out.println("| LISTAR PSICÓLOGO |");
                    System.out.println("====================");
                    System.out.println(" ");

                    System.out.println(listaPsicologos);
                    break;
                case 7:
                    System.out.println("======================");
                    System.out.println("| CADASTRAR PEDAGOGO |");
                    System.out.println("======================");
                    System.out.println(" ");

                    Pedagogo pedagogo = new Pedagogo();

                    System.out.println("Digite o nome do pedagogo: ");
                    nome = teclado.next();
                    pedagogo.setNome(nome);

                    System.out.println("Digite a data de nascimento:");
                    dataNasc = teclado.next();
                    pedagogo.setDataNascimento(dataNasc);

                    System.out.println("Digite o local de nascimento: ");
                    locDeNasc = teclado.next();
                    pedagogo.setLocalNascimento(locDeNasc);

                    System.out.println("Digite o sexo do pedagogo:");
                    sexo = teclado.next().charAt(0);
                    pedagogo.setSexo(sexo);

                    System.out.println("Digite o CPF:");
                    cpf = teclado.nextLong();
                    pedagogo.setCpf(cpf);

                    System.out.println("Informe o Registro do pedagogo:");
                    int registro = teclado.nextInt();
                    pedagogo.setRegistro(registro);

                    listaPedagogo.add(pedagogo);

                    break;
                case 8:
                    System.out.println("===================");
                    System.out.println("| LISTAR PEDAGOGO |");
                    System.out.println("===================");
                    System.out.println(" ");

                    System.out.println(listaPedagogo);
                    break;
                case 9:
                    System.out.println("====================");
                    System.out.println("| CADASTRO TECNICO |");
                    System.out.println("====================");
                    System.out.println(" ");

                    Tecnico tecnico = new Tecnico();

                    System.out.println("Digite o nome do técnico: ");
                    nome = teclado.next();
                    tecnico.setNome(nome);

                    System.out.println("Digite a data de nascimento:");
                    dataNasc = teclado.next();
                    tecnico.setDataNascimento(dataNasc);

                    System.out.println("Digite o local de nascimento: ");
                    locDeNasc = teclado.next();
                    tecnico.setLocalNascimento(locDeNasc);

                    System.out.println("Digite o sexo do técnico:");
                    sexo = teclado.next().charAt(0);
                    tecnico.setSexo(sexo);

                    System.out.println("Digite o CPF:");
                    cpf = teclado.nextLong();
                    tecnico.setCpf(cpf);

                    System.out.println("Digite a função do técnico:");
                    String funcao = teclado.next();
                    tecnico.setFuncao(funcao);

                    System.out.println("Qual o cargo do técnico:");
                    String cargo = teclado.next();
                    tecnico.setCargo(cargo);

                    System.out.println("Qual o ano de entrada do técnico:");
                    String anoEntrada = teclado.next();
                    tecnico.setAnoDeEntrada(anoEntrada);

                    listaTecnico.add(tecnico);
                    break;
                case 10:
                    System.out.println("==================");
                    System.out.println("| LISTAR TECNICO |");
                    System.out.println("==================");
                    System.out.println(" ");

                    System.out.println(listaTecnico);
                    break;
                case 11:
                    System.out.println("======================");
                    System.out.println("| CADASTRO CANDIDATO |");
                    System.out.println("======================");
                    System.out.println(" ");

                    Candidato candidato = new Candidato();

                    System.out.println("Digite o nome do candidato: ");
                    nome = teclado.next();
                    candidato.setNome(nome);

                    System.out.println("Digite a data de nascimento:");
                    dataNasc = teclado.next();
                    candidato.setDataNascimento(dataNasc);

                    System.out.println("Digite o local de nascimento: ");
                    locDeNasc = teclado.next();
                    candidato.setLocalNascimento(locDeNasc);

                    System.out.println("Digite o sexo do candidato:");
                    sexo = teclado.next().charAt(0);
                    candidato.setSexo(sexo);

                    System.out.println("Digite o CPF:");
                    cpf = teclado.nextLong();
                    candidato.setCpf(cpf);

                    System.out.println("Digite a data do concurso:");
                    String dataConcurso = teclado.next();
                    candidato.setDataConcurso(dataConcurso);

                    System.out.println("Digite o código da vaga:");
                    int codigoVaga = teclado.nextInt();
                    candidato.setCodigoVaga(codigoVaga);

                    System.out.println("Digite a pontuação:");
                    int pontuacao = teclado.nextInt();
                    candidato.setPontuacao(pontuacao);

                    listaCandidatos.add(candidato);
                    break;
                case 12:
                    System.out.println("====================");
                    System.out.println("| LISTAR CANDIDATO |");
                    System.out.println("====================");
                    System.out.println(" ");

                    System.out.println(listaCandidatos);
                    break;
                case 13:
                    System.out.println("========================");
                    System.out.println("| CADASTRO RESPONSÁVEL |");
                    System.out.println("========================");
                    System.out.println(" ");

                    Responsavel responsavel = new Responsavel();

                    System.out.println("Digite o nome do responsável: ");
                    nome = teclado.next();
                    responsavel.setNome(nome);

                    System.out.println("Digite a data de nascimento:");
                    dataNasc = teclado.next();
                    responsavel.setDataNascimento(dataNasc);

                    System.out.println("Digite o local de nascimento: ");
                    locDeNasc = teclado.next();
                    responsavel.setLocalNascimento(locDeNasc);

                    System.out.println("Digite o sexo do responsável:");
                    sexo = teclado.next().charAt(0);
                    responsavel.setSexo(sexo);

                    System.out.println("Digite o CPF:");
                    cpf = teclado.nextLong();
                    responsavel.setCpf(cpf);

                    System.out.println("Digite o parentesco do responsável:");
                    String parentesco = teclado.next();
                    responsavel.setParentesco(parentesco);

                    System.out.println("Digite a renda do responsável:");
                    double renda = teclado.nextDouble();
                    responsavel.setRenda(renda);

                    listaResponsavel.add(responsavel);
                    break;
                case 14:
                    System.out.println("======================");
                    System.out.println("| LISTAR RESPONSÁVEL |");
                    System.out.println("======================");
                    System.out.println(" ");

                    System.out.println(listaResponsavel);
                    break;
                case 15:
                    System.out.println("====================");
                    System.out.println("| CADASTRO ZELADOR |");
                    System.out.println("====================");
                    System.out.println(" ");

                    Zelador zelador = new Zelador();

                    System.out.println("Digite o nome do zelador: ");
                    nome = teclado.next();
                    zelador.setNome(nome);

                    System.out.println("Digite a data de nascimento:");
                    dataNasc = teclado.next();
                    zelador.setDataNascimento(dataNasc);

                    System.out.println("Digite o local de nascimento: ");
                    locDeNasc = teclado.next();
                    zelador.setLocalNascimento(locDeNasc);

                    System.out.println("Digite o sexo do zelador:");
                    sexo = teclado.next().charAt(0);
                    zelador.setSexo(sexo);

                    System.out.println("Digite o CPF:");
                    cpf = teclado.nextLong();
                    zelador.setCpf(cpf);

                    System.out.println("Digite o setor do zelador: ");
                    String setorResponsavel = teclado.next();
                    zelador.setSetorResponsavel(setorResponsavel);

                    System.out.println("O zelador possui chave? (Digite 'true' se sim, 'false' se não): ");
                    boolean possuiChave = teclado.nextBoolean();
                    zelador.setPossuiChave(possuiChave);

                    listaZelador.add(zelador);
                    break;
                case 16:
                    System.out.println("==================");
                    System.out.println("| LISTAR ZELADOR |");
                    System.out.println("==================");
                    System.out.println(" ");

                    System.out.println(listaZelador);
                    break;
                case 17:
                    System.out.println("====================");
                    System.out.println("| CADASTRO MONITOR |");
                    System.out.println("====================");
                    System.out.println(" ");

                    Monitor monitor = new Monitor();

                    System.out.println("Digite o nome do monitor: ");
                    nome = teclado.next();
                    monitor.setNome(nome);

                    System.out.println("Digite a data de nascimento:");
                    dataNasc = teclado.next();
                    monitor.setDataNascimento(dataNasc);

                    System.out.println("Digite o local de nascimento: ");
                    locDeNasc = teclado.next();
                    monitor.setLocalNascimento(locDeNasc);

                    System.out.println("Digite o sexo do monitor:");
                    sexo = teclado.next().charAt(0);
                    monitor.setSexo(sexo);

                    System.out.println("Digite o CPF:");
                    cpf = teclado.nextLong();
                    monitor.setCpf(cpf);

                    System.out.println("Digite o salário do monitor: ");
                    double salario = teclado.nextDouble();
                    monitor.setSalario(salario);

                    System.out.println("Digite o período do monitor: ");
                    String periodo = teclado.next();
                    monitor.setPeriodo(periodo);

                    System.out.println("Digite a disciplina do monitor: ");
                    String disciplina = teclado.next();
                    monitor.setDisciplina(disciplina);

                    listaMonitores.add(monitor);
                    break;
                case 18:
                    System.out.println("==================");
                    System.out.println("| LISTAR MONITOR |");
                    System.out.println("==================");
                    System.out.println(" ");

                    System.out.println(listaMonitores);
                    break;
                case 19:
                    System.out.println("=======================");
                    System.out.println("| CADASTRO SECRETÁRIA |");
                    System.out.println("=======================");
                    System.out.println(" ");

                    Secretaria secretaria = new Secretaria();

                    System.out.println("Digite o nome da secretária: ");
                    nome = teclado.next();
                    secretaria.setNome(nome);

                    System.out.println("Digite a data de nascimento:");
                    dataNasc = teclado.next();
                    secretaria.setDataNascimento(dataNasc);

                    System.out.println("Digite o local de nascimento: ");
                    locDeNasc = teclado.next();
                    secretaria.setLocalNascimento(locDeNasc);

                    System.out.println("Digite o sexo da secretária:");
                    sexo = teclado.next().charAt(0);
                    secretaria.setSexo(sexo);

                    System.out.println("Digite o CPF:");
                    cpf = teclado.nextLong();
                    secretaria.setCpf(cpf);

                    System.out.println("Digite o número do ramal:");
                    int ramal = teclado.nextInt();
                    secretaria.setRamal(ramal);

                    System.out.println("Digite a função da secretária:");
                    String funcaoS = teclado.next();
                    secretaria.setFuncaoS(funcaoS);

                    System.out.println("Digite o turno da secretária:");
                    String turno = teclado.next();
                    secretaria.setTurno(turno);

                    System.out.println("Digite o departamento da secretária:");
                    String departamento = teclado.next();
                    secretaria.setDepartamento(departamento);

                    listaSecretaria.add(secretaria);
                    break;

                case 20:
                    System.out.println("===================");
                    System.out.println("| LISTAR SECRETÁRIA |");
                    System.out.println("===================");
                    System.out.println(" ");

                    System.out.println(listaSecretaria);
                    break;
            }

            System.out.print(menu.getMenu());
            escolha = teclado.nextInt();
            System.out.println(" ");

            if (escolha == 0) {
                System.out.println("Saindo...");
            }
        }
        //teclado.close();

    }

}
