import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    Livro l1 = new Livro(1, "Eu, Robô", "Isaac Asimov", 14.90F);
    Livro l2 = new Livro(2, "Eu Sou a Lenda", "Richard Matheson", 21.99F);

    FileOutputStream arq;
    DataOutputStream dos;

    FileInputStream arq2;
    DataInputStream dis;

    byte ba[];

    try {

      // ESCRITA
      arq = new FileOutputStream("dados/livros.db");
      dos = new DataOutputStream(arq);
      ba = l1.toByteArray();
      dos.writeInt(ba.length);
      dos.write(ba);

      ba = l2.toByteArray();
      dos.writeInt(ba.length);
      dos.write(ba);

      arq.close();

      // LEITURA
      Livro l3 = new Livro();
      Livro l4 = new Livro();
      int tam;

      arq2 = new FileInputStream("dados/livros.db");
      dis = new DataInputStream(arq2);

      tam = dis.readInt();
      ba = new byte[tam];
      dis.read(ba);
      l3.fromByteArray(ba);

      tam = dis.readInt();
      ba = new byte[tam];
      dis.read(ba);
      l4.fromByteArray(ba);

      System.out.println(l3);
      System.out.println(l4);

      arq2.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}