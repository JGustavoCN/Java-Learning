package dominio;

// Interface é um tipo de classe abstrata (Interface é considerada um entidade)
// Porem, ela tem a pricipal funcao de ser a camada mais externa que permitimos -
// - que o usuario tenha contato
// Ex.: Os botoes são um tipo de interface, pois escodem do usuario os detalhes -
// - do funcionamento, apenas permitindo o acesso a algo generico e de facil comprensão
public interface MaisAcoesVideo {

//    As interfaces suportam todos os tipos de metodos
    void qualidadeVideo(int qualidadeVideo);

    void telaInteira(boolean telaInteira);

    String legenda(boolean ativarLegenda);

//    Metodos default não são obrigados a sobrescrever
//    São acessados por todas as classes que tenham essa interface
//    Precisam ter corpo -> {}
    default void miniPlayer() {
        System.out.println("MiniPlayer ativado");
    }

    default void modoTeatro() {
        System.out.println("Modo teatro ativado");
    }

//  Todas as variaveis de Interfaces sao constantes, ou seja, sao public static
//  Essa é a forma de escrever uma variavel constante;
//  Constantes precisam ser inicializadas
    String DOMINIO_DO_SITE = "youtube.com";

//  Metodos static são proprios da classe
//  Não podem ser sobrescritos
    static void disponibilidade(boolean disponibilidade) {
        if (disponibilidade) {
            System.out.println("Videos disponiveis");
        } else {
            System.out.println("Videos nao disponiveis");
        }

    }

}
