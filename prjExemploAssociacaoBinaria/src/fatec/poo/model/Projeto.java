
package fatec.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Projeto {
    private int codigo;
    private String descricao, dtInicio, dtTermino;
    private List<Funcionario> funcionarios;

    public Projeto(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
        funcionarios = new ArrayList<Funcionario>();
    }

    public void setDtInicio(String dtInicio) {
        this.dtInicio = dtInicio;
    }

    public void setDtTermino(String dtTermino) {
        this.dtTermino = dtTermino;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDtInicio() {
        return dtInicio;
    }

    public String getDtTermino() {
        return dtTermino;
    }
    
    public void addFuncionario(Funcionario f){
        funcionarios.add(f);
    }
    
    public void listaFuncionarios(){
        System.out.println("Codigo: " + getCodigo());
        System.out.println("Descricao: " + getDescricao());
        System.out.println("Data Inicio: " + getDtInicio());
        System.out.println("Data Termino: " + getDtTermino());
        System.out.println("Qtde. Funcionarios: " + funcionarios.size());
        System.out.println("Registro\tNome\tCargo\tDepartamento\t");
        for(Funcionario f: funcionarios){
            System.out.println(f.getRegistro()+ "\t" 
                    + f.getNome() + "\t" 
                    + f.getCargo() + "\t" 
                    + f.getDepartamento() + "\t");
        }
    }
    
}
