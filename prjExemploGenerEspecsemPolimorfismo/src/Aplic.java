
import fatec.poo.model.Aluno;
import fatec.poo.model.Professor;

public class Aplic {
    public static void main(String[] args) {       
       //Instanciação de um objeto da classe Aluno
       Aluno objAlu = new Aluno(1010,
                                "Carlos Silveira", 
                                "15/03/1978");
       
       // Instanciação de um objeto da classe Professor
       Professor objProf = new Professor(2102, "Pasquale Pereira", "15/10/1988");
    
      //passagem de mensagens - Aluno   
      objAlu.setMensalidade(1500);
      System.out.println("Registro escolar: " + objAlu.getRegEscolar());
      System.out.println("Nome: " + objAlu.getNome());
      System.out.println("Data de Nascimento: " + objAlu.getDataNascimento());
      System.out.println("Mensalidade: " + objAlu.getMensalidade()); 
      
      System.out.println(); 
      
      //passagem de mensagens - Professor
      objProf.setSalario(4500);
      System.out.println("Registro Funcional: " + objProf.getRegFuncional());
      System.out.println("Nome: " + objProf.getNome());
      System.out.println("Data de Nascimento: " + objProf.getDataNascimento());
      System.out.println("Salario: " + objProf.getSalario()); 
    }
}
