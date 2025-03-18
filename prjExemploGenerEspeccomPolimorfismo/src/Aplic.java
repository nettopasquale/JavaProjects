
public class Aplic {

    public static void main(String[] args) {
        FuncionarioHorista funcHor = new FuncionarioHorista(1010, "Pedro Silveira", "14/05/1978", "Desenvolvedor Front", 15.80);
        FuncionarioMensalista funcMen = new FuncionarioMensalista(0010, "Silveira Pereira", "05/12/1978", "Gestor Redes", 1200.80);
        
        funcHor.setQtdeHorTrab(90);
        funcMen.setNumSalMin(3);
        
        //Funcionario Horista
        System.out.println("Salario Bruto  =>" + funcHor.calcSalBruto());
        System.out.println("Salario Desconto  =>" + funcHor.calcDesconto());
        System.out.println("Gratificacao Fun. Horista  =>" + funcHor.calcGratificacao());
        System.out.println("Salario Liquido Fun. Horista  =>" + funcHor.calcSalLiquido());
        System.out.println("Registro Fun. Horista  =>" + funcHor.getRegistro());
        System.out.println("Nome Fun. Horista  =>" + funcHor.getNome());
        System.out.println("Data Admissao Fun. Horista  =>" + funcHor.getAdmss());
        System.out.println("Cargo Fun. Horista  =>" + funcHor.getCargo());

        
        System.out.println();
        
        // Funcionario Mensalista
        System.out.println("Salario Bruto  =>" + funcMen.calcSalBruto());
        System.out.println("Salario Desconto  =>" + funcMen.calcDesconto());
        System.out.println("Salario Liquido  =>" + funcMen.calcSalLiquido());
        System.out.println("Registro Fun. Mensalista  =>" + funcMen.getRegistro());
        System.out.println("Nome Fun. Mensalista  =>" + funcMen.getNome());
        System.out.println("Data Admissao Fun. Mensalista =>" + funcMen.getAdmss());
        System.out.println("Cargo Fun. Mensalista =>" + funcMen.getCargo());
    }
    
}
