/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fatec.poo.control;

import fatec.poo.model.Recepcionista;
import java.sql.Connection;
import fatec.poo.model.Registro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;

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
        try{
            ps = conn.prepareStatement("INSERT INTO tblRegistro(Codigo_Registro, "
                    + "DataEntrada_Registro, DataSaida_Registro, Recepcionista_Registro"
                    + "ValorHospedagem_Registro) VALUES(?,?,?,?)");
            ps.setInt(1, registro.getCodigo());
            ps.setDate(2, Date.valueOf(registro.getDataEntrada()));
            ps.setDate(3, Date.valueOf(registro.getDataSaida()));
            ps.setInt(4, registro.getRecepcionista().getRegFunc());
            ps.setDouble(5, registro.getValorHospedagem());
        
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Registro registro){
        PreparedStatement ps;
        try{
            ps = conn.prepareStatement("UPDATE tblRegistro set " + "DataEntrada_Registro = ?, " +
                                       "DataSaida_Registro = ?, "+ 
                                       "Recepcionista_Registro = ?" +
                                       "ValorHospedagem_Registro = ? " + 
                                       "where Codigo_Registro = ?");
            
            ps.setDate(1, Date.valueOf(registro.getDataEntrada()));
            ps.setDate(2, Date.valueOf(registro.getDataSaida()));
            ps.setInt(3, registro.getRecepcionista().getRegFunc());
            ps.setDouble(4, registro.getValorHospedagem());
            ps.setInt(5, registro.getCodigo());
            
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public Registro consultar(int codigo){
        Registro r = null;
        PreparedStatement ps;
        Recepcionista recepcionista;
        DaoRecepcionista daoRecepcionista = null;
        int recepcionistaRegFunc;
        ResultSet rs;
        
        try{
            ps = conn.prepareStatement("SELECT * FROM tblRegistro "
                    + "where Codigo_Registro = ?");
            
            ps.setInt(1, r.getCodigo());
            
           rs = ps.executeQuery();
            //tentativa de instanciar o objeto Recepcionista para um novo objeto de registro;
            recepcionistaRegFunc = rs.getInt("RegFunc_Recep");
            recepcionista = daoRecepcionista.consultar(recepcionistaRegFunc);
           
           
           if(rs.next()){
           r = new Registro(codigo, 
                   rs.getDate("DataEntrada_Registro").toLocalDate(),recepcionista);
           }
           
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        
        return r;
    }
    
    public void excluir(Registro registro){
         PreparedStatement ps;
        try{
            ps = conn.prepareStatement("DELETE FROM tblRegistro "
                    + "where Codigo_Registro = ?");
          
            
            ps.setInt(1, registro.getCodigo());
            
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }  
    }
    
    public ArrayList<Registro> consultarRegistros(){
        ArrayList<Registro> registros = new ArrayList<>();
        ResultSet rs;
        Recepcionista recepcionista;
        DaoRecepcionista daoRecepcionista = null;
        int recepcionistaRegFunc;
        
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("SELECT * from tblRegistro order by ");
            
            rs = ps.executeQuery();
            //tentativa de instanciar o objeto Recepcionista para um novo objeto de registro;
            recepcionistaRegFunc = rs.getInt("RegFunc_Recep");
            recepcionista = daoRecepcionista.consultar(recepcionistaRegFunc);
            
            
            while(rs.next()){
                registros.add(new Registro (rs.getInt("Codigo_Registro"), 
                        rs.getDate("DataEntrada_Registro").toLocalDate(), 
                        recepcionista));
            }
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        
        return registros;
    }
}
