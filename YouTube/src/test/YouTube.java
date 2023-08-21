package test;

// SE não tiverem no mesmo pacote é preciso importar
import dominio.AcoesVideo;
import dominio.EnumSemana;
import dominio.Gafanhoto;
import dominio.MaisAcoesVideo;
import dominio.Video;
import java.util.Arrays;


public class YouTube {

    public static void main(String[] args) {

//      Nesse exemplo é utilizado uma variavel do tipo Object
//      Object é a classe mãe de todas as classes
//      Só é possivel devido a Object ser uma SuperClasse de Video
        Object video1 = new Video();
//      Porem criando um objeto dessa maneira só é porssivel acessar metodos que a SuperClasse suporta 
//      *Para ver os metodos da classe Object use o atalho Ctrl + Click do mouse sobre a palavra Object
//      Ex.: ( Tente acessar metodos da classe Video como o play() ) 
        video1.toString();

//      Interfaces não podem ser Instanciadas, ou seja, não podem criar um objeto delas
//      Isso ocorre, pois são classes abstratas
//      Ex.:
        // AcoesVideo exemplo = new AcoesVideo();
//      POREM é possivel criar uma variavel do tipo AcoesVideo
        // Ex.:
        AcoesVideo acoesVideo;

//      Tudo que ocorreu com esse instanciamento Object video1 = new Video(); VAI OCORRER AQUI
//      Porem, agora tem além dos metodos da classe Object os metodos da Interface AcoesVideo
        AcoesVideo video2 = new Video();
        // Ex.:  ( Tente acessar metodos da classe Video como o play() )
        video2.play();
        //Motivo
//      Para acessar uma mesma funcionalidade de uma interface com objetos diferentes -  
//      - é só criar uma variavel do tipo AcoesVideo

        Video staticVideo = new Video();
        MaisAcoesVideo staticMaisAcoesVideo = new Video();
//      Não é possivel acessar metodos static de uma classe com seus objetos
//      Ex.:
        // staticMaisAcoesVideo.disponibilidade(true);
        // staticVideo.disponibilidade(true);
//      Só é possivel acessar metodos static chamando a propria classe
        MaisAcoesVideo.disponibilidade(true);
        Video.disponibilidade(true);
        
//      Metodo default da interface MaisAcoesVideo
        staticMaisAcoesVideo.miniPlayer();
         
        try {
            Gafanhoto g = new Gafanhoto("Jose GUstavo", -17,'m');
        } catch (RuntimeException e) {
            System.out.println("erro: "+ e);

            e.printStackTrace();
        }
        
        double enumSemana = EnumSemana.DOMINGO.calcularDesconto(29);
        
        System.out.println(Arrays.toString(EnumSemana.values()));
    }
}
