import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.lang.Object;
class Selecao
{
    private static String[] array;
    private static int n;
    
    public Selecao (String[] array, int n)
    {
        this.array = array;
        this.n = n;
        selecao();
    }

    public static void swap(int i, int j) 
    {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void selecao() 
    {
        for (int i = 0; i < (n - 1); i++) 
        {
            String menor = array[i];
            int posicao = i;
            for (int j = (i + 1); j < n; j++)
            {
                if (menor.compareTo(array[j]) >= 0)
                {
                    menor = array[j];
                    posicao = j;
                }
            }
            swap(posicao, i);
        }
        public static Personagem[] GetOrderArray()
        {
            return array;
        } 
    }

public class prova1
{
    public static void main(String [] args)
    {
        String[] palavras = new String[50];
        String[] Ordenado = new String[50];
        String[] aux = new String [100];
        String[] aux2 = new String [100];
        String frase = null;
        int contador = 0;
        int contpalavra = 0;
        for(int i = 0;i<99;i++,aux[i] = "0",aux2[i] = "0");
        do
        {
            frase = MyIO.readLine();
            frase = frase.toLowerCase();
            aux = frase.split(" ");
            do
            {
                aux2 = aux[contador].split(".");
                aux2 = aux2[0].split(":");
                aux2 = aux2[0].split("\"");
                palavras[contpalavra] = aux2[0];
                contpalavra++;
                contador++;
            }while(aux[contador] != "0");
        }while(frase != null);
        Selecao ordenar = new Selecao(palavras, palavra.lenght());
        Ordenado = ordenar.GetOrderArray();
    }
}