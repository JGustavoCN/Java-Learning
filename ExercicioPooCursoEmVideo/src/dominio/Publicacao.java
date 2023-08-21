package dominio;
public interface Publicacao {
    public abstract void abrir();
    public abstract void fechar();
    public abstract void folhear(int irParaPag);
    public abstract void avancarPag();
    public abstract void voltarPag();
}
