package view;

import java.util.Scanner;

import controller.CategoriaController;

public class CategoriaView {
    Scanner sc = new Scanner(System.in);

    String nome, descricao; 

    public void cadastrar(){
        System.out.println("Informe o nome: ");
        nome = sc.next();
        System.out.println("Informe a descricao: ");
        descricao = sc.next();

        CategoriaController cc = new CategoriaController();
        cc.cadastrar(nome, descricao);
    }

    public void jaEhCadastrado(){
        System.out.println("Nome já cadastrado, tente novamente");
    }
}
