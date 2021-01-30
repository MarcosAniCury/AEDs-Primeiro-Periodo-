import java.io.*;
import java.text.*;
import java.util.*; 

public class Tp1ex9
{
    public static void main(String [] args)
    {
        int n = MyIO.readInt();
        try 
        {
            RandomAccessFile arq = new RandomAccessFile("texto.txt", "rw");
            for (int i = 0;i < n;i++)
            {
                arq.writeDouble(MyIO.readDouble());
            }
            NumberFormat format = NumberFormat.getNumberInstance(Locale.ENGLISH);
            format.setMinimumFractionDigits(0);
            arq.close();
            RandomAccessFile arq1 = new RandomAccessFile("texto.txt", "r");
            for (long i = arq1.length() - 8;i >=0; i-=8)
            {
                arq1.seek(i);
                MyIO.println(format.format(arq1.readDouble()));
            }
            arq1.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}