import java.io.RandomAccessFile;
import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    Livro l1 = new Livro(1, "Eu, Robô", "Isaac Asimov", 14.90F);
    Livro l2 = new Livro(2, "Eu Sou a Lenda", "Richard Matheson", 21.99F);

    RandomAccessFile arq;
    byte ba[];

    try {

      // ESCRITA
      arq = new RandomAccessFile("dados/livros.db", "rw");

      long pos1 = arq.getFilePointer();
      ba = l1.toByteArray();
      arq.writeInt(ba.length);
      arq.write(ba);

      long pos2 = arq.getFilePointer();
      ba = l2.toByteArray();
      arq.writeInt(ba.length);
      arq.write(ba);

      // LEITURA
      Livro l3 = new Livro();
      Livro l4 = new Livro();
      int tam;

      arq.seek(pos2);
      tam = arq.readInt();
      ba = new byte[tam];
      arq.read(ba);
      l3.fromByteArray(ba);

      arq.seek(pos1);
      tam = arq.readInt();
      ba = new byte[tam];
      arq.read(ba);
      l4.fromByteArray(ba);

      System.out.println(l3);
      System.out.println(l4);

      arq.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}