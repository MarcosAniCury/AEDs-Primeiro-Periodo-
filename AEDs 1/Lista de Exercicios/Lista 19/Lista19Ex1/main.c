#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

void ArmazenamentoDeDados();
float NotaMediaArq ();

int main()
{
    float notamedia;
    ArmazenamentoDeDados();
    notamedia = NotaMediaArq();
    return 0;
}

void ArmazenamentoDeDados()
{
    FILE *arq;
    float nota;
    bool erro;
    arq = fopen("notas.txt", "w");
    do
    {
        do
        {
            printf("\n Digite a nota do aluno:");
            scanf("%f", &nota);
            erro = nota < 0 || nota > 100;
            if (erro)
                printf("\n Valor invalido digite novamente.");
        }while(erro);
        if (arq == 0)//null
            printf("\n Erro na criacao do arquivo.");
        if (nota != 0)
            fprintf(arq,"%f \n",nota);
    }while (nota != 0);
    fclose(arq);
}

float NotaMediaArq()
{
    FILE *arq;
    float notamedia = 0,nota;
    int contador = 0,erro;
    arq = fopen("notas.txt", "r");
    do
    {
        if (arq == 0)//null
            printf("\n Erro na criacao do arquivo.");
        erro = fscanf(arq,"%f\n",&nota);
        notamedia += nota;
        contador++;
    }while(erro != EOF);
    fclose(arq);
    notamedia = notamedia / contador;
    return notamedia;
}

