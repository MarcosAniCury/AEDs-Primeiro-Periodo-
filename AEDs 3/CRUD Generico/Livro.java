import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Livro implements Registro {
  protected int idLivro;
  protected String titulo;
  protected int titulo_lenght;
  protected String autor;
  protected int autor_lenght;
  protected float preco;

  public Livro(int i, String t, String a, float p) {
    this.idLivro = i;
    this.titulo = t;
    this.titulo_lenght = this.titulo.length();
    this.autor = a;
    this.autor_lenght = this.autor.length();
    this.preco = p;
  }

  public Livro() {
    this.idLivro = -1;
    this.titulo = "";
    this.autor = "";
    this.preco = 0F;
    this.autor_lenght = 0;
    this.titulo_lenght = 0;
  }

  public int getId()
  {
    return idLivro;
  }

  public void setId(int new_id)
  {
    this.idLivro = new_id;
  }

  public String toString() {
    DecimalFormat df = new DecimalFormat("#,##0.00");

    return "\nID....: " + this.idLivro + "\nTítulo: " + this.titulo + "\nAutor.: " + this.autor + "\nPreço.: R$ "
        + df.format(this.preco);
  }

  public byte[] toByteArray() throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    DataOutputStream dos = new DataOutputStream(baos);
    dos.writeInt(idLivro);
    dos.writeInt(titulo.length());
    dos.writeUTF(titulo);
    dos.writeInt(autor.length());
    dos.writeUTF(autor);
    dos.writeFloat(preco);
    return baos.toByteArray();
  }

  public void fromByteArray(byte[] ba) throws IOException {
    ByteArrayInputStream bais = new ByteArrayInputStream(ba);
    DataInputStream dis = new DataInputStream(bais);
    idLivro = dis.readInt();
    titulo_lenght = dis.readInt();
    titulo = dis.readUTF();
    titulo = titulo.substring(0, titulo_lenght);
    autor_lenght = dis.readInt();
    autor = dis.readUTF();
    autor = autor.substring(0, autor_lenght);
    preco = dis.readFloat();
  }

}