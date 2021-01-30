public boolean pesquisar(String s)
{
    return pesquisar(s, raiz, 0);
}

public boolean pesquisar(String s, No no, int i)
{
    boolean resp = false;
    try
    {
        if(acharNo(s.charAt(i), no) == null)
            resp = false;
        else if(i == s.length() - 1)
            resp = (acharNo(s.charAt(i), no).folha == true);
        else if(i < s.length() - 1)
            resp = pesquisar(s, acharNo(s.charAt(i), no), i + 1);
        else
            throw new Exception("Erro ao pesquisar!");
    }
    catch(Exception erro)
    {
        erro.printStackTrace();
    }
    return resp;
}

//Funcao para achar um no

public No acharNo(char letra,No no)
{
    int ASCII = (int) letra;
    No nolista = no.lista.inicio;
    for(int i = 0;i < ASCII;nolista = nolista.prox,i++);
    return nolista;
}