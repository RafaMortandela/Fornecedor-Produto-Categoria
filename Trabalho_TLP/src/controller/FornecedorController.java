package controller;

import java.util.ArrayList;

import model.dao.FornecedorDao;
import model.entity.Fornecedor;
import view.FornecedorView;

public class FornecedorController {
    
    public void cadastrar(String nome, String descricao){
        Fornecedor f = new Fornecedor(nome, descricao);

        FornecedorDao fd = new FornecedorDao();
        if (!fd.jaEhCadastrado(nome)) {
            fd.cadastrar(f);
        }
        else{
            FornecedorView fv = new FornecedorView();
            fv.jaEhCadastrado();
        }
    }

    public boolean verificarNome(String nome){
        FornecedorDao fd = new FornecedorDao();
        if (!fd.jaEhCadastrado(nome)) {
            return true;
        }
        else{
            return false;
        }
    }

    public Fornecedor buscarPorNome(String nome){
        FornecedorDao fd = new FornecedorDao();
        return fd.buscarPorNome(nome);
    }

    public ArrayList<Fornecedor> buscar(){
        FornecedorDao fd = new FornecedorDao();
        return fd.buscar();
    }
}
