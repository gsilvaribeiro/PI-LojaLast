/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.FornecedorDao;

/**
 *
 * @author 182110084
 */
public class Fornecedor {

    public static void add(FornecedorDao f) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int idFornecedor;
    private String nome;
    private String telefone;
    private int idProduto;

    public Fornecedor() {
    }

    public Fornecedor(int idFornecedor, String nome, String telefone, int idProduto) {
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.telefone = telefone;
        this.idProduto = idProduto;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public int getIdProduto(){
        return idProduto;
    }
    public void setIdProduto(int idProduto){
        this.idProduto = idProduto;
    }
}


