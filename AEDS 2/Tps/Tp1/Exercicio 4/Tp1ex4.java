import java.util.Random;

public class Tp1ex4
{
    public static boolean isFim(String palavra)
    {
        return (palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
    }

    public static String stringModificada(String palavra, Random gerador)
    {
        String palavraModificada = "";
        //gerar 2 caracteres "aleatorios" entre a e z
        char letratrocada = (char) ('a' + (Math.abs(gerador.nextInt())) % 26);
        char letraparatrocar = (char) ('a' + (Math.abs(gerador.nextInt())) % 26);
        for (int i = 0; i < palavra.length();i++)
        {
            //verifica se e o caracter sorteado e troca casoseja
            if (palavra.charAt(i) == letratrocada)
                palavraModificada = palavraModificada + letraparatrocar;
            else
                palavraModificada = palavraModificada + palavra.charAt(i);
        }
        return palavraModificada;
    }

    public static void main(String [] args)
    {
        Random gerador = new Random();
        gerador.setSeed(4);
        String [] entrada = new String[1000];
        int Nentrada = 0;
        //leitura das strings
        do
        {
            entrada[Nentrada] = MyIO.readLine();
        }while(!isFim(entrada[Nentrada++]));
        Nentrada--;

        for (int i = 0;i < Nentrada;i++)
        {
            MyIO.println(stringModificada(entrada[i], gerador));
        }
    }
}