package fatec.poo.model;

public class Instrutor extends Pessoa{
    private int identificacao;
    private String areaAtuacao;

    //constructor
    public Instrutor(int id, String n, String tel) {
        super(n, tel);
        identificacao = id;
    }

    public void setAreaAtuacao(String area) {
        areaAtuacao = area;
    }
    
    public int getIdentificacao() {
        return identificacao;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }
    
}
