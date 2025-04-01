
import fatec.poo.model.Departamento;
import fatec.poo.model.FuncionarioComissionado;
import fatec.poo.model.FuncionarioHorista;
import fatec.poo.model.FuncionarioMensalista;
import fatec.poo.model.Projeto;

public class Aplic {
    public static void main(String[] args) {
        FuncionarioHorista funcHor = new FuncionarioHorista(1010,
                                                            "Pedro Silveira",
                                                            "14/05/1978",
                                                            15.80);
        FuncionarioMensalista funcMen = new FuncionarioMensalista(2020,
                                                                  "Ana Beatriz", 
                                                                  "22/10/1997",
                                                                  600.0);
        
        FuncionarioComissionado funcCom = new FuncionarioComissionado(3030, 
                                                                      "Joao Mendes",
                                                                      "10/12/1975",
                                                                      10);
        Departamento depto1 = new Departamento("CP", "Compras");
        Departamento depto2 = new Departamento("VD", "Vendas");
        
        Projeto proj1 = new Projeto(8990, "Terreno Neo");
        Projeto proj2 = new Projeto(8910, "Neo Shopping");
        
        funcHor.setCargo("Programador");
        funcHor.setDepartamento(depto1);
        funcHor.setProjeto(proj1);
        
        funcMen.setCargo("Aux. Administrativo");
        funcMen.setDepartamento(depto1);
        funcMen.setProjeto(proj1);
        
        funcCom.setCargo("Vendedor");
        funcCom.setDepartamento(depto2);
        funcCom.setProjeto(proj2);
        
        proj1.setDtInicio("01/02/2025");
        proj1.setDtTermino("30/06/2025");
        proj2.setDtInicio("01/08/2025");
        proj2.setDtTermino("10/12/2025");
     
        //Estabelece a associação entre um objeto da classse FuncionárioHorista
        //com um objeto da classe Departamento e Projeto
        System.out.println("O funcionario horista " + funcHor.getNome() + 
                " trabalha no departamento de "  + funcHor.getDepartamento().getNome()
                + "e faz parte do projeto de nome: " + funcHor.getProjeto().getDescricao()
                + "de data de inicio: " + funcHor.getProjeto().getDtInicio() 
                + " e data de termino de :" + funcHor.getProjeto().getDtTermino());
    
        //Estabelece a associação entre um objeto da classse FuncionárioMensalista
        //com um objeto da classe Departamento e Projeto
        System.out.println("O funcionario mensalista" + funcMen.getNome() + 
                " trabalha no departamento de " +funcMen.getDepartamento().getNome()
                + "e faz parte do projeto de nome: " + funcMen.getProjeto().getDescricao()
                + "de data de inicio: " + funcMen.getProjeto().getDtInicio() 
                + " e data de termino de :" + funcMen.getProjeto().getDtTermino());
    
        //Estabelece a associação entre um objeto da classse FuncionárioComissionado
        //com um objeto da classe Departamento e Projeto
        System.out.println("O funcionario comissionado" + funcCom.getNome() + 
                " trabalha no departamento de " +funcCom.getDepartamento().getNome()
                + "e faz parte do projeto de nome: " + funcCom.getProjeto().getDescricao()
                + "de data de inicio: " + funcCom.getProjeto().getDtInicio() 
                + " e data de termino de :" + funcCom.getProjeto().getDtTermino());
    
        //Estabelece a associação entre um objeto da classe Departamento e Projeto com
        //um objeto das classes FuncionarioHorista e FuncionarioMensalista
        depto1.addFuncionario(funcHor);
        depto1.addFuncionario(funcMen);
        
        proj1.addFuncionario(funcHor);
        proj1.addFuncionario(funcMen);
        
        //depto1.listaFuncionarios();
        proj1.listaFuncionarios();
    
        //Estabelece a associação entre um objeto da classe Departamento e Projeto com
        //um objeto da classe FuncionarioComissionado
        depto2.addFuncionario(funcCom);
        
        proj2.addFuncionario(funcCom);
    
        //depto2.listaFuncionarios();
        proj2.listaFuncionarios();
        
   
    }    
}
