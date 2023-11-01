package poo.projeto;

public class Menu {

    private final String menu
            = "\n#########################"
            + "\n#########################"
            + "\n           MENU          "
            + "\n#########################"
            + "\n#########################"
            + "\n                         "
            + "\n 1-cadastrar aluno       "
            + "\n 2-listar aluno          "
            + "\n 3-cadastrar professor   "
            + "\n 4-listar professor      "
            + "\n 5-cadastrar psicologo   "
            + "\n 6-listar psicologo      "
            + "\n 7-cadastrar pedagogo    "
            + "\n 8-listar pedagogo       "
            + "\n 9-cadastrar tecnico     "
            + "\n 10-listar tecnico       "
            + "\n 0-sair                  "
            + "\n   Selecione uma opção: ";

    public String getMenu() {
        return this.menu;
    }

}
