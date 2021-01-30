public class Tp1ex11
{
    public static boolean isFim(String palavra)
    {
        return (palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
    }

    public static boolean ehPalindromo(String palavra)
    {
        return ehhPalindromo(palavra, 0, palavra.length() - 1);
    }

    public static boolean ehhPalindromo(String palavra, int begin, int end)
    {
        boolean resp = true;
        boolean verifica = true;
        //verificar caracter um por um para ver se sao iguais
        if(begin <= end)
        {
            if(palavra.charAt(begin) != palavra.charAt(end))
            {
                resp = false;
                verifica = false;
            }
            //chamada recursiva
            resp = ehhPalindromo(palavra, ++begin, --end);
            if (!verifica)
                resp = false;
        }
        return resp;
    }

    public static void main(String [] args)
    {
        String[] entrada = new String[1000];
        int Nentrada = 0;
        //entrada das strings
        do
        {
            entrada[Nentrada] = MyIO.readLine();
        }while(!isFim(entrada[Nentrada++]));
        Nentrada--;

        //print se e palindromo ou n
        for (int i = 0;i < Nentrada; i++)
        {
            if (ehPalindromo(entrada[i]))
                MyIO.println("SIM");
            else
                MyIO.println("NAO");
        }
    }
}