#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

//funcao para verificar se e FIM
bool isFim(char palavra[])
{
    bool resp = false;
    if (strcmp(palavra,"FIM\n") == 0)
        resp = true;
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
            //comparar o primeiro e o ultimo caracter e ir comparando decrescente ate chegar no caracter do meio
            int comeco = 0;
            int fim = strlen(entrada) - 2;
            bool resp = true;
            while (comeco <= fim)
            {
                if (entrada[comeco] != entrada[fim])
                    resp = false;
                comeco++;
                fim--;
            }
            if (resp)
                printf("SIM\n");
            else
                printf("NAO\n");
        }
    }while (!isFim(entrada));
    return 0;
}
