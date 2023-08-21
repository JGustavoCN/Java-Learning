package dominio;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class Agenda implements Menu {

    private Contato contatos[] = new Contato[2];

    public Contato[] getContatos() {
        return contatos;
    }

    private void setContatos(Contato... contatos) throws AgendaCheiaException {
        for (Contato contato : this.contatos) {
            if (contato == null) {
                break;
            }
            throw new AgendaCheiaException("Agenda Cheia");
        }
        this.contatos = contatos;
    }

    @Override
    public void adicionar(Contato... contatos) throws AgendaCheiaException{

        this.setContatos(contatos);

    }

    @Override
    public boolean contatos() {
        if (contatos == null || contatos.length == 0) {
            JOptionPane.showMessageDialog(
                    null, "Não possuí contatos\nPrimeiro Adicione",
                    "CONTATOS", JOptionPane.INFORMATION_MESSAGE
            );
            return false;
        }
        String nomes = "\n";
        for (Contato contato : contatos) {
            if (contato == null) {
                break;
            }
            nomes += contato.getNome() + "\n";
        }
        JOptionPane.showMessageDialog(null, nomes);
        return true;
    }

    @Override
    public String exportarContatos() {
        return Arrays.toString(contatos);
    }

    /**
     *
     * @param nome Se não existir lança uma exception
     * @throws dominio.ContatoNaoExisteException quando o nome do contato nao
     * existe
     *
     */
    @Override
    public void consultarContatos(String nome) throws ContatoNaoExisteException {
        boolean existe = false;
        if (contatos == null || contatos.length == 0) {
            JOptionPane.showMessageDialog(
                    null, "Não possuí contatos\nPrimeiro Adicione",
                    "CONTATOS", JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }
        for (Contato contato : contatos) {
            if (contato == null) {
                break;
            }
            if (contato.getNome().equalsIgnoreCase(nome)) {
                JOptionPane.showMessageDialog(
                        null, contato.getNome() + "\n" + contato.getTelefone() + "\n",
                        "CONTATOS", JOptionPane.INFORMATION_MESSAGE
                );
                existe = true;
            }
        }
        if (!existe) {
            throw new ContatoNaoExisteException("Contato não encontrado!!!");
        }
    }

}
