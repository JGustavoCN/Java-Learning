package dominio;

// Implements é uma palavra reservada para a implementacao de uma interface
import javax.swing.JOptionPane;

// Podemos implementar varias interfaces
public class Video implements AcoesVideo, MaisAcoesVideo {

    private String titulo;
    private double avaliacao;
    private int views;
    private int curtidadas;
    private boolean reproduzindo;

    private int qualidadeVideo;
    private boolean telaInteira;
    private String legenda;

//    Por padrao todas as classes tem um construtor vazio que é omitido
    public Video() {
        
    }
    
    public Video(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        double nota;
        nota = (this.avaliacao +avaliacao)/ (double) this.views;
        this.avaliacao = nota;
    }

    public int getViews() {
        return views;
    }

    protected void setViews(int views) {
        this.views = views;
    }

    public int getCurtidadas() {
        return curtidadas;
    }

    protected void setCurtidadas(int curtidadas) {
        this.curtidadas = curtidadas;
    }

    public boolean isReproduzindo() {
        return reproduzindo;
    }

    protected void setReproduzindo(boolean reproduzindo) {
        this.reproduzindo = reproduzindo;
    }

    public int getQualidadeVideo() {
        return qualidadeVideo;
    }

    protected void setQualidadeVideo(int qualidadeVideo) {
        if (qualidadeVideo == 240 || qualidadeVideo == 360 || qualidadeVideo == 480 || qualidadeVideo == 720) {
            this.qualidadeVideo = qualidadeVideo;
        } else {
            JOptionPane.showMessageDialog(null, "Essa qualidade não está disponivel\n"
                    + "Qualidade foi definida como a mais alta possivel");
            this.qualidadeVideo = 720;
        }
    }

    public boolean isTelaInteira() {
        return telaInteira;
    }

    private void setTelaInteira(boolean telaInteira) {
        this.telaInteira = telaInteira;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

// A classe que implementa uma interface é obrigada a sobrecrever os metodos
// da interface, mas as subclasses nao sao obrigadas
    @Override
    public void play() {
        System.out.println("Play");
        this.setViews(this.getViews() + 1);
        this.setReproduzindo(true);
    }

//  Um metodo sobrescrito de uma interface não pode ter um modificador diferente de public
//  Isso ocorre, devido a regra de que um metodo sobrescrito de uma SuperClasse não pode ter -
//  - um modificador de acesso mais restritivo
//  Ordem de Restriçao (Do menos ao mais retritivo)
//    public ->             protected  ->                      default  ->                      private 
//(todos acessao) - (Somente as suas SubClasses) -  (Todos que estão no mesmo pacote) -  (Somente a minha classe)
    @Override
    public void pause() {
        System.out.println("Pause");
        this.setReproduzindo(false);
    }

    @Override
    public void like() {
        System.out.println("LIKE");
        this.setCurtidadas(this.getCurtidadas() + 1);
    }

    @Override
    public void pular() {
        System.out.println("Pular 10 segundos");
    }

    @Override
    public void voltar() {
        System.out.println("Voltar 10 segundos");
    }

    @Override
    public void qualidadeVideo(int qualidadeVideo) {
        JOptionPane.showMessageDialog(null, "240p\n360p\n480p\n720p", "Qualidades disponiveis", JOptionPane.INFORMATION_MESSAGE);
        this.setQualidadeVideo(qualidadeVideo);
    }

    @Override
    public void telaInteira(boolean telaInteira) {
        this.setTelaInteira(telaInteira);
    }

    @Override
    public String legenda(boolean ativarLegenda) {
        if (this.getLegenda() == null) {
            JOptionPane.showMessageDialog(null, "NAO TEM LEGENDA");
            return "";
        }
        JOptionPane.showMessageDialog(null, this.getLegenda());
        return this.getLegenda();

    }

// Essa é a sobrescrita de um metodo default da interface MaisAcoesVideo    
    @Override
    public void modoTeatro() {
        if (this.isTelaInteira() == true) {
            System.out.println("Primeiro retire a tela inteira!!!");
        }
        System.out.println("Modo teatro");
    }

//  ?????????
//  Esse é uma copia do metodo static da classe MaisAcoesVideo
//  Metodo static nao pode ser sobrescrito
//  Ex.:
    //@Override
    public static void disponibilidade(boolean disponibilidade) {
        if (disponibilidade) {
            System.out.println("Acessando... Videos disponiveis!");
        } else {
            System.out.println("Acessando... Videos nao disponiveis");
        }

    }

}
