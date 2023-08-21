package dominio;

public class Gafanhoto extends Pessoa{
    
    private String login;
    private int totalAssistidos;
    
    /**
     * 
     * @param nome
     * @param idade Não pode receber números negativos
     * @param sexo M = masculino, F = Feminino
     * @throws IllegalArgumentException caso idade seja negativa
     */
    public Gafanhoto(String nome, int idade, char sexo) {
//      super é usado para se referir a classe mãe
//      È obrigatorio na chamada de um construtor dentro de outro que ele seja a primeira linha
        super(nome, idade, sexo);
    }
    
    public Gafanhoto(String nome, int idade, char sexo, String login) {
//      this é usado para se referir a propria classe
//      Isso só pode ser feito de um contrutor mais abrangete para um menos
        this(nome,idade, sexo);
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getTotalAssistidos() {
        return totalAssistidos;
    }

    public void setTotalAssistidos(int totalAssistidos) {
        this.totalAssistidos = totalAssistidos;
    }

    @Override
    public String toString() {
        return "Gafanhoto{" + super.toString()+ " login = " + login + ", "
                + "totalAssistidos = " + totalAssistidos + '}';
    }
    
    @Override
    public void fazerAniver() {
        this.setIdade(this.getIdade() + 1);
        System.out.println("Parabens");
    }

    @Override
    public void ganharExp() {

    }
}
