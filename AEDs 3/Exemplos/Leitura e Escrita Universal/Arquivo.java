import java.io.*;
import java.lang.reflect.Constructor;

public class Arquivo<T extends Registro> {

  RandomAccessFile arq;
  Constructor<T> construtor;
  String nomeArquivo;

  public Arquivo(Constructor<T> c, String nome) throws IOException {
    this.nomeArquivo = nome;
    this.construtor = c;
    arq = new RandomAccessFile(this.nomeArquivo, "rw");
  }

  public void create(T obj) throws IOException {
    arq.seek(0);
    byte[] b = obj.toByteArray();
    arq.writeInt(b.length);
    arq.write(b);
  }

  public T read() throws Exception {
    arq.seek(0);
    int tam = arq.readInt();
    byte[] b = new byte[tam];
    arq.read(b);
    T obj = this.construtor.newInstance();
    obj.fromByteArray(b);
    return obj;
  }

}
