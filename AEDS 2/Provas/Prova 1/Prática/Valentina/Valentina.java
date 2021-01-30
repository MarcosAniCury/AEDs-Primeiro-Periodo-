import java.io.*;

public class Valentina
{
    public static void main(String [] args)
    {
        int n = MyIO.readInt();
        for(int i = 0;i<n;i++)
        {
            String produtos = MyIO.readLine();
            String[] produto = new String[1000];
            int contproduto = 0;
            int fim = produtos.lastIndexOf(" ");
            int comeco = 0;
            boolean armazena = false;
            for(int j = produtos.indexOf(" ");j<=fim && j != -1;j = produtos.indexOf(" ",j+1))
            {
                armazena = false;
                for (int x=0;x<contproduto;x++)
                    if(produtos.substring(comeco, j).equals(produto[x]))
                        armazena = true;
                if (!armazena)
                {
                    produto[contproduto] = produtos.substring(comeco, j);
                    contproduto++;
                }
                comeco = j+1;
            }
            armazena = false;
            for(int j=0;j<contproduto;j++)
                if(produtos.substring(fim+1, produtos.length()).equals(produto[j]))
                    armazena = true;
            if (!armazena)
            {
                produto[contproduto] = produtos.substring(fim+1, produtos.length());
                contproduto++;
            }

            for (int j = 1; j < contproduto; j++) 
            {
                String tmp = produto[j];
                int x = j - 1;
                
                while ((x >= 0) && (produto[x].compareTo(tmp) > 0))
                {
                    produto[x + 1] = produto[x];
                    x--;
                }
                produto[x + 1] = tmp;
            }
            
            for(int j = 0;j<contproduto;j++)
                MyIO.print(produto[j]+" ");
            MyIO.println(" ");
        }
    }
}