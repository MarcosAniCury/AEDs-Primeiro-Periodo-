#include <stdio.h>
#include <stdlib.h>

void ArmazenamentoDado(float M[2][2]);
void NumeroIgual(float M[2][2],float val,int *arm1,int *arm2);
void Resultado(int arm1,int arm2);

int main()
{
    float M[2][2],Val;
    int arm1,arm2;
    ArmazenamentoDado(M);
    printf("\n Digite um valor qualquer real:");
    scanf("%f", &Val);
    NumeroIgual(M,Val,&arm1,&arm2);
    Resultado(arm1,arm2);
    return 0;
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

void NumeroIgual(float M[2][2],float val,int *arm1,int *arm2)
{
    int cont,cont2;
    for (cont = 0;cont < 2;cont++)
    {
        for (cont2 = 0;cont2 < 2;cont2++)
        {
            if (M[cont][cont2] == val)
            {
                *arm1 = cont;
                *arm2 = cont2;
            }
        }
    }
}

void Resultado(int arm1,int arm2)
{
    printf("\n O local da matriz q possui o valor igual ao digitado e o (%d,%d)", arm1 + 1 ,arm2 + 1);
}
