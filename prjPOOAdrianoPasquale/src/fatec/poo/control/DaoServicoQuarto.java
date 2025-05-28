/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import fatec.poo.model.ServicoQuarto;
import java.util.ArrayList;

/**
 *
 * @author Pasquale
 */
public class DaoServicoQuarto {
    
    private Connection conn;
    
    public DaoServicoQuarto(Connection coon){
        this.conn =conn;
    }
    
    public void inserir(ServicoQuarto servico){
        //
    }
    
    public void alterar(ServicoQuarto servico){
        //
    }
    
    public ServicoQuarto consultar(int codigo){
        ServicoQuarto sq = null;
        
        return sq;
    }
    
    public void excluir (ServicoQuarto servico){
    
    }
    
    public ArrayList<ServicoQuarto> consultarServicosQuarto(){
        ArrayList<ServicoQuarto> servicos = new ArrayList<>();
        
        
        return servicos;
    }
    
}
