class CelulaQuadrupla 
{
   public int elemento;
   public CelulaQuadrupla prox, ant, sup, inf;
   
   public CelulaQuadrupla()
   {
      this(MyIO.readInt());
   }
   public CelulaQuadrupla(int x)
   {
      
      this.elemento = x;
      this.prox = this.ant = this.sup = this.inf = null;
   }
}

class Matriz
{
   private CelulaQuadrupla primeira;
   private CelulaQuadrupla ultima;
   private CelulaQuadrupla auxiliar;
   private CelulaQuadrupla embaixo;
   private static int linhas, colunas;
  /*
   * Construtor vazio 
   */
   public Matriz()
   {
      this(2, 2);
   }
   /*
    * Construtor linhas e coluna
    */
    public Matriz (int linha, int coluna)
    { 
        linhas = linha;
        colunas = coluna;
        for (int i = 0; i < linhas; i++)
        {

            for (int j = 0; j < colunas; j++)
            {
                // preenchendo a primeira linha:
                if (i == 0)
                {
                    if (j == 0)
                    {
                        primeira = new CelulaQuadrupla();
                        embaixo = primeira;
                        auxiliar = primeira;
                    }
                    else
                    {
                        CelulaQuadrupla celula = new CelulaQuadrupla(); 
                        auxiliar.prox = celula; 
                        auxiliar.prox.ant = auxiliar; 
                        auxiliar = auxiliar.prox; 
                    }
                
                // criando o restante das linhas
                }
                else
                { 
                    CelulaQuadrupla celula = new CelulaQuadrupla(); 
                    auxiliar.inf = celula; 
                    celula.sup = auxiliar; 
                    if (j != 0)
                    {
                        auxiliar.ant.inf.prox = celula; 
                        celula.ant = auxiliar.ant.inf; 
                    }
                    if (auxiliar.prox != null)
                        auxiliar = auxiliar.prox;
                }
            } 

            if (i != 0)
                embaixo = embaixo.inf;
            auxiliar = embaixo;
        }   
    }

   public void Imprimir()
   {
      CelulaQuadrupla i;
      CelulaQuadrupla k = this.primeira;
      for (int l = 0; l < linhas;k = k.inf, l++)
      {
         i = k;
         for (int j = 0; j < colunas; i = i.prox, j++)
         { 
            System.out.println(i.elemento);
         }
      }
   }

    public void Soma(Matriz matriz2)
    {
        CelulaQuadrupla tmp = primeira;
        CelulaQuadrupla tmp2 = matriz2.getPrimeira();
        int somaCelula = tmp.elemento + tmp2.elemento;
        boolean acabouMatriz1 = false;
        boolean acabouMatriz2 = false;
        MyIO.print(somaCelula+" ");
        tmp = tmp.prox;
        tmp2 = tmp2.prox;
        for (int i = 0;i < linhas && i < matriz2.getLinhas();i++)
        {
            while ((tmp != null || tmp2 != null) && somaCelula != 0)
            {
                somaCelula = 0;
                if (tmp != null && !acabouMatriz1)
                {
                    somaCelula += tmp.elemento;
                    tmp = tmp.prox;
                }
                if (tmp2 != null && !acabouMatriz2)
                {
                    somaCelula += tmp2.elemento;
                    tmp2 = tmp2.prox;
                }
                MyIO.print(somaCelula+" ");
            }
            MyIO.println("");
            tmp = primeira;
            tmp2 = matriz2.getPrimeira();
            int j = 0;
            while(j < colunas - 1 || j < matriz2.getColunas() - 1)
            {
                j++;
                if (tmp.inf != null)
                    tmp = tmp.inf;
                else
                    acabouMatriz1 = true;
                if (tmp2.inf != null)
                    tmp2 = tmp2.inf;
                else
                    acabouMatriz2 = true;
            }
        }
    }

    public void Multiplicacao(Matriz matriz2)
    {
        for (int i = 0;i < colunas;i++)
        {
            for(int j = 0;j < linhas;j++)
            {
                CelulaQuadrupla tmp = primeira;
                for (int k = colunas - i;k < colunas;k++)
                    tmp = tmp.inf;
                CelulaQuadrupla tmp2 = matriz2.getPrimeira();
                for (int k = linhas - j;k < linhas;k++)
                    tmp2 = tmp2.prox;
                int elemento = 0;
                do
                {
                    elemento += tmp.elemento*tmp2.elemento;
                    tmp = tmp.prox;
                    tmp2 = tmp2.inf;
                }while(tmp != null && tmp2 != null);
                MyIO.print(elemento+" ");
            }
            MyIO.println(" ");
        }
    }

    public void diagonalPrincipal()
    {
        CelulaQuadrupla tmp = primeira;
        if (tmp != null)
        {
            MyIO.print(tmp.elemento);
            while(tmp.inf != null && tmp.inf.prox != null)
            {
                tmp = tmp.inf.prox;
                MyIO.print(" "+tmp.elemento);
            }
            MyIO.println("");
        }
    }

    public void diagonalSecundaria()
    {
        CelulaQuadrupla tmp = primeira;
        if (tmp != null)
        {
            for(;tmp.prox != null;tmp = tmp.prox);
            MyIO.print(tmp.elemento);
            while (tmp.inf != null && tmp.inf.ant != null)
            {
                tmp = tmp.inf.ant;
                MyIO.print(" "+tmp.elemento);
            }
            MyIO.println("");
        }
    }

    //Sets e Gets
    
    public CelulaQuadrupla getPrimeira()
    {
        return primeira;
    }

    public int getLinhas()
    {
        return linhas;
    }

    public int getColunas()
    {
        return colunas;
    }
}

public class Tp3ex9
{
    public static void main(String [] args)
    {
        int numOperacoes = MyIO.readInt();
        for(int i = 0;i < numOperacoes;i++)
        {
            int numLinM1 = MyIO.readInt();
            int numColM1 = MyIO.readInt();
            Matriz Matriz1 = new Matriz(numColM1,numLinM1);
            int numLinM2 = MyIO.readInt();
            int numColM2 = MyIO.readInt();
            Matriz Matriz2 = new Matriz(numColM2,numLinM2);
            Matriz1.diagonalPrincipal();
            Matriz1.diagonalSecundaria();
            Matriz1.Soma(Matriz2);
            Matriz1.Multiplicacao(Matriz2);
        }
    }
}