
import fatec.poo.model.PessoaFisica;
import fatec.poo.model.PessoaJuridica;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Aplic {

    public static void main(String[] args) {
        PessoaFisica pessoaF = new PessoaFisica("419020", "Pasquale M.", 1992);
        PessoaJuridica pessoaJ = new PessoaJuridica("020914", "Dimalaia do Norte", 1970);
        Scanner entrada = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,##0.00");
        
        double compraPessoaF, compraPessoaJ;
        
        pessoaF.setBase(1500);
        pessoaJ.setTaxaIncentivo(20);
        
        
    }
    
}
