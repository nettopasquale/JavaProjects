
package fatec.poo.model;

public class FuncionarioHorista extends Funcionario {
    private double valHorTrab;
    private int qtdeHorTrab;

    public FuncionarioHorista(int r, String n, String dtAdm, double vht) {
        super(r, n, dtAdm);
        this.valHorTrab = vht;
    }

    @Override
    public double calcSalBruto() {
        return (valHorTrab * qtdeHorTrab);
    }
    
    public void setQtdeHorTrab(int qtdeHT){
        qtdeHorTrab = qtdeHT;
    }
    
}
