#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#define false 0
#define true 1

bool isVogais(char palavra[])
{
    bool resp = true;
    for(int i = 0;i < strlen(palavra) - 1;i++)
    {
        if (palavra[i] != 'a' && palavra[i] != 'e' && palavra[i] != 'i' && palavra[i] != 'o' && palavra[i] != 'u')
        {
            resp = false;
            i = strlen(palavra);
        }
    }
    return resp;
}

bool isConsoante(char palavra[])
{
    bool resp = true;
    for (int i = 0;i < strlen(palavra) - 1;i++)
    {
        if ((palavra[i] == 'a' || palavra[i] == 'e' || palavra[i] == 'i' || palavra[i] == 'o' || palavra[i] == 'u') || !(palavra[i] >= 'a' && palavra[i] <= 'z'))
        {
            resp = false;
            i = strlen(palavra);
        }
    }
    return resp;
}

bool isInteiro(char palavra[])
{
    bool resp = true;
    for (int i = 0;i < strlen(palavra) - 1;i++)
    {
        if (!(palavra[i] >= '1' && palavra[i] <= '9'))
        {
            resp = false;
            i = strlen(palavra);
        }
    }
    return resp;
}

bool isReal(char palavra[])
{
    bool resp = true;
    int cont = 0;
    //verificar se tem apenas um . ou , e se e um numero
    for (int i = 0;i < strlen(palavra) - 1;i++)
    {
        if(!(palavra[i] >= '1' && palavra[i] <= '9') && (cont > 0 && (palavra[i] != '.' || palavra[i] != ',')))
            resp = false;
        else if (palavra[i] == '.' || palavra[i] == ',')
            cont++;
    }
    if (cont == 0)
        resp = false;
    return resp;
}

bool isFim(char palavra[])
{
    bool resp = false;
    if (strcmp(palavra,"FIM\n") == 0)
        resp = true;
    return resp;
}

int main()
{
    char entrada[10000];
    do
    {
        //leitura da string completa com o espaco
        fgets(entrada,100000,stdin);
        fflush(stdin);
        if (!isFim(entrada))
        {
            if (isVogais(entrada))
                printf("SIM ");
            else
                printf("NAO ");
            if (isConsoante(entrada))
                printf("SIM ");
            else
                printf("NAO ");
            if (isInteiro(entrada))
                printf("SIM ");
            else
                printf("NAO ");
            if (isReal(entrada))
                printf("SIM\n");
            else
                printf("NAO\n");
        }
    }while(!isFim(entrada));
    return 0;
}
