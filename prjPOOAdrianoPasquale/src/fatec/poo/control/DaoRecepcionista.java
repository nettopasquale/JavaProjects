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
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("INSERT INTO "
                    + "tblRecepcionista(RegFunc_Recep, "
                    + "Nome_Recep, "
                    + "Endereco_Recep, "
                    + "Telefone_Recep, "
                    + "Turno_Recep) "
                    + "VALUES(?,?,?,?,?)");
            
            ps.setInt(1, recepcionista.getRegFunc());
            ps.setString(2, recepcionista.getNome());
            ps.setString(3, recepcionista.getEndereco());
            ps.setString(4, recepcionista.getTelefone());
            ps.setString(5, recepcionista.getTurno());
                      
            ps.execute(); //envia a instrução SQL para o SGBD
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Recepcionista recepcionista){
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("Update tblRecepcionista"
                    + "Nome_Recep = ?, "
                    + "Endereco_Recep = ?, "
                    + "Telefone_Recep = ?, "
                    + "Turno_Recep = ?, "
                    + "WHERE RegFunc_Recep = ?");
            
            ps.setString(1, recepcionista.getNome());
            ps.setString(2, recepcionista.getEndereco());
            ps.setString(3, recepcionista.getTelefone());
            ps.setString(4, recepcionista.getTurno());
            ps.setInt(5, recepcionista.getRegFunc());
                      
            ps.execute(); //envia a instrução SQL para o SGBD
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public Recepcionista consultar(int regFun){
        Recepcionista r = null;
        PreparedStatement ps;
        
        try {
            ps = conn.prepareStatement("SELECT * from tblRecepcionista"
                    + " where RegFunc_Recep = ?");
            
            ps.setInt(1, regFun);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                r = new Recepcionista(rs.getString("Nome_Recep"),
                        rs.getInt("RegFunc_Recep"));

            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        
        return r;
    }
    
    public void excluir (Recepcionista recepcionista){
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("DELETE FROM tblRecepcionista "
                    + "where RegFunc_Recep = ?");
            
            ps.setInt(1, recepcionista.getRegFunc());
                      
            ps.execute(); //Envia a instrução SQL para o SGBD
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    
}
