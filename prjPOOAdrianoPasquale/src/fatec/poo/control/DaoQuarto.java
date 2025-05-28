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
        PreparedStatement ps;
        try{
            ps = conn.prepareStatement("INSERT INTO tblQuarto(Numero_Quarto,"
                    + "Tipo_Quarto, ValorDiaria_Quarto, Situacao_Quarto, "
                    + "TotalFaturado_Quarto) "
                    + "VALUES(?,?,?,?,?)");
            
            ps.setInt(1, quarto.getNumero());
            ps.setString(2, quarto.getTipo());
            ps.setDouble(3, quarto.getValorDiaria());
            ps.setBoolean(4, quarto.getSituacao());
            ps.setDouble(5, quarto.getTotalFaturado());
            
            ps.execute(); //Envia a instrução pro SGBD
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Quarto quarto){
        PreparedStatement ps;
        try{
            ps = conn.prepareStatement("UPDATE tblQuarto set Tipo_Quarto = ?, " +
                                       "ValorDiaria_Quarto = ?, " +
                                       "Situacao_Quarto = ? " +
                                       "TotalFaturado_Quarto = ? "
                                       + "WHERE Numero_Quarto = ?");

            ps.setString(1, quarto.getTipo());
            ps.setDouble(2, quarto.getValorDiaria());
            ps.setBoolean(3, quarto.getSituacao());
            ps.setDouble(4, quarto.getTotalFaturado());
            ps.setDouble(5, quarto.getNumero());
            
            ps.execute(); //Envia a instrução pro SGBD
        
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public Quarto consultar(int nQuarto){
        Quarto objQuarto = null;
        
        PreparedStatement ps;
        try{
            ps = conn.prepareStatement("SELECT * from tblQuarto "
                                    + "WHERE Numero_Quarto = ?");
            
            ps.setInt(1, nQuarto);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                objQuarto = new Quarto(rs.getInt("Numero_Quarto"), 
                        rs.getString("Tipo_Quarto"), 
                        rs.getDouble("ValorDiaria_Quarto"));
            }
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return objQuarto;
    }
    
    public void excluir (Quarto quarto){
        PreparedStatement ps;
        try{
            ps = conn.prepareStatement("DELETE from tblQuarto "
                                    + "where Numero_Quarto = ? ");
            
            ps.setInt(1, quarto.getNumero());
            
            ps.execute();
        
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    
}
