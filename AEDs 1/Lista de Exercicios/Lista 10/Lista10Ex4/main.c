#include <stdio.h>
#include <stdlib.h>

void apre();
int ida();
int dia(int id);
void fim(int di);
int main()
{
   int id,di;
   apre();
   id = ida();
   di = dia(id);
   fim(di);
}

void apre()
{
    printf("\n Algoritmo para calcular dias vividos.");
}

int ida()
{
    int id;
    printf("\n Digite a sua idade:");
    scanf("%d", &id);
    return id;
}

int dia(int id)
{
    int di = 0;
    for (id;id != 0;id--)
        di += 365;
    return di;
}

void fim(int di)
{
    printf("\n Voce viveu durante %d dias.", di);
}
