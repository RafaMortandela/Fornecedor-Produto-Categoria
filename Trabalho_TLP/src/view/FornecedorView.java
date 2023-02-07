package view;

import java.util.Scanner;

import controller.FornecedorController;

public class FornecedorView {
    Scanner sc = new Scanner(System.in);

    String nome, descricao; 

    public void cadastrar(){
        System.out.println("Informe o nome: ");
        nome = sc.next();
        System.out.println("Informe a descricao: ");
        descricao = sc.next();

        FornecedorController fc = new FornecedorController();
        fc.cadastrar(nome, descricao); 
    }

    public void jaEhCadastrado(){
        System.out.println("Nome já cadastrado, tente novamente");
    }
}
