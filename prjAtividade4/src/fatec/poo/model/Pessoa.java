package fatec.poo.model;

public class Pessoa {
    private String nome;
    private String dtNascimento;
    private String endereco;
    private String cidade;

    public Pessoa(String nome) {
        this.nome = nome;
    }
    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
     
    public String getNome(){
        return(nome);
    }
    public String getCidade(){
        return(cidade);
    }
    public String getDtNascimento(){
        return(dtNascimento);
    }
    public String getEndereco(){
        return(endereco);
    }
}
