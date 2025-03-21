
import fatec.poo.model.FuncionarioComissionado;
import fatec.poo.model.FuncionarioHorista;
import fatec.poo.model.FuncionarioMensalista;
import java.text.DecimalFormat;

public class Aplic {

    public static void main(String[] args) {
        FuncionarioHorista funcHor = new FuncionarioHorista(1010, "Pedro Silveira", "14/05/1978", 15.80);
        FuncionarioMensalista funcMen = new FuncionarioMensalista(0010, "Silveira Pereira", "05/12/1978", 1200.80);
        FuncionarioComissionado funcComi = new FuncionarioComissionado(2010, "Pasquale Mil", "15/10/1992", 0.20);
        //Conversao dos decimais dos doubles
        DecimalFormat df = new DecimalFormat("#,##0.00");
        
        funcHor.setQtdeHorTrab(90);
        funcHor.setCargo("Desenvolvedor Front");
        
        funcMen.setNumSalMin(3);
        funcMen.setCargo("Gestor Redes");
        
        funcComi.setSalBase(1500);
        funcComi.setCargo("QA Tester");
        funcComi.addVendas(6000); //Venda total R$ 6000,00
        
        //Funcionario Horista
        System.out.println("Funcionário Horista: ");
        System.out.println("Registro: " + funcHor.getRegistro());
        System.out.println("Nome: " + funcHor.getNome());
        System.out.println("Data Admissao: " + funcHor.getAdmss());
        System.out.println("Cargo: " + funcHor.getCargo());
        System.out.println("Salario Bruto: " + df.format(funcHor.calcSalBruto()));
        System.out.println("Salario Desconto: " + df.format(funcHor.calcDesconto()));
        System.out.println("Gratificacao Fun. Horista: " + df.format(funcHor.calcGratificacao()));
        System.out.println("Salario Liquido Fun. Horista: " + df.format(funcHor.calcSalLiquido()));

        System.out.println();
        
        // Funcionario Mensalista
        System.out.println("Funcionário Mensalista: ");
        System.out.println("Registro: " + funcMen.getRegistro());
        System.out.println("Nome: " + funcMen.getNome());
        System.out.println("Data Admissao: " + funcMen.getAdmss());
        System.out.println("Cargo: " + funcMen.getCargo());
        System.out.println("Salario Bruto: " + df.format(funcMen.calcSalBruto()));
        System.out.println("Salario Desconto: " + df.format(funcMen.calcDesconto()));
        System.out.println("Salario Liquido: " + df.format(funcMen.calcSalLiquido()));
        
        System.out.println();
        
        //Funcionario Comissionado
        System.out.println("Funcionário Comissionado: ");
        System.out.println("Registro: " + funcComi.getRegistro());
        System.out.println("Nome: " + funcComi.getNome());
        System.out.println("Data Admissao: " + funcComi.getAdmss());
        System.out.println("Cargo: " + funcComi.getCargo());
        System.out.println("Taxa Comissao: " + funcComi.getTaxaComissao() + "%");
        System.out.println("Total Vendas: R$" + funcComi.getTotalVendas());
        System.out.println("Salario Bruto: " + df.format(funcComi.calcSalBruto()));
        System.out.println("Salario Gratificacao: " + df.format(funcComi.calcGratificacao()));
        System.out.println("Salario Desconto: " + df.format(funcComi.calcDesconto()));
        System.out.println("Salario Liquido: " + df.format(funcComi.calcSalLiquido()));
        
    }
    
}
