public class lab4
{
    public static boolean isFim(String palavra)
    {
        return (palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
    }
    public static boolean parentece(String frase)
    {
        boolean retorno = false;
        boolean flag = false;
        int contador = 0;
        int contador2 = 0;
        for(int i = 0; i < frase.length();i++)
        {
            if(frase.charAt(i) == '(')
                contador++;
            if(frase.charAt(i) == ')')
                contador2++;
            if(contador2 > contador);
                flag = true;
        }
        if (contador == contador2 && !flag)
        {
            retorno = true;
        }
        return retorno;
    }
    public static void main(String[]args)
    {
        String[] entrada = new String[2000];
        int contador = 0;
        //laco de repeticao com execucao ate ser digitado a palavra FIM
        do
        {
            //Entrada de string
            entrada[contador] = MyIO.readLine();
        }while(!isFim(entrada[contador++]));
        contador--;//desconsiderar o FIM
        for(int i = 0; i < contador; i++)
        {
            if(parentece(entrada[i]))
            {
                MyIO.println("correto");
            }
            else
            {
                MyIO.println("incorreto");
            }
        }
    }
}