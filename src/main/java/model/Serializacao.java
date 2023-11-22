package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializacao {
   public static void main(String [] args) throws FileNotFoundException {
        List<Produto> i = new ArrayList<>();
        i.add(new Produto(0, "arroz", 10, 10));
        i.add(new Produto(1, "feijao", 20, 10));
        i.add(new Produto(2, "acucar", 30, 10));


        try {
            FileOutputStream fileOut =
            new FileOutputStream("data.bin");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(i);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in data.bin");
        } catch (IOException e) {
          e.printStackTrace();
        } 

       
        File data = new File("data.bin");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.bin"))) {
            i = (List<Produto>) ois.readObject();
            System.out.printf(" Serializou AAA");
            i.forEach(p -> System.out.println(p.getNome()));
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        
    /*
      Produto p = new Produto(123, "bala", 11.5, 15);

      
      try
      {
         FileOutputStream fileOut =
         new FileOutputStream("employee.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(p);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in employee.ser");
      }catch(IOException i)
      {
          i.printStackTrace();
      } */

       /*
        FileInputStream fis = new FileInputStream("employee.ser");
        try (ObjectInputStream ois = new ObjectInputStream(fis)) {
            Produto p2 = (Produto) ois.readObject();
            System.out.printf("%d %s %.2f %d", p2.getIdentificador(), p2.getNome(), p2.getPreco(), p2.getQuantidade());
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } */


         
   }
}
