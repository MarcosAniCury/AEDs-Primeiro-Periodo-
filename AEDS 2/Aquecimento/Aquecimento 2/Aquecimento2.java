import java.lang.*;

public class Aquecimento2
{
    public static boolean isFim(String Palavra)
    {
        return (Palavra.length() == 3 && Palavra.charAt(0) == 'F' && Palavra.charAt(1) == 'I' && Palavra.charAt(2) == 'M');
    }

    public static int NMaiuscula(String palavra)
    {
        return nMaiuscula(palavra, 0, 0);
    }

    public static int nMaiuscula(String palavra, int nMaiusculas, int i)
    {
        if (i < palavra.length())
        {
            if (Character.isUpperCase(palavra.charAt(i)))
                nMaiusculas++;
            nMaiusculas = nMaiuscula(palavra, nMaiusculas, ++i);
        }
        return nMaiusculas;
    }

    public static void main(String [] args)
    {
        String [] Palavra = new String [1000];
        int nPalavra = 0;
        do
        {
            Palavra[nPalavra] = MyIO.readLine();
        }while(!isFim(Palavra[nPalavra++]));
        nPalavra--;
        
        for (int i = 0;i < nPalavra;i++)
        {
            MyIO.println(NMaiuscula(Palavra[i]));
        }
    }
}