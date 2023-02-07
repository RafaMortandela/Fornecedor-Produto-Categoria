package view;

import java.util.Scanner;

import controller.CategoriaController;
import controller.FornecedorController;
import controller.ProdutoController;
import model.entity.Categoria;
import model.entity.Fornecedor;
import model.entity.Produto;

public class ProdutoView {
    Scanner sc = new Scanner(System.in);

    String nome;
    float valor; 
    Fornecedor fornecedor;
    Categoria categoria;

    public void cadastrar(){
        FornecedorController fc = new FornecedorController();
        CategoriaController cc = new CategoriaController();
        System.out.println("Informe o nome: ");
        nome = sc.next();
        System.out.println("Informe o valor: ");
        valor = sc.nextFloat();
        System.out.println("\nNome dos fornecedores existentes: ");
        for (Fornecedor f : fc.buscar()) {
            System.out.println(f.getNome());
        }
        System.out.println("Informe o nome do fornecedor: ");
        fornecedor = fc.buscarPorNome(sc.next());
        System.out.println("\nNome das categorias existentes: ");
        for (Categoria c : cc.buscar()) {
            System.out.println(c.getNome());
        }
        System.out.println("Informe o nome da categoria: ");
        categoria = cc.buscarPorNome(sc.next());

        ProdutoController pc = new ProdutoController();
        pc.cadastrar(nome, valor, fornecedor, categoria);
    }

    public void buscar(){
        System.out.println("Informe o nome da categoria: ");
        nome = sc.next();

        ProdutoController pc = new ProdutoController();
        System.out.println("Produtos: ");
        for (Produto p : pc.buscar(nome)) {
            System.out.println("\nNome: "+p.getNome());
            System.out.println("Nome do Fornecedor: "+p.getFornecedor().getNome());
        }
        System.out.println();//so pra pular linha
    }

    public void transferir(){
        CategoriaController cc = new CategoriaController();
        ProdutoController pc = new ProdutoController();

        System.out.println("Informe o nome da categoria a ser removida: ");
        nome = sc.next();

        System.out.println("Produtos: ");
        for (Produto p : pc.buscar(nome)) {
            System.out.println("\nNome: "+p.getNome());
            System.out.println("Informe o nome da nova categoria: ");
            pc.atualizar(p,  cc.buscarPorNome(sc.next()));
        }
        System.out.println();//so pra pular linha
        cc.deletar(cc.buscarPorNome(nome));
    }

    public void naoCadastrado(){
        System.out.println("Fornecedor/Categoria não cadastrado, tente novamente");
    }
}
