#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
void apre();
float base();
float altura();
float calcula(float b, float al);
void fim(float cal);
int main()
{
    float b,al,cal;
    apre();
    b = base();
    al = altura();
    cal = calcula(b,al);
    fim(cal);
    return 0;
}

void apre()
{
    printf("\n Algoritmo de calculo de um retangulo. \n");
}

float base()
{
    bool ero;
    float b;
    do
    {
        printf("\n Digite o valor da base:");
        scanf("%f", &b);
        ero = b < 0;
    }while (ero);
    return b;
}

float altura()
{
    bool ero;
    float al;
    do
    {
        printf("\n Digite o valor da base:");
        scanf("%f", &al);
        ero = al < 0;
    }while (ero);
    return al;
}

float calcula(float b, float al)
{
    float cal;
    cal = b * al;
    return cal;
}

void fim(float cal)
{
    printf("\n A area do retangulo e %f", cal);
}
