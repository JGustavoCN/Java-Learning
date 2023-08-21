package dominio;

public class Cachorro extends Lobo {

    @Override
    public void emitirSom(){
        System.out.println("Au Au Au Au Au");
    }
    
    @Override
    public void alimentar(String alimento){
        System.out.println("Comendo "+alimento);
    }
    
}
