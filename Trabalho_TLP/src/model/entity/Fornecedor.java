package model.entity;

import java.util.ArrayList;

public class Fornecedor {
    private String nome;
    private String descricao;
    private int id;
    private ArrayList<Produto> lista = new ArrayList<>();
    
    public Fornecedor(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public ArrayList<Produto> getLista() {
        return lista;
    }
    public void setLista(ArrayList<Produto> lista) {
        this.lista = lista;
    }
}
