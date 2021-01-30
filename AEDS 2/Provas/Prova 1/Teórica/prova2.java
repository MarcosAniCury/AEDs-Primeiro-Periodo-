public class prova2
{
    public static void main(String [] args)
    {
        int[][] Triangulo = new int [10][10];
        int n
        n = MyIO.readInt();
        while(n != 0)
        { 
            int tam = MyIO.readInt();
            for (int i = 0;i < tam;i++)
            {
                for (int j = 0;j <= i + 1;j++)
                {
                    Triangulo[i][j] = MyIO.readInt();
                }
            }
            int maior = Triangulo[0][0];
            int temp = 0;
            //verificacao das bolas do canto esquerdo
            for (int i = 0;i < tam;i++)
            {
                temp = temp + Triangulo[i][0];
                if (maior < temp)
                    maior = temp;
            }
            temp = 0;
            //verificacao das bolas do canto direito
            for (int i = 0;i < tam;i++)
            {
                temp = temp + Triangulo[i][i];
                if (maior < temp)
                    maior = temp;
            }
            temp = 0;
            if (tam >= 3)
            {
                temp = Triangulo[2][1] + Triangulo[0][0] + Triangulo[0][1] + Triangulo[1][1];
                if (maior < temp)
                maior = temp;
                if (tam >= 4)
                {
                    for(int i = 3; i < tam;i++)
                    {
                        for(int j = i - 1,int cont = 0; cont < i - 1;j++,cont++)
                        {
                            int temp2 = temp + Triangulo[i][j];
                            if (cont % 2 == 0)
                            {
                                temp2 = temp2 + Triangulo[i-1][j-1];
                            }
                            if (maior < temp2)
                                maior = temp2;
                        }
                    }
                }
            }
            n = MyIO.readInt();
        }
    }
}