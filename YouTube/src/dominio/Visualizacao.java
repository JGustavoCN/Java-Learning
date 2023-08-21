package dominio;

// Diferente de uma classe abstrata, classe final foi feita para ser folha(Classe que nao pode ter filhas)
public final class Visualizacao {
    private Gafanhoto espectador;
    private Video filme;

    public void avaliar(){
        this.filme.setAvaliacao(5);
    }
    public void avaliar(int nota){
        this.filme.setAvaliacao(nota);
    }
    public void avaliar(float porcentagem){
        int tot;
        if (porcentagem <= 20) {
            tot = 3;
        } if (porcentagem <= 50) {
            tot = 5;
        } if (porcentagem <= 90) {
            tot = 8;
        } else {
            tot = 10;
        }
        this.filme.setAvaliacao(tot);
    }
    
    public Visualizacao(Gafanhoto espectador, Video filme) {
        this.espectador = espectador;
        this.filme = filme;
        this.espectador.setTotalAssistidos(this.espectador.getTotalAssistidos() + 1);
        this.filme.setViews(this.filme.getViews()+ 1);
    }

    public Gafanhoto getEspectador() {
        return espectador;
    }

    public void setEspectador(Gafanhoto espectador) {
        this.espectador = espectador;
    }

    public Video getFilme() {
        return filme;
    }

    public void setFilme(Video filme) {
        this.filme = filme;
    }

    @Override
    public String toString() {
        return "Visualizacao{" + "espectador=" + espectador + ", filme=" + filme + '}';
    }
    
    
}
