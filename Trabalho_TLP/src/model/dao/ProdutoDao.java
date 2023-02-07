package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.entity.Categoria;
import model.entity.Fornecedor;
import model.entity.Produto;

public class ProdutoDao {

    public void cadastrar(Produto produto){
        Connection conexao = ConectaBanco.getConnection();
        String sql = "insert into produto values(?, ?, ?, ?)";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, produto.getNome());
            statement.setFloat(2, produto.getValor());
            statement.setInt(3, produto.getFornecedor().getId());
            statement.setInt(4, produto.getCategoria().getId());
            statement.execute();
            statement.close();
            conexao.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Produto> buscar(String nome){
        Connection conexao = ConectaBanco.getConnection();
        ArrayList<Produto> lista = new ArrayList<Produto>();
        try{
            String sql = "select produto.*, categoria.*, fornecedor.* from produto, categoria, fornecedor"
                    + " where fornecedor.id = produto.idFornecedor and categoria.id = produto.idCategoria"
                    + " and categoria.nome = ? order by produto.valor asc";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, nome);
            ResultSet rs = statement.executeQuery();
            CategoriaDao cd = new CategoriaDao();
            FornecedorDao fd = new FornecedorDao();
            while(rs.next()){
                Fornecedor f = new Fornecedor(rs.getString("nome"), rs.getString("descricao"));
                f.setId(rs.getInt("id"));
                Categoria c = new Categoria(rs.getString("nome"), rs.getString("descricao"));
                c.setId(rs.getInt("id"));
                Produto p = new Produto(rs.getString("nome"), 
                rs.getFloat("valor"), fd.buscarPorId(rs.getInt("idFornecedor")), cd.buscarPorId(rs.getInt("idCategoria")));
                lista.add(p);
            }
            statement.close();
            conexao.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    public void atualizar(Produto p, Categoria c){
        Connection conexao = ConectaBanco.getConnection();
        String sql = "update produto set IdCategoria = ? where nome = ? and valor = ?";
        
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, c.getId());
            statement.setString(2, p.getNome());
            statement.setFloat(3, p.getValor());
            statement.execute();
            statement.close();
            conexao.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
