#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <ctype.h>
//FOI UTILIZADO A ALTURA POIS NAO ENCONTREI UMA FORMA RELACIONADO COM IDADE
void apre();
char gene();
float altu();
float calcu(char gen,float al);
void fim(float cal);
int main()
{
    char gen;
    float cal,al;
    apre();
    gen = gene();
    al = altu();
    cal = calcu(gen,al);
    fim(cal);
    return 0;
}

void apre()
{
    printf("\n Algoritmo de calculo para peso ideal. \n");
}

char gene()
{
    char gen;
    bool ero;
    do
    {
        fflush(stdin);
        printf("\n Digite o seu genero \n M para masculino \n F para feminino:");
        scanf("%c", &gen);
        gen = toupper(gen);
        ero = gen == 'M' || gen == 'F';
    }while (!ero);
    return gen;
}

float altu()
{
    float al;
    bool ero;
    do
    {
        printf("\n Digite o seu peso(em m):");
        scanf("%f", &al);
        ero = al < 0;
    }while (ero);
    return al;
}

float calcu(char gen,float al)
{
    float cal;
    if (gen == 'M')
    {
        cal = (72.7 * al) - 58;
    }
    else
    {
        cal = (62.1 * al) - 44.7;
    }
    return cal;
}

void fim(float cal)
{
    printf("\n O peso ideal para vc e %f", cal);
}

