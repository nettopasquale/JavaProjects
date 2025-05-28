/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fatec.poo.control;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import fatec.poo.model.Recepcionista;
import java.util.ArrayList;

/**
 *
 * @author Pasquale
 */
public class DaoRecepcionista {
    private Connection conn;
    
    public DaoRecepcionista(Connection coon){
        this.conn =conn;
    }
    
    public void inserir(Recepcionista recepcionista){
        //
    }
    
    public void alterar(Recepcionista Recepcionista){
        //
    }
    
    public Recepcionista consultar(int regFun){
        Recepcionista r = null;
        
        return r;
    }
    
    public void excluir (Recepcionista hospede){
    
    }
    
    public ArrayList<Recepcionista> consultarServicosQuarto(){
        ArrayList<Recepcionista> recepcionistas = new ArrayList<>();
        
        
        return recepcionistas;
    }
    
}
