public class Tp1ex3
{
    public static boolean isFim(String palavra)
    {
        return (palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
    }

    public static String Cifrada(String palavra)
    {
        String palavracifrada = "";
        int letratrocada;
        for (int i = 0; i < palavra.length();i++)
        {
            //pega letra por letra e soma 3 ao valor ASCII
            letratrocada = (int) palavra.charAt(i) + 3;
            //vai juntando as letras a string criando uma string cifrada
            palavracifrada = palavracifrada + (char) letratrocada; 
        }
        return palavracifrada;
    }

    public static void main (String [] args)
    {
        String[] entrada = new String[1000];
        int Nentrada = 0;
        //leitura das strings
        do
        {
            entrada[Nentrada] = MyIO.readLine();
        }while(!isFim(entrada[Nentrada++]));
        Nentrada--;

        for (int i = 0;i < Nentrada;i++)
        {
            MyIO.println(Cifrada(entrada[i]));
        }
    }
}