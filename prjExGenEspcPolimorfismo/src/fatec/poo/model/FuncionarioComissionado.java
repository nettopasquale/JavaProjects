
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
        return taxaComissao;
    }
    
    public double getTaxaComissao(){
        return totalVendas;
    }
    
    public void addVendas(double valVenda){
        totalVendas = 0;
        totalVendas+=valVenda;
    }

    @Override
    public double calcSalBruto() {
        return((salBase + taxaComissao) * totalVendas);
    }
    /*
    public double calcGratificacao(){
        
        if(totalVendas > 5000 || totalVendas <= 10000)
             
        /*
        switch(true){
            case (totalVendas > 5000):
                taxaComissao = 0;
                break;
            default:
                taxaComissao = 0;
        }
        
    }
    */
    
    @Override
    public double calcSalLiquido(){
        return((calcSalBruto() - calcDesconto()) + 0);
    }
    
    
}
