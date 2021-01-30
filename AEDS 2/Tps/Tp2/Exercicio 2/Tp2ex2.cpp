#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

struct Jogador
{
    int id;
    char nome[100];
    int altura;
    int peso;
    char universidade[100];
    int anoNascimento;
    char cidadeNascimento[100];
    char estadoNascimento[100];
};

typedef struct Jogador Jogador;

//ler

void Lerid(Jogador *NBA,int cont)
{
    printf("%i", NBA[cont].id);
}

void Lernome(Jogador *NBA,int cont)
{
    printf("%s", NBA[cont].nome);
}

void Leraltura(Jogador *NBA,int cont)
{
    printf("%i", NBA[cont].altura);
}

void Lerpeso(Jogador *NBA,int cont)
{
    printf("%i", NBA[cont].peso);
}

void Leruniversidade(Jogador *NBA, int cont)
{
    printf("%s", NBA[cont].universidade);
}

void LeranoNascimento(Jogador *NBA, int cont)
{
    printf("%i", NBA[cont].anoNascimento);
}

void LercidadeNascimento(Jogador *NBA, int cont)
{
    printf("%s", NBA[cont].cidadeNascimento);
}

void LerestadoNascimento(Jogador *NBA,int cont)
{
    printf("%s", NBA[cont].estadoNascimento);
}

//imprimir

void ImprimirJogador (Jogador *NBA,int cont)
{
    printf("[");
    Lerid(NBA,cont);
    printf(" ## ");
    Lernome(NBA,cont);
    printf(" ## ");
    Leraltura(NBA,cont);
    printf(" ## ");
    Lerpeso(NBA,cont);
    printf(" ## ");
    LeranoNascimento(NBA,cont);
    printf(" ## ");
    Leruniversidade(NBA,cont);
    printf(" ## ");
    LercidadeNascimento(NBA,cont);
    printf(" ## ");
    LerestadoNascimento(NBA,cont);
    printf("]\n");
}

bool isFim(char entrada[])
{
    bool resp = false;
    if (strcmp(entrada,"FIM") == 0)
        resp = true;
    return resp;
}

int Trade(char temp[])
{
    int TAM = strlen(temp);
    int valores[TAM];
    int valor = 0;
    for (int i = 0;i < TAM;i++)
    {
        if (i != TAM - 1)
        {
            int dez = 1;
            int j=0;
            do
            {
                dez *= 10;
                j++;
            } while (j < TAM - i - 1);
            
            valores[i] = ((int) temp[i] - 48) * dez;
            valor += valores[i];
        }
        else
        {
            valor += (int) temp[i] - 48;
        }
    }
    return valor;
}

void Armazena(Jogador *NBA,char stringtemp[],int cont)
{
    char temp[100];
    int conttemp = 0;
    int contvirg = 0;
    for(int i = 0;i < strlen(stringtemp);i++)
    {
        if (stringtemp[i] != ',')
        {
            temp[conttemp] = stringtemp[i];
            conttemp++;
        }
        else
        {
            if (temp[0] != '0')
                temp[conttemp] = '\0';
            
            switch (contvirg)
            {
                case 0:NBA[cont].id = Trade(temp);
                    break;

                case 1: for (int j = 0; j < conttemp;j++)
                            NBA[cont].nome[j] = temp[j];
                    break;

                case 2: NBA[cont].altura = Trade(temp);
                    break;
                
                case 3: NBA[cont].peso = Trade(temp);
                    break;

                case 4: if (temp[0] == '0')
                            strcpy(temp, "nao informado");
                        strcpy (NBA[cont].universidade, temp);
                    break;

                case 5: NBA[cont].anoNascimento = Trade(temp);
                    break;

                case 6: if (temp[0] == '0')
                            strcpy (NBA[cont].cidadeNascimento, "nao informado");
                        for (int j = 0; j < conttemp;j++)
                            NBA[cont].cidadeNascimento[j] = temp[j];
                    break;

                default:
                    break;
            }
            contvirg++;
            for (int j = 0; j <= conttemp;j++)
                temp[j] = '0';
            conttemp = 0;
        }
    }
    if (stringtemp[strlen(stringtemp) - 1] == ',')
    {
        strcpy(temp, "nao informado"); 
        for (int j = 0; j < strlen(temp);j++)
            NBA[cont].estadoNascimento[j] = temp[j];
    }
    else
    {
        for (int j = 0; j < conttemp;j++)
            NBA[cont].estadoNascimento[j] = temp[j];
    }
    
}

void leitura(Jogador *NBA)
{
    FILE *arq;
    arq = fopen("/tmp/players.csv", "r");
    if (arq == 0)//null
        printf("\n Erro de leitura do arquivo");
    char stringtemp[300];
    fscanf(arq,"%[^\n]\n", stringtemp);
    for (int i = 0; i <= 3921;i++)
    {
        fscanf(arq,"%[^\n]\n", stringtemp);
        Armazena(NBA,stringtemp,i);
    }
    fclose(arq);
}

int main()
{
    Jogador NBA[4000];
    leitura(NBA);
    int cont = 0;
    char entrada[10];
    int valores[3921];
    do
    {   
        scanf("%s", entrada);
        if (!isFim(entrada))
        {
            valores[cont] = Trade(entrada);
            cont++;
        }
    } while (!isFim(entrada));
    
    for (int i = 0; i < cont;i++)
        ImprimirJogador(NBA,valores[i]);
    return 0;
}