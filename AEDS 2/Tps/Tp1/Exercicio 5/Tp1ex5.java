public class Tp1ex5
{
    public static int inverte(int n)
    {
        if (n == 0)
            n = 1;
        else
            n = 0;
        return n; 
    }

    public static boolean isNot(String palavra)
    {
        return (palavra.charAt(0) == 'n' && palavra.charAt(1) == 'o' && palavra.charAt(2) == 't');
    }

    public static boolean isAnd(String palavra)
    {
        return (palavra.charAt(0) == 'a' && palavra.charAt(1) == 'n' && palavra.charAt(2) == 'd');
    }
    
    public static boolean isOr(String palavra)
    {
        return (palavra.charAt(0) == o && palavra.charAt(1) == r);
    }

    public static boolean isAlone(String palavra)
    {
        return ((palavra.charAt(1) >= 'A' && palavra.charAt(1) <= 'Z') && palavra.charAt(2) == ')');
    }

    public static boolean Operacao(String frase, int n, int[] operacoes)
    { 
        String tipooeracoes = "";
        int cont = 1;
        for(int i = cont; i <= cont + 2;i++)
            tipooeracoes += frase.charAt(i);
        
        if(isAnd(tipooeracoes))
        {
            tipooeracoes = "";
            cont += 3;
            for(int i = cont; i <= cont + 2;i++)
                tipooeracoes += frase.charAt(i);
            if(isAlone(tipooeracoes))
            {
                
            }
        }
        else if(isNot(tipooeracoes))
        {

        }
        else if(isOr(tipooeracoes))
        {

        }
        else
        {

        }

    }

    public static boolean resultadoBool(int n, int[] operacoes, String entrada)
    {
        String tipooperacao = "";
        for(int i = 0;i < 3;i++)
            tipooperacao += entrada.charAt(i);
        int cont = 3;
        if (isAnd(tipooperacao))
        {
            tipooperacao = "";
            for (int i = cont;i < entrada.length();i++)
                tipooperacao += entrada.charAt(i);
            Operacoes(tipooperacao, n, operacoes);
        }
        else if (isNot(tipooperacao))
        {
            tipooperacao = "";
            for (int i = cont;i < entrada.length();i++)
                tipooperacao += entrada.charAt(i);
            Operacoes(tipooperacao, n, operacoes);
        }
        else
        {
            cont--;
            tipooperacao = "";
            for (int i = cont;i < entrada.length();i++)
                tipooperacao += entrada.charAt(i);
            Operacoes(tipooperacao, n, operacoes);
        }
        return true;
    }

    public static void main(String [] args)
    {
        int nOperacoes;
        do
        {
            nOperacoes = MyIO.readInt();
            if (nOperacoes != 0)
            {
                int[] operacoes = new int[5];
                for (int i = 0;i < nOperacoes;i++)
                    operacoes[i] = MyIO.readInt();
                String entrada = MyIO.readLine();
                if(resultadoBool(nOperacoes, operacoes, entrada))
                    MyIO.println("falha");
                else    
                    MyIO.println("0");
            }
        }while(nOperacoes != 0);
    }
}