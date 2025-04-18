package fatec.poo.model;

public class FuncionarioComissionado extends Funcionario{
    private double salBase, taxaComissao, totalVendas;
    
    public FuncionarioComissionado(int r, String n, String dtAdm, double txc){
        super(r,n,dtAdm);
        this.taxaComissao = txc;
    }
    
    public void setSalBase(double sb){
        salBase = sb;
    }
    
    public double getSalBase(){
        return salBase;
    }
    
    public double getTotalVendas(){
        return totalVendas;
<<<<<<< HEAD
=======
    }
    
    public double getTaxaComissao(){
        return taxaComissao;
>>>>>>> 31bb82845696b6bb9c77a837b13c86df668b66ba
    }
    
    public double getTaxaComissao(){
        return taxaComissao;
    }
    
    public void addVendas(double valVenda){
        totalVendas+= valVenda;
    }

    @Override
    public double calcSalBruto() {
<<<<<<< HEAD
        return(salBase + ((taxaComissao * totalVendas))/100);
    }

    public double calcGratificacao(){
        
        if(totalVendas > 10000){
            return(calcSalBruto() * 0.05);
        }
        else if(totalVendas > 5000 || totalVendas <= 10000){
            return(calcSalBruto() * 0.03);
        }
        else{
            return 0;
        }
=======
        return(salBase + (taxaComissao * totalVendas));
    }

    public double calcGratificacao(){
        if(totalVendas > 10000)
            return (0.05 * calcSalBruto());
        else if(totalVendas > 5000 && totalVendas <= 10000)
            return (0.03 * calcSalBruto());
        else
            return 0;
>>>>>>> 31bb82845696b6bb9c77a837b13c86df668b66ba
    }
    
    @Override
    public double calcSalLiquido(){
        return((calcSalBruto() - calcDesconto()) + calcGratificacao());
    }
    
    
}
