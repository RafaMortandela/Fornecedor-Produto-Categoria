package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.entity.Fornecedor;

public class FornecedorDao {
    
    public void cadastrar(Fornecedor fornecedor){
        Connection conexao = ConectaBanco.getConnection();
        String sql = "insert into fornecedor values(?, ?)";
        
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, fornecedor.getNome());
            statement.setString(2, fornecedor.getDescricao());
            statement.execute();
            statement.close();
            conexao.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public Fornecedor buscarPorNome(String nome){
        Fornecedor f = null;
        try {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select * from fornecedor where nome = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, nome);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                f = new Fornecedor(rs.getString("nome"), rs.getString("descricao"));
                f.setId(rs.getInt("id"));
            }
            rs.close();
            statement.close();
            conexao.close();
        } catch (Exception e) {
                e.printStackTrace();
        }
        return f;
    }

    public boolean jaEhCadastrado(String nome){
        try {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select * from fornecedor where nome = ?";
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
            String sql = "select * from fornecedor";
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

    public ArrayList<Fornecedor> buscar(){
        ArrayList<Fornecedor> lista = new ArrayList<>();
        try {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select * from fornecedor";
            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                    Fornecedor f = new Fornecedor(rs.getString("nome"), rs.getString("descricao"));
                    lista.add(f);
            }
            rs.close();
            statement.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Fornecedor buscarPorId(int id){
        Fornecedor f = null;
        try {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select * from fornecedor where id = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                    f = new Fornecedor(rs.getString("nome"), rs.getString("descricao"));
                    f.setId(rs.getInt("id"));
            }
            rs.close();
            statement.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
