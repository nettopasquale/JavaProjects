//package trab02lp;

import fatec.poo.model.Aluno;
import fatec.poo.model.Curso;
import fatec.poo.model.Professor;
import fatec.poo.model.Turma;
import java.util.Scanner;

/**
 *
 * @author Dimas
 */

public class Aplic {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Aluno[] tabAluno = new Aluno[2];

        String sigla, descri, carHor, regFunc, raAlu, nome;  
        int qtdeVagas;
        
        System.out.print("Sigla do Curso: ");
        sigla = entrada.next();
        System.out.print("Descricao do Curso: ");
        descri = entrada.next();
        System.out.print("Carga Horaria: ");
        carHor = entrada.next();

        Curso objCurso = new Curso(sigla, descri, carHor);

        System.out.print("\nRegistro Funcional do Professor: ");
        regFunc = entrada.next();
        System.out.print("Nome: ");
        nome = entrada.next();
        Professor objProfessor = new Professor(regFunc, nome);

        System.out.print("Data de Nascimento: ");
        objProfessor.setDtNascimento(entrada.next());
        System.out.print("Endereço: ");
        objProfessor.setEndereco(entrada.next());
        System.out.print("Cidade: ");
        objProfessor.setCidade(entrada.next());
        
        System.out.print("Titularidade("
                          + "1-Especialista "
                          + "2-Mestre "
                          + "3-Doutor): ");
        objProfessor.setTitularidade(entrada.nextInt());
        System.out.print("Area de Atuacao("
                          + "1-Desenvolvimento "
                          + "2-Banco de Dados "
                          + "3-Redes): ");
        objProfessor.setAreaAtuacao(entrada.nextInt());
       
        System.out.print("\nSigla da Turma: ");
        sigla = entrada.next();
        System.out.print("Quantidade de Vagas: ");
        qtdeVagas = entrada.nextInt();        
        Turma objTurma = new Turma(sigla, qtdeVagas);

        //Efetivando a ligação entre os objetos
        objTurma.setCurso(objCurso);
        objTurma.setProfessor(objProfessor);
        objProfessor.addTurma(objTurma);       
        
        for (int cont = 0; cont < tabAluno.length; cont++) {
            System.out.print("\nRA do Aluno: ");
            raAlu = entrada.next();
            System.out.print("Nome: ");
            nome = entrada.next();
            tabAluno[cont] = new Aluno(raAlu, nome);
            
            System.out.print("Data de Nascimento: ");
            tabAluno[cont].setDtNascimento(entrada.next());
            System.out.println("Endereço: ");
            tabAluno[cont].setEndereco(entrada.next());
            System.out.println("Cidade: ");
            tabAluno[cont].setCidade(entrada.next());
            System.out.println("Escolaridade("
                                + "1-Ensino Medio "
                                + "2-Ensino Tecnico "
                                + "3-Ensino Superior): ");
            tabAluno[cont].setEscolaridade(entrada.nextInt()); 
            objTurma.addAluno(tabAluno[cont]);        
        }
        
        objTurma.listarAlunos();
    }
}
