package br.edu.ifpb.gerenciador;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.model.Produto;
import br.edu.ifpb.model.Venda;

public class Serializacao {
   public static void main(String [] args) throws FileNotFoundException {
    List<Produto> i = new ArrayList<>(); // Lista de Produtos
    List<Venda> v = new ArrayList<>(); // Lista de Vendas

    i.add(new Produto(0, "Arroz", 10, 10));
    i.add(new Produto(1, "Feijao", 20, 10));
    i.add(new Produto(2, "Açucar", 30, 10));


    // Serialização de Produtos

    try {
        FileOutputStream fileOut =
        new FileOutputStream("produtos.bin");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(i);
        out.close();
        fileOut.close();
        System.out.printf("Serialized data is saved in produtos.bin");
    } catch (IOException e) {
        e.printStackTrace();
    } 
    
    // Deserialização de produtos

    File produtos = new File("produtos.bin");
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("produtos.bin"))) {
        i = (List<Produto>) ois.readObject();
        System.out.printf("\nFoi Serializado: \n");
        i.forEach(p -> System.out.println("* " + p.getNome()));
    } catch (FileNotFoundException e) {
        throw e;
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }

    // Serialização de Vendas
    
    try {
        FileOutputStream fileOut =
        new FileOutputStream("vendas.bin");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(v);
        out.close();
        fileOut.close();
        System.out.printf("Serialized data is saved in vendas.bin");
    } catch (IOException e) {
        e.printStackTrace();
    } 
    
    // Deserialização de Vendas
    
    File vendas = new File("vendas.bin");
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("vendas.bin"))) {
        v = (List<Venda>) ois.readObject();
        System.out.printf("\nFoi Serializado: \n");
        v.forEach(p -> System.out.println("* " + p));
    } catch (FileNotFoundException e) {
        throw e;
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }    
   }
}
