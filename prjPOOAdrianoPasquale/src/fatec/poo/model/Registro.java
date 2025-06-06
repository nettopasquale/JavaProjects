
package fatec.poo.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 *
 * @author Pasquale Adriano
 * 
 */
public class Registro {
    private int codigo;
    private LocalDate dataEntrada, dataSaida;
    private double valorHospedagem;
    private Recepcionista recepcionista;
    private Hospede hospede;
    private Quarto quarto;
    private ArrayList<ServicoQuarto> servicosQuarto;

    public Registro(int codigo, LocalDate dataEntrada, Recepcionista recepcionista) {
        this.codigo = codigo;
        this.dataEntrada = dataEntrada;
        this.recepcionista = recepcionista;
        this.servicosQuarto = new ArrayList<>();
        recepcionista.addRegistro(this);
    }

    public int getCodigo() {
        return codigo;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public double getValorHospedagem() {
        return valorHospedagem;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }
    

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }
    
    public void addServicosQuarto(ServicoQuarto servico){
        servicosQuarto.add(servico);
    }

    public void reservarQuarto(Hospede hospede, Quarto quarto){
        this.hospede = hospede;
        hospede.addRegistro(this);
        
        this.quarto = quarto;
        
        if(quarto.getSituacao() == false){
            quarto.reservar();
            System.out.println("Quarto reservado para o hospede " + hospede.getNome());
        }
        else{
            System.out.println("Nenhum quarto disponivel.");
        }
    }
    
    public double liberarQuarto(){
        long qtdDiasLong = ChronoUnit.DAYS.between(dataEntrada, dataSaida);
        int qtdDias = (int) qtdDiasLong;
        
        if(qtdDias <= 0) qtdDias =1;
        
        valorHospedagem = quarto.liberar(qtdDias);
        double valorAPagar = valorHospedagem;
        
        valorAPagar -= valorHospedagem * (hospede.getTaxaDesconto()/100.0);
        
        for(ServicoQuarto itemServicos : this.servicosQuarto){
            valorAPagar += itemServicos.getValor();
        }
        
        return valorAPagar;
    }
    
}
