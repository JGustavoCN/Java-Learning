package dominio;

public class Livro implements Publicacao {

    private String nome;
    private String autor;
    private int totalPag;
    private int pagAtual;
    private boolean aberto;
    private Pessoa leitor;

    public Livro(String nome, String autor, int totalPag) {
        this.nome = nome;
        this.autor = autor;
        this.totalPag = totalPag;
    }
    
    public Livro(String nome, String autor, int totalPag, int pagAtual, boolean aberto, Pessoa leitor) {
        this.nome = nome;
        this.autor = autor;
        this.totalPag = totalPag;
        this.pagAtual = pagAtual;
        this.aberto = aberto;
        this.leitor = leitor;
    }

    public Livro() {
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getTotalPag() {
        return totalPag;
    }

    public void setTotalPag(int totalPag) {
        this.totalPag = totalPag;
    }

    public int getPagAtual() {
        return pagAtual;
    }

    public void setPagAtual(int pagAtual) {
        this.pagAtual = pagAtual;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public Pessoa getLeitor() {
        return leitor;
    }

    public void setLeitor(Pessoa leitor) {
        this.leitor = leitor;
    }

    public void detalhes() {
        System.out.println("===================================");
        System.out.println("Nome: " + this.nome);
        System.out.println("Autor: " + this.autor);
        System.out.println("Total de Paginas: " + this.totalPag);
        System.out.println("Pagina Atual: " + this.pagAtual);
        System.out.println("Aberto: " + this.aberto);
        if(this.leitor != null)
            System.out.println("Leitor: " + this.leitor.getNome()+" Idade: "+this.leitor.getIdade()+ " Sexo: "+this.leitor.getSexo());
        System.out.println("===================================");
    }

    @Override
    public void abrir() {
        this.aberto = true;
    }

    @Override
    public void fechar() {
        this.setAberto(true);

    }

    @Override
    public void folhear(int irParaPag) {
        this.pagAtual = irParaPag;
    }

    @Override
    public void avancarPag() {
        this.setPagAtual(this.getPagAtual() + 1);
    }

    @Override
    public void voltarPag() {
        this.pagAtual--;
    }

}
