package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.entity.Categoria;

public class CategoriaDao {
    
    public void cadastrar(Categoria categoria){
        Connection conexao = ConectaBanco.getConnection();
        String sql = "insert into categoria values(?, ?)";
        
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, categoria.getNome());
	    statement.setString(2, categoria.getDescricao());
            statement.execute();
            statement.close();
            conexao.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public Categoria buscarPorNome(String nome){
	Categoria c = null;
	try {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select * from categoria where nome = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, nome);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
		c = new Categoria(rs.getString("nome"), rs.getString("descricao"));
		c.setId(rs.getInt("id"));
            }
            rs.close();
            statement.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public boolean jaEhCadastrado(String nome){
        try {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select * from categoria where nome = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, nome);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                return true;
            }
            rs.close();
            statement.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean existe(){
	try {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select * from categoria";
            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
		return true;
            }
            rs.close();
            statement.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Categoria> buscar(){
        ArrayList<Categoria> lista = new ArrayList<>();
	try {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select * from categoria";
            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
		Categoria c = new Categoria(rs.getString("nome"), rs.getString("descricao"));
		lista.add(c);
            }
            rs.close();
            statement.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Categoria buscarPorId(int id){
	Categoria c = null;
	try {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select * from categoria where id = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
		c = new Categoria(rs.getString("nome"), rs.getString("descricao"));
		c.setId(rs.getInt("id"));
            }
            rs.close();
            statement.close();
            conexao.close();
	} catch (Exception e) {
            e.printStackTrace();
	}
	return c;
    }

    public void deletar(Categoria categoria){
        Connection conexao = ConectaBanco.getConnection();
        String sql = "delete from categoria where nome = ?";

        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, categoria.getNome());
            statement.execute();
            statement.close();
            conexao.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
