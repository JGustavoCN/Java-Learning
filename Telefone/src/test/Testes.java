package test;

import dominio.Agenda;
import dominio.AgendaCheiaException;
import dominio.Contato;
import dominio.ContatoNaoExisteException;
import javax.swing.JOptionPane;

public class Testes {

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        final int quantContatos = 2;
        Contato[] contatos = new Contato[quantContatos];
        String menu
                = " ------- MENU CONTATOS -------\n"
                + " (1)Consultar\n"
                + " (2)Adicionar\n\n";
        int menuOpcao;
        do {
            menu(
                    Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    null, menu, " MENU ",
                                    JOptionPane.INFORMATION_MESSAGE
                            )
                    ), agenda, contatos
            );
            menuOpcao = JOptionPane.showConfirmDialog(null, "Quer voltar para o menu? ",
                    "CONTATOS", JOptionPane.YES_NO_OPTION);

        } while (menuOpcao == 0);
        System.out.println(agenda.exportarContatos());

    }

    public static void menu(int opcao, Agenda agenda, Contato[] contatos) throws IllegalArgumentException {
        
        switch (opcao) {
            case 1:
                boolean exception = false;
                int selecionar;
                if (agenda.contatos()) {
                    do {
                        try {
                            agenda.consultarContatos(
                                    JOptionPane.showInputDialog(
                                            null, "Digite o nome: ",
                                            "Selecionar", JOptionPane.INFORMATION_MESSAGE
                                    )
                            );
                        } catch (ContatoNaoExisteException e) {
                            System.out.println(e.getMessage());
                            JOptionPane.showMessageDialog(
                                    null, "Contato não existe!!!",
                                    "Consulta de Contato", JOptionPane.ERROR_MESSAGE
                            );
                            e.printStackTrace();
                            exception = true;
                        }
                        selecionar = JOptionPane.showConfirmDialog(null, "Quer voltar? ",
                                "CONTATOS", JOptionPane.YES_NO_OPTION);
                    } while (exception && selecionar == 1);
                }
                break;
            case 2:
                int adicionar = 5;
                do {
                    try {
                        for (int i = 0; i < agenda.getContatos().length; i++) {
                            if (contatos[i] != null) continue;
                            String nome = JOptionPane.showInputDialog(
                                    null, "Nome do novo contato: ",
                                    "Novo Contato", JOptionPane.INFORMATION_MESSAGE
                            );
                            int numero = Integer.parseInt(
                                    JOptionPane.showInputDialog(
                                            null, "Numero do novo contato: ",
                                            "Novo Contato", JOptionPane.INFORMATION_MESSAGE
                                    )
                            );

                            contatos[i] = new Contato(nome, numero);
                            adicionar = JOptionPane.showConfirmDialog(null, "Quer adicionar contatos? ",
                                    "CONTATOS", JOptionPane.YES_NO_OPTION);
                            if (adicionar != 0) break;
                            
                        }
                        agenda.adicionar(contatos);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(
                                null, "Digitou um número",
                                "Criação do novo contato", JOptionPane.ERROR_MESSAGE
                        );
                        adicionar = JOptionPane.showConfirmDialog(null, "Quer adicionar contatos? ",
                            "CONTATOS", JOptionPane.YES_NO_OPTION);
                    }catch (AgendaCheiaException e){
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(
                                null, "Agenda Cheia",
                                "Criação do novo contato", JOptionPane.ERROR_MESSAGE
                        );
                        adicionar = 1;
                    }
                    
                } while (adicionar == 0);
                break;
            default:
                throw new IllegalArgumentException("Não existe essa opção");
        }
    }
}
