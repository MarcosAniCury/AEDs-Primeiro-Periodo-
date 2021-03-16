import java.io.*;

class Main {
  public static void main(String[] args) {

    Arquivo<Livro> arqLivros;

    Livro l1 = new Livro(1, "Eu, Robô", "Isaac Asimov", 14.90F);
    Livro l2 = new Livro(2, "Eu Sou a Lenda", "Richard Matheson", 21.99F);

    try {
      arqLivros = new Arquivo<>(Livro.class.getConstructor(), "dados/livros.db");
      arqLivros.create(l1);

      Livro l3 = arqLivros.read();
      System.out.println(l3);

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}