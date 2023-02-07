package model.entity;

public class Produto {
    private String nome;
    private float valor;
    private Fornecedor fornecedor;
    private Categoria categoria;
    private int id;
    
    public Produto(String nome, float valor, Fornecedor fornecedor, Categoria categoria) {
        this.nome = nome;
        this.valor = valor;
        this.fornecedor = fornecedor;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public Fornecedor getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
