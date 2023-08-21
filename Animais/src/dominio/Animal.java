package dominio;

public abstract class Animal {
    
    protected int peso;
    protected int idade;
    protected int membros;

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getMembros() {
        return membros;
    }

    public void setMembros(int membros) {
        this.membros = membros;
    }
    
    public abstract void locomover();
    public abstract void alimentar();
    public void alimentar(String alimento){
        System.out.println("Comendo "+alimento);
    }
    public abstract void emitirSom();
    
}
