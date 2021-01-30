public class teste
{
    public static void main(String [] args)
    {
        Celula temp = primeiro;
        while(temp.prox != null)
        {
            temp = temp.prox; 
        }
        temp.prox=new Celula(x);
    }
}