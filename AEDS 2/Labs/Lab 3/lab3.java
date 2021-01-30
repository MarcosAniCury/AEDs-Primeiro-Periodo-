public class lab3
{
    public static void printador(int num1, int num2)
    {
        String aparecertela = "";
        for(int i = num1; i <= num2;i++)
        {
            aparecertela += i;
        }
        aparecertela = inverte(aparecertela);
        MyIO.print(aparecertela);
        MyIO.print(" ");
    }
    public static boolean isFim(String palavra)
    {
        return (palavra.length() >= 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
    }
    public static int inverte(String aparecertela)
    {
        int i = aparecertela.length() - 1;
        for (; i >= 0; i--)
        {
            aparecertela += aparecertela.charAt(i);
        }
        return aparecertela;
	}
    public static void main(String [] args)
    {
        String[] entrada = new String[1000];
        int[] entrada0 = new int[1000];
        int contador = 0;
        do
        {
            //Entrada de string
            entrada[contador] = MyIO.readString();
        }while(!isFim(entrada[contador++]));
        contador--;//desconsiderar o FIM
        for (int i = 0; i < contador;i++)
        {
            entrada0[i] = Integer.parseInt(entrada[i]);
        }
        for (int i = 0; i < contador ;i++)
        {
            printador(entrada0[i],entrada0[++i]);
        }
    }
}