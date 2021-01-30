//levei em consideracao que antes de encher as estruturas no caso hash elas foram inicializadas com a flag -1 que significa vazia

public static void mostrarElementos()
{
    for(int i = 0;i < tam1;i++)
    {
        int elemento = t1[i].elemento;
        if(elemento != -1)
        {
            MyIO.print(elemento+" ");
            for(int j = 0;i < tam2;j++)
            {
                int elementot2 = t1.t2.tab[j];
                if(elementot2 != -1)
                    MyIO.print(elementot2+" ");
            }
            Celula temp = t1.t2.primeiroT3;
            if (temp != t1.t2.ultimoT3)
            {
                do
                {
                    MyIO.print(temp.elemento+" ");
                    temp = temp.prox;
                }while(temp != null);
            }
            mostrarArvore(t1.t2.raizT3);
        }
    }
}

public void mostrarArvore(No i)
{
    if(i != null)
    {
        mostrarArvore(i.esq);
        MyIO.print(i.elemento+" ");
        mostrarArvore(i.dir);
    }
}