import fatec.poo.model.PessoaFisica;
import fatec.poo.model.PessoaJuridica;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Aplic {

    public static void main(String[] args) {
        PessoaFisica pessoaF = new PessoaFisica("4190208", "Pasquale M", 1992);
        PessoaJuridica pessoaJ = new PessoaJuridica("8020914", "Dimalaia do Norte", 1970);
        Scanner entrada = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,##0.00");
        
        int compras;
        
        //Salario Base Pessoa Física
        pessoaF.setBase(1500);
        // Taxa de Incentivo pessoa Juridica
        pessoaJ.setTaxaIncentivo(20);
        
        System.out.println("Por favor informe um valor de compras: ");
        compras = entrada.nextInt();
        
        while(compras > 0){
            pessoaF.addCompras(compras);
            
            pessoaJ.addCompras(compras);
            
            System.out.println("Por favor informe um valor de compras: ");
            compras = entrada.nextInt();
            
        }
            
            //Pessoa Física
            System.out.println("Pessoa Física: ");
            System.out.println("Olá " + pessoaF.getNome());
            System.out.println("Seu CPF eh: " + pessoaF.getCPF());
            System.out.println("Seu ano de Insc. eh: " + pessoaF.getAnoInscricao());
            System.out.println("Seu salario Base eh: " + df.format(pessoaF.getBase()));
            System.out.println("Seu total de compras eh: " + df.format(pessoaF.getTotalCompras()));
            System.out.println("Seu bonus total eh: " + df.format(pessoaF.calcBonus(pessoaF.getAnoInscricao())));
            
            //Pessoa Juridica
            System.out.println("Pessoa Juridica: ");
            System.out.println("Olá " + pessoaJ.getNome());
            System.out.println("Seu CGC eh: " + pessoaJ.getCGC());
            System.out.println("Seu ano de Insc. eh: " + pessoaJ.getAnoInscricao());
            System.out.println("Sua taxa de Incentivo eh: " + df.format(pessoaJ.getTaxaIncentivo()) + "%");
            System.out.println("Seu total de compras eh: " + df.format(pessoaJ.getTotalCompras()));
            System.out.println("Seu bonus total eh: " + df.format(pessoaJ.calcBonus(pessoaJ.getAnoInscricao())));

        
    }
    
}
