import java.util.Scanner;
import java.util.Arrays;

public class teste
{
    public static int testem(int i,int i2)
    {
        return i + i2;
    }
    public static void main(String [] args)
    {
        int i = 1;
        System.out.println(testem(i, ++i));
        System.out.println(i);
    }
}