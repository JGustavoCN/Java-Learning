package Seminario;

public class Seminario {

    private String titulo;
    private Estudante[] estudantes;
    private Professor professor;
    private Local local;

    public Seminario(String titulo, Professor professor, Local local) {
        this.titulo = titulo;
        this.professor = professor;
        this.local = local;

    }

    public Seminario(String titulo, Professor professor, Local local, Estudante... estudantes) {
        this(titulo, professor, local);
        this.estudantes = estudantes;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Estudante[] getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(Estudante... estudantes) {
        this.estudantes = estudantes;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public void Imprime() {
        
        System.out.println("Titulo: " + this.getTitulo());
        System.out.println("Professor: " + professor.getNome() + " Especialidade: "+ this.getProfessor().getEspecialidade());
        System.out.println("Local: " + this.getLocal().getEndereco());
        if (this.estudantes != null);
        for (Estudante estudante : estudantes) {
            System.out.println("Estudante: " + estudante.getNome() + " Idade: "+estudante.getIdade());
        }
        

    }

}
