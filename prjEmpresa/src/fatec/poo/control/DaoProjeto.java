
package fatec.poo.control;

import fatec.poo.model.Projeto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoProjeto {
    private Connection conn;

    public DaoProjeto(Connection conn) {
        this.conn = conn;
    }
    
    public Projeto consultar(int codigo){
        Projeto objProj = null;
        
        PreparedStatement ps;
        try{
            ps = conn.prepareStatement("SELECT * from tblProjeto where CODIGO_PROJ = ?");
            
            ps.setInt(1,codigo);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next() == true){
                objProj = new Projeto(rs.getInt("CODIGO_PROJ"), rs.getString("DESCRICAO_PROJ"));
                
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return (objProj);
    }
    
    public void inserir(Projeto objProj){
        PreparedStatement ps;
        
        try{
            ps = conn.prepareStatement("INSERT INTO tblProjeto()");
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Projeto objProj){
    }
    
    public void excluir(Projeto objProj){
    
    }
}
