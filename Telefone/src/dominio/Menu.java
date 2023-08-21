package dominio;

public interface Menu {
    
    void adicionar(Contato... contatos) throws AgendaCheiaException;
    boolean contatos();
    void consultarContatos(String nome) throws ContatoNaoExisteException;
    String exportarContatos();
}
