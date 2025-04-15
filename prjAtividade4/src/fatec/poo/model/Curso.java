package fatec.poo.model;

public class Curso {
    private String sigla;
    private String descricao;
    private String cargaHoraria;

    public Curso(String sigla, String descricao, String cargaHoraria) {
        this.sigla = sigla;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }        
    public String getDescricao(){
        return(descricao);
    }
    public String getCargaHoraria(){
        return(cargaHoraria);
    }
    public String getSigla(){
        return(sigla);
    }
}
