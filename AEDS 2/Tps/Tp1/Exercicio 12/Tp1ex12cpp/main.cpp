#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

bool ehPalindromo(char entrada[], int comeco, int fim);
bool ehhPalindromo(char entrada[]);
bool isFim(char palavra[]);

//funcao para verificar se e FIM
bool isFim(char palavra[])
{
    bool resp = false;
    if (strcmp(palavra,"FIM\n") == 0)
        resp = true;
    return resp;
}

bool ehhPalindromo(char entrada[])
{
    return ehPalindromo(entrada, 0, strlen(entrada) - 2);
}

bool ehPalindromo(char entrada[], int comeco, int fim)
{
    //comparar o primeiro e o ultimo caracter e ir comparando decrescente ate chegar no caracter do meio
    bool resp = true;
    bool resp1 = true;
    if (comeco <= fim)
    {
        if (entrada[comeco] != entrada[fim])
        {
            resp = false;
            resp1 = false;
        }
        resp = ehPalindromo(entrada, ++comeco, --fim);
    }
    if (!resp1)
        resp = false;
    return resp;
}

int main()
{
    char entrada[100000];
    do
    {
        //leitura da string completa com o espaco
        fgets(entrada,100000,stdin);
        fflush(stdin);
        if (!isFim(entrada))
        {
            bool resp = ehhPalindromo(entrada);
            if (resp)
                printf("SIM\n");
            else
                printf("NAO\n");
        }
    }while (!isFim(entrada));
    return 0;
}
