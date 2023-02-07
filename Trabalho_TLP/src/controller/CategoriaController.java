package controller;

import java.util.ArrayList;

import model.dao.CategoriaDao;
import model.entity.Categoria;
import view.CategoriaView;

public class CategoriaController {

    public void cadastrar(String nome, String descricao){
        Categoria c = new Categoria(nome, descricao);
        
        CategoriaDao cd = new CategoriaDao();
        if (!cd.jaEhCadastrado(nome)) {
            cd.cadastrar(c);
        }
        else{
            CategoriaView cv = new CategoriaView();
            cv.jaEhCadastrado();
        }
    }

    public Categoria buscarPorNome(String nome){
        CategoriaDao cd = new CategoriaDao();
        return cd.buscarPorNome(nome);
    }

    public ArrayList<Categoria> buscar(){
        CategoriaDao cd = new CategoriaDao();
        return cd.buscar();
    }

    public void deletar(Categoria c){
        CategoriaDao cd = new CategoriaDao();
        cd.deletar(c);
    }
}
