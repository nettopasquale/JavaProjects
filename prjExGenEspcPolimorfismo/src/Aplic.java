
import fatec.poo.model.FuncionarioHorista;
import fatec.poo.model.FuncionarioMensalista;
import java.text.DecimalFormat;

public class Aplic {

    public static void main(String[] args) {
        FuncionarioHorista funcHor = new FuncionarioHorista(1010, "Pedro Silveira", "14/05/1978", 15.80);
        FuncionarioMensalista funcMen = new FuncionarioMensalista(0010, "Silveira Pereira", "05/12/1978", 1200.80);
        //Conversao dos decimais dos doubles
        DecimalFormat df = new DecimalFormat("#,##0.00");
        
        funcHor.setQtdeHorTrab(90);
        funcHor.setCargo("Desenvolvedor Front");
        funcMen.setNumSalMin(3);
        funcMen.setCargo("Gestor Redes");
        
        //Funcionario Horista
        System.out.println("Salario Bruto  =>" + df.format(funcHor.calcSalBruto()));
        System.out.println("Salario Desconto  =>" + df.format(funcHor.calcDesconto()));
        System.out.println("Gratificacao Fun. Horista  =>" + df.format(funcHor.calcGratificacao()));
        System.out.println("Salario Liquido Fun. Horista  =>" + df.format(funcHor.calcSalLiquido()));
        System.out.println("Registro Fun. Horista  =>" + funcHor.getRegistro());
        System.out.println("Nome Fun. Horista  =>" + funcHor.getNome());
        System.out.println("Data Admissao Fun. Horista  =>" + funcHor.getAdmss());
        System.out.println("Cargo Fun. Horista  =>" + funcHor.getCargo());

        System.out.println();
        
        // Funcionario Mensalista
        System.out.println("Salario Bruto  =>" + df.format(funcMen.calcSalBruto()));
        System.out.println("Salario Desconto  =>" + df.format(funcMen.calcDesconto()));
        System.out.println("Salario Liquido  =>" + df.format(funcMen.calcSalLiquido()));
        System.out.println("Registro Fun. Mensalista  =>" + funcMen.getRegistro());
        System.out.println("Nome Fun. Mensalista  =>" + funcMen.getNome());
        System.out.println("Data Admissao Fun. Mensalista =>" + funcMen.getAdmss());
        System.out.println("Cargo Fun. Mensalista =>" + funcMen.getCargo());
    }
    
}
