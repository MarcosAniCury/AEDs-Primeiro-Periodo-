public class Contido
{
    public static void main (String[] args)
    {
        int N;
        int X;
        boolean Contido = false;
        MyIO.println("Numero de elementos presentes no Array:");
        N = MyIO.readInt();
        int [] Entrada = new int [N];
        MyIO.println("Digite os elementos do Array:");
        Entrada [N] = MyIO.readInt();
        MyIO.println("Digite o inteiro:");
        X = MyIO.readInt();
        for (int i=0; i<N; i++)
        {
            if (Entrada[i] == X)
            {
                Contido = true;
            }
        }
        if(Contido)
        MyIO.println("O elemento esta contido");
        MyIO.println("O elemento nao esta contido");
    }
}