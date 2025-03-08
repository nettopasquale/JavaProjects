import fatec.poo.model.Aluno;
import java.util.Scanner;

public class Aplic {

    public static void main(String[] args) {
        // Descrição dos ponteiros dos objetos
        Scanner entrada = new Scanner(System.in);
        Aluno aluno = new Aluno();
        int ent_RA, ent_opcao;
        double prova1, prova2, trab1, trab2;
        boolean opcao = true;

        System.out.println("Digite seu RA: ");
        ent_RA = entrada.nextInt();
        aluno.setRA(ent_RA);
            
        System.out.println("Digite a nota da primeira prova: ");
        prova1 = entrada.nextDouble();
        aluno.setNtPrv1(prova1);
          
        System.out.println("Digite a nota da segunda prova: ");
        prova2 = entrada.nextDouble();
        aluno.setNtPrv2(prova2);
            
        System.out.println("Digite a nota do primeiro trabalho: ");
        trab1 = entrada.nextDouble();
        aluno.setNtTrab1(trab1);
            
        System.out.println("Digite a nota do segundo trabalho: ");
        trab2 = entrada.nextDouble();
        aluno.setNtTrab2(trab2);
        
        while(opcao){                     
            System.out.println(""
                    + "1 - Exibir Nota das Provas/Trabalhos\n"
                    + "2 - Exibir Media dos Trabalhos/Provas\n"
                    + "3 - Exibir Media Final\n"
                    + "4 - Sair\n"
                    + ""
                    + "Digite a opcao: ");

            ent_opcao = entrada.nextInt();

            if(ent_opcao == 1){
                System.out.println("RA do aluno: " + aluno.getRA());
                System.out.println("A nota da primeira prova eh: " + aluno.getNtPrv1());
                System.out.println("A nota da segunda prova eh: " + aluno.getNtPrv2());
                System.out.println("A nota do primeiro trabalho eh: " + aluno.getNtTrab1());
                System.out.println("A nota do segundo trabalho eh: " + aluno.getNtTrab2());
            }
            else if(ent_opcao == 2){
                System.out.println("RA do aluno: " + aluno.getRA());
                System.out.println("A media das provas do aluno eh: " + aluno.calcMediaProva());
                System.out.println("A media dos do aluno eh: " + aluno.calcMediaTrab());
            }
            else if(ent_opcao == 3){
                System.out.println("RA do aluno: " + aluno.getRA());
                System.out.println("A media final do aluno eh: " + aluno.calcMediaFinal());
            }
            else if(ent_opcao == 4){
                System.out.println("Saindo...ate mais! ");
                opcao = false;
            }
            else{
                System.out.println("Digite uma opcao valida!");
            }
            
            System.out.println("\n");            
        }
    
    }
    
}
