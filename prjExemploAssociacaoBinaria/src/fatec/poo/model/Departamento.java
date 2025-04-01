import java.util.ArrayList;
import java.util.List;
package fatec.poo.model;

public class Departamento {
    private String sigla, nome;
    private int numFunc;
    //private Funcionario funcionarios[]; 
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>(); 

    public Departamento(String sigla, String nome) {
        this.sigla = sigla;
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }
	
	public void addFuncionario(Funcionario f){
        funcionarios.add(f);
    }
    
    public void listaFuncionarios(){
        for(Funcionario funcionario: funcionarios ){
            System.out.println(funcionario.getNome());
        }
    }
    
    
}
