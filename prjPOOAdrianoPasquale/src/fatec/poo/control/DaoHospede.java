/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fatec.poo.control;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import fatec.poo.model.Hospede;
import java.util.ArrayList;

/**
 *
 * @author Pasquale
 */
public class DaoHospede {
    private Connection conn;
    
    public DaoHospede(Connection coon){
        this.conn =conn;
    }
    
    public void inserir(Hospede hospede){
        //
    }
    
    public void alterar(Hospede hospede){
        //
    }
    
    public Hospede consultar(String cpf){
        Hospede h = null;
        
        return h;
    }
    
    public void excluir (Hospede hospede){
    
    }
    
    public ArrayList<Hospede> consultarServicosQuarto(){
        ArrayList<Hospede> hospedes = new ArrayList<>();
        
        
        return hospedes;
    }
    
}
