public void SomaRecursivaIndireta(Pilha pilha1,Pilha pilha2,Pilha2)
{
    SomaRecursiva(pilha1.topo,pilha2.topo,pilha3.topo);
}

//conteudo é o valor int dentro da celula
public void SomaRecursiva(Celula tmp1,Celula tmp2, Celula tmp3)
{
    int somaElementos = 0;
    if(tmp1 != null)
    {
        somaElementos += tmp1.conteudo;
        tmp1 = tmp1.inf;
    }
    if(tmp2 != null)
    {
        somaElementos += tmp2.conteudo;
        tmp2 = tmp2.inf;
    }
    if(tmp3 != null)
    {
        somaElementos += tmp3.conteudo;
        tmp3 = tmp3.inf;
    }
    MyIO.println("Soma dos conteudos:"+somaElementos);
    if (tmp1 != null || tmp2 != null || tmp3 != null)
        SomaRecursiva(tmp1,tmp2,tmp3);
}