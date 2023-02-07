package controller;

import java.util.ArrayList;

import model.dao.CategoriaDao;
import model.dao.FornecedorDao;
import model.dao.ProdutoDao;
import model.entity.Categoria;
import model.entity.Fornecedor;
import model.entity.Produto;
import view.ProdutoView;

public class ProdutoController {
    
    public void cadastrar(String nome, float valor, Fornecedor fornecedor, Categoria categoria){
        Produto p = new Produto(nome, valor, fornecedor, categoria);
        CategoriaDao cd = new CategoriaDao();
        FornecedorDao fd = new FornecedorDao();
        if(fd.existe() && cd.existe()) {
            ProdutoDao pd = new ProdutoDao();
            pd.cadastrar(p);
        }
        else{
            ProdutoView pv = new ProdutoView();
            pv.naoCadastrado();
        }
    }

    public ArrayList<Produto> buscar(String nome){
        ProdutoDao pd = new ProdutoDao();
        return pd.buscar(nome);
    }

    public void atualizar(Produto p, Categoria c){
        ProdutoDao pd = new ProdutoDao();
        pd.atualizar(p, c);
    }
}
