package br.edu.ifs.pp.atividades.proxy;

/**
 *
 * @author José Gustavo
 */
public class VideoReal implements Video {
    
    private String nome;
    
    // Construtor onde o vídeo é carregado
    public VideoReal(String nome) {
        this.nome = nome;
        carregarVideo();
    }
    
    // Carrega o vídeo (simulando um processo demorado)
    private void carregarVideo() {
        System.out.println("Carregando vídeo: " + nome + "...");
        try {
            Thread.sleep(3000); // Simulando o tempo de carregamento do vídeo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Vídeo " + nome + " carregado.");
    }
    
    @Override
    public void reproduzir() {
        System.out.println("Reproduzindo o vídeo: " + nome);
    }
}
