#include <stdio.h>
#include <stdlib.h>

void Copia(float M[2][2],float M2[2][2]);
void ArmazenamentoDado(float M[2][2]);
void Resultado(float M2[][2]);

int main()
{
    float M[2][2];
    float M2[2][2];
    ArmazenamentoDado(M);
    Copia(M,M2);
    Resultado(M2);
    return 0;
}

void Copia(float M[2][2],float M2[2][2])
{
    for (int cont = 0;cont < 2;cont++)
    {
        for (int cont2 = 0;cont2 < 2;cont2++)
        {
            M2[cont][cont2] = M[cont][cont2];
        }
    }
}

void ArmazenamentoDado(float M[2][2])
{
    int cont,cont2;
    for (cont = 0;cont < 2;cont++)
    {
        for (cont2 = 0;cont2 < 2;cont2++)
        {
            printf("\n Digite o valor (%d,%d) da matriz:",cont + 1,cont2 + 1);
            scanf("%f", &M[cont][cont2]);
        }
    }
}

void Resultado(float M2[][2])
{
    int cont,cont2;
    for (cont = 0;cont < 2;cont++)
    {
        for (cont2 = 0;cont2 < 2;cont2++)
            printf("\n Valor (%d,%d) e %f",cont,cont2,M2[cont][cont2]);
    }
}
