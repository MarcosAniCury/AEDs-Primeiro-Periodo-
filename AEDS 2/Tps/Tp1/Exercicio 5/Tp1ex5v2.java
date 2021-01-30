public class Tp1ex5v2
{
    public static int inverte(int n)
    {
        if (n == 0)
            n = 1;
        else
            n = 0;
        return n; 
    }

    public static boolean isNot(String palavra,int i)
    {
        return (palavra.charAt(i) == 'n' && palavra.charAt(i+1) == 'o' && palavra.charAt(i+2) == 't');
    }

    public static boolean isAnd(String palavra, int i)
    {
        return (palavra.charAt(i) == 'a' && palavra.charAt(i+1) == 'n' && palavra.charAt(i+2) == 'd');
    }
    
    public static boolean isOr(String palavra,int i)
    {
        return (palavra.charAt(i) == 'o' && palavra.charAt(i+1) == 'r');
    }

    public static boolean isAlone(String palavra)
    {
        return ((palavra.charAt(1) >= 'A' && palavra.charAt(1) <= 'Z') && palavra.charAt(2) == ')');
    }

    public static boolean Operacoes(int valor)
    {
        boolean resp = false;
        if (valor == 1)
            resp = true;
        return resp;
    }

    public static void main(String [] args)
    {
        int Nvariaveis = 0;
        do
        {
            Nvariaveis = MyIO.readInt();
            if (Nvariaveis != 0)
            {
                int[] variaveis = new int[Nvariaveis];
                for (int i = 0; i < Nvariaveis;i++)
                    variaveis[i] = MyIO.readInt();
                String operacao = MyIO.readLine();
                String operacao2 = "";
                char letra = 'A';
                for (int i=0;i<Nvariaveis;i++)
                {
                    operacao2 = operacao.replace(letra,(char)(variaveis[i] + 48));
                    operacao = operacao2;
                    letra =(char) ((int)letra + 1);
                }
                MyIO.println(operacao2);
                while (letra == 'C'/*operacao.length() > 1*/)
                {
                    int i = 0;
                    while (operacao.charAt(i) == '1' || operacao.charAt(i) == '0')
                        i++;
                    if(isAnd(operacao,4-i))
                    {
                        int temp = i;
                        int cont = 0;
                        while (operacao.charAt(temp) != ')')
                        {
                            if (operacao.charAt(temp) == 1 || operacao.charAt(temp) == 0)
                                cont++;
                            if (cont == 1)
                            {
                                String copiaope = operacao;
                                boolean valortemp = (Operacoes(variaveis[0]) && Operacoes(variaveis[1]));
                                operacao = "";
                                for (int j = 0;j < temp;j++)
                                    operacao += copiaope.charAt(j); 
                                if (valortemp)
                                    operacao += "1";
                                else
                                    operacao += "0";
                                for (int j = temp + 2;copiaope.charAt(j) == ')';j++)
                                    operacao += copiaope.charAt(j);
                            }
                            MyIO.println(operacao);
                            temp++;
                        }
                    }
                    letra = 'a';/*Remover*/
                }
            }
        }while (Nvariaveis > 0);
    }
}