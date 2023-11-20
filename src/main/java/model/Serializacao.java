package model;
import java.io.*;

public class Serializacao
{
   public static void main(String [] args) throws FileNotFoundException
   {
        Inventario i = new Inventario();
        try
{
         FileOutputStream fileOut =
         new FileOutputStream("invetario.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(i);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in invetario.ser");
      }catch(IOException e)
      {
          e.printStackTrace();
      } 

       
        FileInputStream fis = new FileInputStream("invetario.ser");
        try (ObjectInputStream ois = new ObjectInputStream(fis)) {
            for (Produto produto : i.listarProdutos()) {
                Produto p2 = (Produto) ois.readObject();
              }
            System.out.printf(" AAA");//"%d %s %.2f %d", p2.getIdentificador(), p2.getNome(), p2.getPreco(), p2.getQuantidade());
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
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