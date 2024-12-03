package br.edu.ifs.pp.atividades.proxy;

/**
 *
 * @author José Gustavo
 */
public class VideoProxy implements Video {
    
    private String nome;
    private VideoReal videoReal;
    
    public VideoProxy(String nome) {
        this.nome = nome;
    }

    @Override
    public void reproduzir() {
        // Se o vídeo real ainda não foi carregado, carregamos ele agora
        if (videoReal == null) {
            videoReal = new VideoReal(nome); // Carregando o vídeo real
        }
        videoReal.reproduzir(); // Chama o método reproduzir do vídeo real
    }
}
