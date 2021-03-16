#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#define MAX 100

struct Cadastro
{
    char nome[30];
    int diaN;
    int mesN;
};

typedef struct Cadastro Cadas;

int TAM = 0;

void menu();
void apresentacao();
void CadastroUser(Cadas user[]);
int Mes();
void AniverMes(Cadas user[MAX],int mes);

void main()
{
    int Menu;
    Cadas user[MAX];
    apresentacao();
    do
    {
        menu();
        scanf("%d", &Menu);
        switch (Menu)
        {
            case 0:printf("\nObrigado por usar nosso programa.");
                break;
            case 1:CadastroUser(user);
                TAM++;
                break;
            case 2:AniverMes(user,Mes());
                break;
            default:printf("\nValor invalido digite novamente.");
        }
    }while(Menu != 0);
}

void apresentacao()
{
    printf("Algoritmo de cadastro de usuarios.");
}

void menu()
{
    printf("\nMenu do programa");
    printf("\n0-Sair do programa");
    printf("\n1-Cadastrar um usuario");
    printf("\n2-Aniversariantes do mes");
    printf("\nDigite qual opcao desejada:");
}

void CadastroUser(Cadas user[])
{
    bool teste;
    if (TAM < 100)
    {
        printf("\nDigite o seu nome:");
        scanf("%s", user[TAM].nome);
        do
        {
            printf("\nDigite o dia do seu aniversario:");
            scanf("%d", &user[TAM].diaN);
            teste = user[TAM].diaN > 0 && user[TAM].diaN < 32;
        }while(!teste);
        do
        {
            printf("\nDigite o mes do seu aniversario:");
            scanf("%d", &user[TAM].mesN);
            teste = user[TAM].mesN > 0 && user[TAM].mesN < 13;
        }while (!teste);
    }
}

int Mes()
{
    bool teste;
    int mes;
    do
    {
        printf("\nDigite o mes ao qual deseja os aniversariantes:");
        scanf("%d", &mes);
        teste = mes > 0 && mes < 13;
    }while (!teste);
    return mes;
}

void AniverMes(Cadas user[MAX],int mes)
{
    for (int cont = 0;cont < TAM;cont++)
    {
        if(user[cont].mesN == mes)
            printf("\naniversariante do mes:%s\n",user[cont].nome);
    }
}
