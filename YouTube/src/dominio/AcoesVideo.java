package dominio;

//Se é interface logo foi projetado para ser implementado 
public interface AcoesVideo {

//  Não é possivel criar um construtor, pois interface é o mais alto nivel de abstração
//  Ex.:
    //public AcoesVideo(){}
    
//  A ideia da interface é ser acessivel para quem vai usar, ou seja, - 
//  - não podem ser nada alem de public
    // Por padrao os metodos sao public abstract  
    // Abaixo sao todos iguais apenas mudando o que esta oculto do "public abstract"
    // Não podem ter corpo, ou seja, não podem ter chaves {} 
    public void play();

    abstract void pause();

    public abstract void like();

    void pular();

    void voltar();
}
