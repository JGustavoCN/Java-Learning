package dominio;

import javax.swing.JOptionPane;

public class Pessoa {

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

    protected String nome;
    protected int idade;
    protected char sexo;
    protected TipoSexo tipoSexo;

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

    public static int format(int idade) {
        if (idade >= 0) {
            return idade;
        }
        JOptionPane.showMessageDialog(null, "Idade: " + idade + "\n==> INVALIDA","Erro!",JOptionPane.ERROR_MESSAGE);
        return 0;
    }

    public static char format(char sexo) {
        sexo = Character.toUpperCase(sexo);
        if (sexo == 'M' || sexo == 'F') {
            return sexo;
        }
        JOptionPane.showMessageDialog(null, "Sexo: " + sexo + "\n==> INVALIDO","Erro!",JOptionPane.ERROR_MESSAGE);
        return '?';
    }

    protected static TipoSexo setTipoSexo(char sexo) {
        switch (Character.toUpperCase(sexo)) {
            case 'M':
                return TipoSexo.SEXO_MASCULINO;
            case 'F':
                return TipoSexo.SEXO_FEMININO;
            default:
                return TipoSexo.SEXO_INVALIDO;
        }
    }

    public void fazerAniver() {
        this.setIdade(this.getIdade() + 1);
    }

    public Pessoa(String nome, int idade, char sexo) {
        this.nome = Pessoa.format(nome);
        this.idade = Pessoa.format(idade);
        this.sexo = Pessoa.format(sexo);
        this.tipoSexo = Pessoa.setTipoSexo(sexo);
    }

    public Pessoa(String nome, int idade, char sexo, TipoSexo tipoSexo) {
        this(nome, idade, sexo);
        if (this.tipoSexo != tipoSexo) {
            JOptionPane.showMessageDialog(null, "TipoSexo: " + tipoSexo + "\nSexo: " + this.sexo + "\n==> INVALIDO (Diferentes)","Erro!",JOptionPane.ERROR_MESSAGE);
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
        this.tipoSexo = Pessoa.setTipoSexo(sexo);
        this.sexo = Pessoa.format(sexo);
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome = " + nome + ", idade = " + idade
                + ", sexo = " + sexo + ", TipoSexo = " + tipoSexo + ", TipoSexoInt = " + tipoSexo.VALOR + '}';
    }

}
