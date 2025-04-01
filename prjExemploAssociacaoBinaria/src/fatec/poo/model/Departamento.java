
package fatec.poo.model;

public class Departamento {
    private String sigla, nome;
    private int numFunc;
    private Funcionario[] funcionarios;

    public Departamento(String sigla, String nome) {
        this.sigla = sigla;
        this.nome = nome;
        funcionarios = new Funcionario[5];
        numFunc = 0;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }
    
    public void addFuncionario(Funcionario f){
        funcionarios[numFunc++] = f;
    }
    
    public void listaFuncionarios(){
        System.out.println("Sigla: " + getSigla());
        System.out.println("Nome: " + getNome());
        System.out.println("Qtde de funcionarios: " + funcionarios.length);
        System.out.println("Registro\tNome\tCargo\t");
        for(int i = 0; i < funcionarios.length; i++){
            System.out.println(funcionarios[i].getRegistro()+ "\t" 
                    + funcionarios[i].getNome() + "\t" 
                    + funcionarios[i].getCargo());
        }
    }
    
    
}
