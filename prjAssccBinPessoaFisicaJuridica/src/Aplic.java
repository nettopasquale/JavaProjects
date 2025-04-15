
import fatec.poo.model.PedidoCompra;
import fatec.poo.model.PessoaFisica;
import fatec.poo.model.PessoaJuridica;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Aplic {

    public static void main(String[] args) {
        PessoaFisica  pessoaF;
        PessoaJuridica pessoaJ;
        PedidoCompra cadPedido;
        
        Scanner entrada = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,##0.00");
        
        double compraPessoaF, compraPessoaJ;
        String cpf_cgc, nome;
        int anoInscr;
        
        System.out.println("Por favor informe o cpf da pessoa Física: ");
        cpf_cgc = entrada.next();
        
        System.out.println("Por favor informe o nome da pessoa Física: ");
        nome = entrada.next();
        
        System.out.println("Por favor informe o ano de inscr. da pessoa Física: ");
        anoInscr = entrada.nextInt();
        
        pessoaF = new PessoaFisica(cpf_cgc, nome, anoInscr);
        
        System.out.println("Por favor informe o valor base de salario da pessoa Física: ");
        pessoaF.setBase(entrada.nextInt());
        
        System.out.println("Por favor informe o cpf da pessoa Juridica: ");
        cpf_cgc = entrada.next();
        
        System.out.println("Por favor informe o nome da pessoa Juridica: ");
        nome = entrada.next();
        
        System.out.println("Por favor informe o ano de inscr. da pessoa Juridica: ");
        anoInscr = entrada.nextInt();
        
        pessoaJ = new PessoaJuridica(cpf_cgc, nome, anoInscr);
        
        System.out.println("Por favor informe a taxa de incentivo da pessoa Juridica: ");
        pessoaJ.setTaxaIncentivo(entrada.nextInt());
        
        
        System.out.println("Por favor informe a compra da pessoa Física: ");
        compraPessoaF = entrada.nextDouble();
        
        System.out.println("Por favor informe a compra da pessoa Juridica: ");
        compraPessoaJ = entrada.nextDouble();
        
        
        while(compraPessoaF > 0 || compraPessoaJ > 0){
            pessoaF.addCompras(compraPessoaF);
            
            pessoaJ.addCompras(compraPessoaJ);
            
            System.out.println("Por favor informe a compra da pessoa Física.");
            System.out.println("Se desejar sair, informe o valor 0: ");
            compraPessoaF = entrada.nextDouble();
        
        
            System.out.println("Por favor informe a compra da pessoa Juridica: ");
            System.out.println("Se desejar sair, informe o valor 0: ");
            compraPessoaJ = entrada.nextDouble();
            
        }
        
        
        
        //Pessoa Física
        System.out.println("Pessoa Fisica: ");
        System.out.println("CPF: " + pessoaF.getCPF());
        System.out.println("Nome: " + pessoaF.getNome());
        System.out.println("Ano de Inscr.: " + pessoaF.getAnoInscricao());
        System.out.println("Sarario Base: R$" + df.format(pessoaF.getBase()));
        System.out.println("Total Compras: R$" + df.format(pessoaF.getTotalCompras()));
        System.out.println("Valor total do Bonus: R$" + df.format(pessoaF.calcBonus(pessoaF.getAnoInscricao())));

        System.out.println();
        
        // Pessoa Juridica
        System.out.println("Pessoa Juridica: ");
        System.out.println("CGC: " + pessoaJ.getCGC());
        System.out.println("Nome: " + pessoaJ.getNome());
        System.out.println("Ano de Inscr.: " + pessoaJ.getAnoInscricao());
        System.out.println("Taxa de Incentivo: " + df.format(pessoaJ.getTaxaIncentivo()) + "%");
        System.out.println("Total Compras: R$" + df.format(pessoaJ.getTotalCompras()));
        System.out.println("Valor total do Bonus: R$" + df.format(pessoaJ.calcBonus(pessoaJ.getAnoInscricao())));

    }
    
}
