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
import model.Fornecedor;

/**
 *
 * @author 182110084
 */
public class FornecedorDao {
    public void cadastrarFornecedorDao(FornecedorDao fVO) {
        try {
            //buscar conexão com BD
            Connection con = Conexao.getConexao();
            //criar script sql de insert
            String sql = "insert into pessoas values (null, ?,?,?,?)";
            //criar espaço para executar script
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, fVO.getNome());
            pst.setString(2, fVO.getCnpj());
            pst.setString(3, fVO.getEndereco());
            pst.setString(4, fVO.getTelefone());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Fornecedor.\n"
                    + e.getMessage());
        }
    }//fim cadastroPessoa
    
    public ArrayList<FornecedorDao> getPessoas(){
        ArrayList<FornecedorDao> pessoas = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoas";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                FornecedorDao f = new FornecedorDao();
                // lado do java |x| lado do banco
                f.setIdPessoa(rs.getInt("idPessoa"));
                f.setNome(rs.getString("nome"));
                f.setCnpj(rs.getString("cnpj"));
                f.setEndereco(rs.getString("endereco"));
                f.setTelefone(rs.getString("telefone"));
                Fornecedor.add(f);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar Fornecedor.\n"
                    + e.getMessage());
        }
        return pessoas;
    }
    
    public FornecedorDao getFornecedorByDoc(String cpf){
        FornecedorDao f = new FornecedorDao();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from fornecedor where cpf = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cpf);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                // lado do java |x| lado do banco
                f.setIdPessoa(rs.getInt("idFornecedor"));
                f.setNome(rs.getString("nome"));
                f.setCnpj(rs.getString("cnpj"));
                f.setEndereco(rs.getString("endereco"));
                f.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar CNPJ.\n"
                    + e.getMessage());
        }
        return f;
    }
    
    public void atualizarFornecedorDao(FornecedorDao pVO){
        try {
            Connection con = Conexao.getConexao();
            String sql = "update fornecedor set nome = ?, endereco = ?, telefone = ?"
                    + " where cnpj = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, pVO.getNome());
            pst.setString(2, pVO.getEndereco());
            pst.setString(3, pVO.getTelefone());
            pst.setString(4, pVO.getCnpj());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Pessoa.\n"
                    + e.getMessage());
        }
    }
    
    public void deletarFornecedorDao(String cnpj){
        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from fornecedor where cnpj = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cnpj);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Fornecedor.\n"
                    + e.getMessage());
        }
    }

    private String getTelefone() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getEndereco() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getCnpj() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getNome() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setIdPessoa(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setNome(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setCnpj(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setTelefone(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setEndereco(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

