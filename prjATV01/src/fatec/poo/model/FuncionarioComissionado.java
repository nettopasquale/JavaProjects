
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
    }
    
    public double getTaxaComissao(){
        return taxaComissao;
    }
    
    public void addVendas(double valVenda){
        totalVendas = 0;
        totalVendas+=valVenda;
    }

    @Override
    public double calcSalBruto() {
        return(salBase + (taxaComissao * totalVendas));
    }

    public double calcGratificacao(){
        if(totalVendas > 10000)
            return (0.05 * calcSalBruto());
        else if(totalVendas > 5000 && totalVendas <= 10000)
            return (0.03 * calcSalBruto());
        else
            return 0;
    }
    
    @Override
    public double calcSalLiquido(){
        return((calcSalBruto() - calcDesconto()) + calcGratificacao());
    }
    
    
}
