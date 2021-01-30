public class Lab2Q1
{
    public static boolean isFim(String palavra)
    {
        return (palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
    }
    public static void stringcomb(String palavra1, String palavra2)
    {
        //cont == contador
        String palavracomb;
        int contcomb = 0;
        int totalcaract = palavra1.length() + palavra2.length();
        int contpal1 = 0;
        int contpal2 = 0;
        //laco para combinar as duas palavras
        do
        {
            if (contpal1 < palavra1.length())
            {
                MyIO.print(palavra1.charAt(contpal1));
                contcomb++;
                contpal1++;
            }
            if (contpal2 < palavra2.length())
            { 
                MyIO.print(palavra2.charAt(contpal2));
                contcomb++;
                contpal2++;
            } 
        }while(contcomb < totalcaract);
        MyIO.println("");
    }
    public static void main(String [] args)
    {
        String[] entrada = new String[1000];
        int i = 0;
        //Verificar se a palavra digitada foi "FIM"
        do
        {
            entrada[i] = MyIO.readString();
        } while(isFim(entrada[i++]) == false);
        i--;
        //Enviar 2 strings e retornar elas combinadas
        int iconb = 0;
        for(int j = 0;j < i/2;j++)
        {
            stringcomb(entrada[iconb],entrada[1 + iconb]);
            iconb = iconb + 2;
        }
    }
}