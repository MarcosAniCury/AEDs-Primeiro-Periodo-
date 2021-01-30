import java.lang.*;

public class Aquecimento1MinhaV
{
    public static boolean isFim(String Palavra)
    {
        return (Palavra.length() == 3 && Palavra.charAt(0) == 'F' && Palavra.charAt(1) == 'I' && Palavra.charAt(2) == 'M');
    }

    public static int nMaiuscula(int nCaracter, String palavra)
    {
        int nMaiusculas = 0;
        for (int i = 0;i < nCaracter;i++)
        {
            if (Character.isUpperCase(palavra.charAt(i)))
                nMaiusculas++;
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
        
        int nMaiusculas = 0;
        for (int i = 0;i < nPalavra;i++)
        {
            nMaiusculas = nMaiuscula(Palavra[i].length(),Palavra[i]);
            MyIO.println(nMaiusculas);
        }
    }
}