#include <stdio.h>
#include <stdlib.h>
#include <Stdbool.h>

void ArmazenamentoDeDados(float nota[100000]);
float NotaMedia(float nota[100000]);
int NotaAcimaMedia(float nota[100000],float notamedia);
void Resultados(float notamedia,int notacimamedia);
const int tam = 1000;

int main()
{
    float notamedia,nota[tam];
    int notasacimamedia;
    ArmazenamentoDeDados(nota);
    notamedia = NotaMedia(nota);
    notasacimamedia = NotaAcimaMedia(nota,notamedia);
    Resultados(notamedia,notasacimamedia);
    return 0;
}

void ArmazenamentoDeDados(float nota[tam])
{
    float notas;
    int cont = 0;
    bool erro;
    do
    {
        do
        {
            printf("\n Digite a nota do aluno:");
            scanf("%f", &notas);
            erro = notas > 100;
            if (notas >= 0)
            {
                nota[cont] = notas;
                cont++;
            }
            if (erro)
                printf("\n Valor invalido digite novamente.");
        }while(erro);
    }while (notas >= 0);
}

float NotaMedia(float nota[tam])
{
    int cont;
    float notamedia = 0;
    for (cont = 0;nota[cont] >= 0;cont++)
        notamedia += nota[cont];
    notamedia = notamedia / cont;
    return notamedia;
}

int NotaAcimaMedia(float nota[tam],float notamedia)
{
    int cont = 0,cont2 = 0;
    for (;nota[cont] >= 0;cont++)
    {
        if(nota[cont] > notamedia)
            cont2++;
    }
    return cont2;
}

void Resultados(float notamedia,int notacimamedia)
{
    printf("\n A nota media da turma e %f", notamedia);
    printf("\n Ha %d notas acima da media", notacimamedia);
}


