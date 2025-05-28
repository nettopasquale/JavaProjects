/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fatec.poo.control;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import fatec.poo.model.Quarto;
import java.util.ArrayList;
/**
 *
 * @author Pasquale
 */
public class DaoQuarto {
    private Connection conn;
    
    public DaoQuarto(Connection coon){
        this.conn =conn;
    }
    
    public void inserir(Quarto quarto){
        //
    }
    
    public void alterar(Quarto quarto){
        //
    }
    
    public Quarto consultar(int nQuarto){
        Quarto q = null;
        
        return q;
    }
    
    public void excluir (Quarto quarto){
    
    }
    
    public ArrayList<Quarto> consultarServicosQuarto(){
        ArrayList<Quarto> quartos = new ArrayList<>();
        
        
        return quartos;
    }
    
}
