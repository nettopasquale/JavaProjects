/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fatec.poo.control;

import java.sql.Connection;
import fatec.poo.model.Registro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pasquale
 */
public class DaoRegistro {
    private Connection conn;

    public DaoRegistro(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Registro registro){
        PreparedStatement ps = null;
    }
    
    public void alterar(Registro registro){
    
    }
    
    public Registro consultar(){
        Registro r = null;
        
        return r;
    }
    
    public void excluir(Registro registro){
    
    }
    
    public ArrayList<Registro> consultarRegistros(){
        ArrayList<Registro> registros = new ArrayList<>();
        
        return registros;
    }
}
