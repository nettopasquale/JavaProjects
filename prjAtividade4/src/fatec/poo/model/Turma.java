package fatec.poo.model;
import java.util.ArrayList;

public class Turma {
    private String sigla;
    private int qtdeVagas;
    private Curso curso;
    private Professor professor;
    private ArrayList<Aluno> alunos;

    public Turma(String sigla, int qtdeVagas) {
        this.sigla = sigla;
        this.qtdeVagas = qtdeVagas;
        alunos = new ArrayList<>();
    }
    public String getSigla() {
        return sigla;
    }
    public int getQtdeVagas() {
        return qtdeVagas;
    }
    public int getNumAlu() {
        return alunos.size();
    }    
    public Curso getCurso() {
        return curso;
    }
    public Professor getProfessor() {
        return professor;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }    
    public void addAluno(Aluno a){
        alunos.add(a);        
    }
    public void listarAlunos(){        
        System.out.println("\n\n*****Lista de Frequencia*****");
        System.out.println("\nSigla do Curso:" + curso.getSigla() +
                           "\t\tNome do Curso:" + curso.getDescricao() );
        System.out.println("Sigla da Turma:" + sigla);
        System.out.println("Nome do Professor: " + getProfessor().getNome());
         
        System.out.println("\n\t\tNome do Aluno");
        for (int x = 0; x < alunos.size(); x++){
           System.out.println((x+1) + " - " + alunos.get(x).getNome());
       }
    }
}


