#include <iostream>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

const int MAX = 100;
int TAM = 0;

class agenda
{
    private:
        char nome[30];
        int dia;
        int mes;
    public:

        void SetNome(char nome[30])
        {
            strcpy(this->nome,nome);
        }

        void SetDia(int dia)
        {
            if (dia < 0 || dia > 31)
                this->dia = 0;
            this->dia = dia;
        }

        void SetMes(int mes)
        {
            if (mes < 0 || mes > 12)
                this->mes = 0;
            this->mes = mes;
        }

        char GetNome()
        {
            return nome[30];
        }

        int GetMes()
        {
            return mes;
        }

        int GetDia()
        {
            return dia;
        }

        void CadastroUser()
        {
            char nome[30];
            int dia;
            int mes;
            printf("\n\nDigite seu nome:");
            scanf("%s", nome);
            SetNome(nome);
            printf("\nDigite o dia de nascimento:");
            scanf("%d", &dia);
            SetDia(dia);
            printf("\nDigite o mes de nascimento:");
            scanf("%d", &mes);
            SetMes(mes);
        }
};

void apresentacao();
void menu();
void AniverMes(agenda pessoa[MAX],int mes);
int Mes();

int main()
{
    int Menu;
    agenda pessoa[MAX];
    apresentacao();
    do
    {
        menu();
        scanf("%d", &Menu);
        switch (Menu)
        {
            case 0:printf("\nObrigado por usar nosso programa.");
                break;
            case 1:pessoa[TAM].CadastroUser();
                TAM++;
                break;
            case 2:AniverMes(pessoa,Mes());
                break;
            default:printf("\nValor invalido digite novamente.");
        }
    }while(Menu != 0);
    return 0;
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

void AniverMes(agenda pessoa[MAX],int mes)
{
    for (int cont = 0;cont < TAM;cont++)
    {
        if(pessoa[cont].GetMes() == mes)
            printf("\naniversariante do mes:%s\n",pessoa[cont].GetNome());//Nao sei retornar uma cadeia de caracter;
    }
}

