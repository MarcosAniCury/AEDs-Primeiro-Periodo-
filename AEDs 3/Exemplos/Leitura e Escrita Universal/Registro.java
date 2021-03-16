public interface Registro {
  public byte[] toByteArray() throws java.io.IOException;

  public void fromByteArray(byte[] ba) throws java.io.IOException;
}
