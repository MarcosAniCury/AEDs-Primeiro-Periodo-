#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int MenuCadastrarAmizade(int A[100][100]);
void PesquisaRelacoes(int A[100][100],int dados);
void PesquisaNumRelacoes(int A[100][100],int dados);
void VetoresIdenticos(int A[100][100],int dados);

int main()
{
    int menu,dados;
    int A[100][100];
    bool erro = 0;
    do
    {
        //Menu
        printf("\n Menu do Algoritmo de Amizades. \n");
        printf("\n 0-Sair \n 1-Cadastrar as relacoes de amizade \n 2-Pesquisar relacoes de amizade de uma pessoa");
        printf("\n 3-Pesquisar o numero de relacoes de amizade de uma pessoa. \n 4-Verificar se ha a relacao de amizade da pessoa com ela mesma.");
        printf("\n \n Digite a sua opcao desejada:");
        scanf("%d", &menu);
        switch (menu)
        {
            case 0:erro = 1;//Sair do programa
                    break;
            case 1:erro = 0;
                    dados = MenuCadastrarAmizade(A);//Cadastrar vetores
                    break;
            case 2:erro = 0;
                    PesquisaRelacoes(A,dados);//Pesquisar vetores e retornar uma mensagem na tela para os que possuem 1
                    break;
            case 3:erro = 0;
                    PesquisaNumRelacoes(A,dados);//Contar quantos vetores possuem 1
                    break;
            case 4:erro = 0;
                    VetoresIdenticos(A,dados);//Pesquisar vetores da matriz identicos que possuem 1
                    break;
            default: erro = 0;
                    printf("\n Opcao invalida, digite novamente.");
        }
    }while (!erro);
    return 0;
}

int MenuCadastrarAmizade(int A[100][100])//Cadastrar vetores
{
    int dados;
    printf("\n Digite quantas pessoas voce deseja cadastrar:");
    scanf("%d", &dados);
    for (int cont = 0;cont < dados;cont++)
    {
        for (int cont2 = 0;cont2 < dados;cont2++)
        {
            fflush(stdin);
            printf("\n Digite se a amizade entre %d e %d existe (Digite 1) ou nao existe (digite 0):", cont + 1,cont2 + 1);
            scanf("%d", &A[cont][cont2]);
        }
    }
    return dados;
}

void PesquisaRelacoes(int A[100][100],int dados)//Pesquisar vetores e retornar uma mensagem na tela para os que possuem 1
{
    int pesquisa;
    printf("\n Digite qual vetor voce deseja pesquisar:");
    scanf("%d", &pesquisa);
    for (int cont = 0;cont < dados;cont++)
    {
        if(A[pesquisa][cont] == 1)
            printf("\n Ha relacoes de amizade entre os vetores %d e %d \n", pesquisa,cont);
    }
}

void PesquisaNumRelacoes(int A[100][100],int dados)//Contar quantos vetores possuem 1
{
    int pesquisa, cont2 = 0;
    printf("\n Digite qual vetor vc deseja pesquisar o numero de relacoes:");
    scanf("%d", &pesquisa);
    for (int cont = 0;cont < dados;cont++)
    {
        if(A[pesquisa][cont] == 1)
            cont2++;
    }
    printf("\n O numero de relacoes de amizade q esse vetor possui e de %d \n", cont2);
}

void VetoresIdenticos(int A[100][100],int dados)
{
    for (int cont = 0;cont < dados;cont++)
    {
        if(A[cont][cont] == 1)
            printf("\n O vetor %d possui amizade com ele mesmo.", cont);
    }
}
