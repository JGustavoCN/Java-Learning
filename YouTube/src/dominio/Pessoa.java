package dominio;

import javax.swing.JOptionPane;

// Toda classe é uma extensão da Classe Object
// Podemos ocultar o extends Object da classe, pois isso ocorre por padrao
// Função de uma classe abstrata: Abstrair conceitos para futura implementação
// Ela foi feita para ser uma SuperClasse
// Ela serve tal qual uma classe serve de molde para um objeto, uma classe abstrata -
// - serve de molde para outra classe
public abstract class Pessoa extends Object {

    public enum TipoSexo {
        
        SEXO_MASCULINO(1),
        SEXO_FEMININO(2),
        SEXO_INVALIDO(3);

        public final int VALOR;

        private TipoSexo(int VALOR) {
            this.VALOR = VALOR;

        }

        public int getVALOR() {
            return VALOR;
        }

    }

//    protected é herdado pela subclasse
//    private é herdado pela subclasse porem não é visivel para ela
    private String nome;
    private int idade;
    private char sexo;
    private TipoSexo tipoSexo;
    private float experiencia;

//    metodos abstratos só podem existir em classes abstratas
//    Se o metodo é abstract é preciso sobrescrever nas subclasses (somente uma vez)
//    Se tenho uma classe abstrata (2) extends outra classe abstrata (1) por padrao -
//    - os metodos da (1) nao precisam ser sobrecritos na (2), so precisam ser sobrecritos nas -
//    - subclasses da (2), porem se sobrescrever na (2) as subclasses dela não vao mais serem -
//    - obrigadas a sobrescrever os metodos abstratos da (1)
    public abstract void ganharExp();

    public static String format(String nome) {
        
        String nomeFormatado = "";

        for (int i = 0; i < nome.length(); i++) {

            if (i == 0 || nome.charAt((i - 1)) == ' ') {
                if (nome.charAt(i) == Character.toLowerCase(nome.charAt(i)) || nome.charAt(i) == Character.toUpperCase(nome.charAt(i))) {
                    nomeFormatado = nomeFormatado + Character.toString(Character.toUpperCase(nome.charAt(i)));
                    continue;
                }
            }
            nomeFormatado = nomeFormatado + Character.toString(Character.toLowerCase(nome.charAt(i)));
        }
        return nomeFormatado;
    }

    /**
     *
     * @param idade Não pode receber números negativos
     * @return
     * @throws IllegalArgumentException caso idade seja negativa
     */
    public static int format(int idade) {

        if (idade < 0) {
            JOptionPane.showMessageDialog(null, "Idade: " + idade + "\n==> INVALIDA", "Erro!", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Não é aceito números negativos");
        }
        return idade;

    }

    public static char format(char sexo) {
        sexo = Character.toUpperCase(sexo);
        if (sexo == 'M' || sexo == 'F') {
            return sexo;
        }
        JOptionPane.showMessageDialog(null, "Sexo: " + sexo + "\n==> INVALIDO", "Erro!", JOptionPane.ERROR_MESSAGE);
        return '?';
    }

    private void setTipoSexo(char sexo) {
        switch (Character.toUpperCase(sexo)) {
            case 'M':
                this.tipoSexo = TipoSexo.SEXO_MASCULINO;

            case 'F':
                this.tipoSexo = TipoSexo.SEXO_FEMININO;

            default:
                this.tipoSexo = TipoSexo.SEXO_INVALIDO;

        }
    }

    public void fazerAniver() {
        this.setIdade(this.getIdade() + 1);
    }

//  Por ser um molde é possivel criar um construtor padrao para as suas subclasses
    /**
     *
     * @param nome
     * @param idade Não pode receber números negativos
     * @throws IllegalArgumentException caso idade seja negativa
     * @param sexo M = masculino, F = Feminino
     */
    public Pessoa(String nome, int idade, char sexo) {

//      É possivel chamar o metodo fomart, pois é da classe (static), ou seja, -
//      foi criado antes da instancia do objeto ( Segue a ordem de inicializacao que esta no doc )
        this.nome = Pessoa.format(nome);
        this.idade = Pessoa.format(idade);
        this.sexo = Pessoa.format(sexo);

//      Para poder usar metodos que nao sejam static é preciso garantir que nao serao sobrescritos -
//      -, ou seja , é preciso usar private ou final, mas mesmo sem isso vai funcionar -
//      - porem a prioridade de execucao é da subclasse que sobrescrevel
//      Ex.:
        this.setTipoSexo(sexo);
        // this.setIdade(idade);
    }

//  Construtores podem ser sobrecaregados 
    public Pessoa(String nome, int idade, char sexo, TipoSexo tipoSexo) {
        this(nome, idade, sexo);
        if (this.tipoSexo != tipoSexo) {
            JOptionPane.showMessageDialog(null, "TipoSexo: " + tipoSexo + "\nSexo: " + this.sexo + "\n==> INVALIDO (Diferentes)", "Erro!", JOptionPane.ERROR_MESSAGE);
            this.tipoSexo = tipoSexo;
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        this.nome = Pessoa.format(nome);
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = Pessoa.format(idade);
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.setTipoSexo(sexo);
        this.sexo = Pessoa.format(sexo);
    }

    public float getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(float experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome = " + nome + ", idade = " + idade
                + ", sexo = " + sexo + ", TipoSexo = " + tipoSexo + ", "
                + "TipoSexoInt = " + tipoSexo.VALOR + '}';
    }

}
