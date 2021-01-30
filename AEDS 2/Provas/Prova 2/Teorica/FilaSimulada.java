
//considerei a classe criada com inicio e todas as operacoes da pilha
public void enfileirar(int i)
{   
    empilha(i);
}

public int desemfileirar(int i)
{
    Pilha tmp = new Pilha();
    int elemento = 0;
    do
    {
        elemento = pilha.desempilhar();
        if (!pilha.vazia())
            tmp.empilha(elemento);
    }while(!pilha.vazia());
    do
    {
        pilha.empilha(tmp.desempilha());
    }while(!tmp.vazia());
    return elemento;
}