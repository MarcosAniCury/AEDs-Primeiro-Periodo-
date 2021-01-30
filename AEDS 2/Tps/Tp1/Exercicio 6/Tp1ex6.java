public class Tp1ex6
{
    public static boolean isVogais(String palavra)
    {
        boolean resp = true;
        for (int i = 0; i < palavra.length();i++)
        {
            if (palavra.charAt(i) != 'a' && palavra.charAt(i) != 'e' && palavra.charAt(i) != 'i' && palavra.charAt(i) != 'o' && palavra.charAt(i) != 'u')
            {    
                resp = false;
                i = palavra.length();
            }
        }
        return resp;
    }

    public static boolean isConsoante(String palavra)
    {
        boolean resp = true;
        for (int i = 0;i < palavra.length();i++)
        {
            if ((palavra.charAt(i) == 'a' || palavra.charAt(i) == 'e' || palavra.charAt(i) == 'i' || palavra.charAt(i) == 'o' || palavra.charAt(i) == 'u') || !(palavra.charAt(i) >= 'a' && palavra.charAt(i) <= 'z'))
            {    
                resp = false;
                i = palavra.length();
            }
        }
        return resp;
    }

    public static boolean isInteiro(String palavra)
    {
        boolean resp = true;
        for (int i = 0; i < palavra.length();i++)
        {
            if(!(palavra.charAt(i) >= '1' && palavra.charAt(i) <= '9'))
                resp = false;
        }
        return resp;
    }

    public static boolean isReal(String palavra)
    {
        boolean resp = true;
        int cont = 0;
        //verificar se tem apenas um . ou , e se e um numero
        for (int i = 0;i < palavra.length();i++)
        {
            if(!(palavra.charAt(i) >= '1' && palavra.charAt(i) <= '9') && (cont > 0 && (palavra.charAt(i) != '.' || palavra.charAt(i) != ',')))
                resp = false;
            else if (palavra.charAt(i) == '.' || palavra.charAt(i) == ',')
                cont++;
        }
        if (cont == 0)
            resp = false;
        return resp; 
    }

    public static boolean isFim(String palavra)
    {
        return (palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
    }
    
    public static void main (String [] args)
    {
        String[] entrada = new String[1000];
        int Nentrada = 0;
        do
        {
            entrada[Nentrada] = MyIO.readLine();
        }while(!isFim(entrada[Nentrada++]));
        Nentrada--;

        for (int i = 0; i < Nentrada;i++)
        {
            if (isVogais(entrada[i]))
                MyIO.print("SIM ");
            else
                MyIO.print("NAO ");
            if (isConsoante(entrada[i]))
                MyIO.print("SIM ");
            else
                MyIO.print("NAO ");
            if(isInteiro(entrada[i]))
                MyIO.print("SIM ");
            else
                MyIO.print("NAO ");
            if(isReal(entrada[i]))
                MyIO.println("SIM");
            else    
                MyIO.println("NAO");
        }
    }
}