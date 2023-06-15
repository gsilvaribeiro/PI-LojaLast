/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import dao.DAOFactory;
import dao.FornecedorDao;
import java.util.ArrayList;
import model.Fornecedor;


/**
 *
 * @author 182120046
 */
public class FornecedorServicos {

    private FornecedorDao fDAO;

    public FornecedorServicos() {
        fDAO = DAOFactory.getFornecedorDao();
    }

    public void cadastroFornecedor(FornecedorServicos fVO) {
        fDAO.cadastrarFornecedorDao(fDAO);
    }

     public FornecedorDao getFornecedor() {
        String Cnpj = null;
        return fDAO.getFornecedorByDoc(getFornecedorByDoc(Cnpj).toString());
    }

    public FornecedorDao getFornecedorByDoc(String cnpj) {
        return fDAO.getFornecedorByDoc(cnpj);
    }

    public void atualizarFornecedor(FornecedorServicos fVO) {
        fDAO.atualizarFornecedorDao(fDAO);
    }
}