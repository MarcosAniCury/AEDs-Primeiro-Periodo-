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
    private CelulaQuadrupla auxiliar;
    private CelulaQuadrupla embaixo;
    private int n;
    /*
    * Construtor vazio 
    */
    public Matriz()
    {
        this(2);
    }
    /*
    * Construtor linhas e coluna
    */
    public Matriz (int n)
    { 
        this.n = n;
        //elementos da celula
        int cont = 1;
        for (int i = 0; i < n; i++)
        {

            for (int j = 0; j < n; j++)
            {
                // preenchendo a primeira linha:
                if (i == 0)
                {
                    if (j == 0)
                    {
                        primeira = new CelulaQuadrupla(cont++);
                        embaixo = primeira;
                        auxiliar = primeira;
                    }
                    else
                    {
                        CelulaQuadrupla celula = new CelulaQuadrupla(cont++); 
                        auxiliar.prox = celula; 
                        auxiliar.prox.ant = auxiliar; 
                        auxiliar = auxiliar.prox; 
                    }
                
                // criando o restante das linhas
                }
                else
                { 
                    CelulaQuadrupla celula = new CelulaQuadrupla(cont++); 
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

    public int[] Corrida(int linComeco, int colComeco)
    {
        CelulaQuadrupla tmp = primeira;
        for(int lin = 0;lin < linComeco;lin++, tmp = tmp.prox);
        for(int col = 0;col < colComeco;col++, tmp = tmp.inf);
        //elementos na ordem em que o batuke passa
        int[] elementosBatuke = new int[n*n + 1];
        //contador do vetor
        int cont = 0;
        //contador que auxilia o batuke a andar
        int andar = 0;
        //contador do quanto o Batuke andou
        int contBatuke = 0;
        //verifica se batuke já passou
        boolean japassou = false;
        do
        {
            //direita
            int i = 0;
            while(i < andar + 1 && cont < n*n)
            {
                japassou = jaPassou(elementosBatuke, tmp, cont);
                if (!japassou)
                    elementosBatuke[cont++] = tmp.elemento;
                if(tmp.prox != null)
                    tmp = tmp.prox;
                contBatuke++;
                i++;
            }
            japassou = false;
            i = 0;
            //baixo
            while(i < andar + 1 && cont < n*n)
            {
                japassou = jaPassou(elementosBatuke, tmp, cont);
                if (!japassou)
                    elementosBatuke[cont++] = tmp.elemento;
                if(tmp.inf != null)
                    tmp = tmp.inf;
                contBatuke++;
                i++;
            }
            japassou = false;
            andar++;
            i = 0;
            //esquerda
            while(i < andar + 1 && cont < n*n)
            {
                japassou = jaPassou(elementosBatuke, tmp, cont);
                if (!japassou)
                    elementosBatuke[cont++] = tmp.elemento;
                if(tmp.ant != null)
                    tmp = tmp.ant;
                contBatuke++;
                i++;
            }
            japassou = false;
            i = 0;
            //cima
            while(i < andar + 1 && cont < n*n)
            {
                japassou = jaPassou(elementosBatuke, tmp, cont);
                if (!japassou)
                    elementosBatuke[cont++] = tmp.elemento;
                if(tmp.sup != null)
                    tmp = tmp.sup;
                contBatuke++;
                i++;
            }
            andar++;
        }while(cont < n*n && andar < 1000);
        elementosBatuke[n*n] = contBatuke;
        return elementosBatuke;
    }

    public boolean jaPassou(int[] elementosBatuke, CelulaQuadrupla tmp, int cont)
    {
        boolean japassou = false;
        for (int j = 0;j < cont;j++)
        {
            if (elementosBatuke[j] == tmp.elemento)
                japassou = true;
        }
        return japassou;
    }
}

public class batuke
{
    public static void main(String []args)
    {
        int n = MyIO.readInt();
        int linInicio = MyIO.readInt();
        int colInicio = MyIO.readInt();
        Matriz batuke = new Matriz(n);
        int[] batukeCorreu = batuke.Corrida(linInicio, colInicio);
        for (int i = 0;i < batukeCorreu.length - 1;i++)
            MyIO.print(batukeCorreu[i]+" ");
        MyIO.println(" ");
        MyIO.println(batukeCorreu[batukeCorreu.length - 1]);
    }
}