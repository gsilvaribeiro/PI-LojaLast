/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author 182110084
 */
public class ClienteDao {
    public void ClienteDAO(Cliente pVO) {
        try {
           
            Connection con = Conexao.getConexao();
            
            String sql = "insert into pessoa values (null, ?,?,?,?)";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, pVO.getIdCliente());
            pst.setString(2, pVO.getEndereco());
            pst.setString(3, pVO.getCpf());
            pst.setString(4, pVO.getCnpj());
            pst.setString(5, pVO.getTelefone());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Cliente.\n"
                    + e.getMessage());
        }
    }//fim cadastroPessoa
    
    public ArrayList<Cliente> getidCliente(){
        ArrayList<Cliente> Cliente = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from cliente";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Cliente c = new Cliente();
                // lado do java |x| lado do banco
                c.setIdCliente(rs.getInt("idCliente"));
                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("endereco"));              
                c.setTelefone(rs.getString("telefone"));
                c.setCnpj(rs.getString("cnpj"));
                c.setCpf(rs.getString("cpf"));
                Cliente.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes.\n"
                    + e.getMessage());
        }
        return Cliente;
    }
    
    public Cliente getPessoaByDoc(String idCliente){
        Cliente c = new Cliente();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from cliente where cpf = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, idCliente);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                // lado do java |x| lado do banco
                c.setIdCliente(rs.getInt("idCliente"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setCnpj(rs.getString("cnpj"));
                c.setTelefone(rs.getString("telefone"));
                c.setEndereco(rs.getString("Endereco"));
                
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar CPF.\n"
                    + e.getMessage());
        }
        return c;
    }
    
    public void atualizarClienteDAO(Cliente pVO){
        try {
            Connection con = Conexao.getConexao();
            String sql = "update pessoa set nome = ?, endereco = ?, telefone = ?"
                    + " where cpf = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, pVO.getNome());
            pst.setString(2, pVO.getEndereco());
            pst.setString(3, pVO.getTelefone());
            pst.setString(4, pVO.getCpf());
            pst.setString(5, pVO.getCnpj());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Pessoa.\n"
                    + e.getMessage());
        }
    }
    
    public void deletarClienteDAO(String cpf){
        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from Cliente where cpf = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cpf);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Cliente.\n"
                    + e.getMessage());
        }
    }
    
}

