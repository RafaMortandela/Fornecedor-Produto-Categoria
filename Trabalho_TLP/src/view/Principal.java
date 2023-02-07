package view;

import java.util.Scanner;
import view.*;

//Rafaela Silva Ruis - Turma 129

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;
        ProdutoView pv = new ProdutoView();
        FornecedorView fv = new FornecedorView();
        CategoriaView cv = new CategoriaView();

        do {
            System.out.println("Escolha uma opção: ");
            System.out.println("1- Cadastro de fornecedor");
            System.out.println("2- Cadastro de categoria");
            System.out.println("3- Cadastro de  produto");
            System.out.println("4- Remover categoria");
            System.out.println("5- Busca de categoria");
            System.out.println("6- Sair");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    fv.cadastrar();
                break;
            
                case 2:
                    cv.cadastrar();
                break;

                case 3:
                    pv.cadastrar();
                break;

                case 4:
                    pv.transferir();
                break;

                case 5:
                    pv.buscar();
                break;
            }
        } while (opcao != 6);
    }
}

/* Códigos SQL: 
 
create table fornecedor(
	nome varchar,
	descricao varchar,
	id serial primary key
);

create table categoria(
	nome varchar,
	descricao varchar,
	id serial primary key
);

create table produto(
	nome varchar,
	valor float,
	idFornecedor int references Fornecedor(id),
	idCategoria int references Categoria(id),
	id serial primary key
);

 */