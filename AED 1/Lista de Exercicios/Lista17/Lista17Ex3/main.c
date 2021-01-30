#include <stdio.h>
#include <stdlib.h>

void LerArranjo(int C[]);
void TrocaArranjo (int D[]);
void escreverArranjo (int D[]);

int main()
{

    int A[6] = {6,5,4,3,2,1};
    int B[6] = {3,1,6,4,2,5};
    int C[6];
    LerArranjo(C);
    TrocaArranjo(A);
    TrocaArranjo(B);
    TrocaArranjo(C);
    escreverArranjo (A);
    escreverArranjo (B);
    escreverArranjo (C);
    return 0;
}

void LerArranjo(int C[])
{
    int con = 0;
    for (con;con != 5;con++)
    {
        printf("\n Digite o %i valor do Array:", ++con);
        scanf("%i", C[con]);
    }
}

void TrocaArranjo (int D[])
{
    int aux;
    int arm;
    aux = D[5];
    for (int cont = 0;cont <= 5;cont++)
    {
        if (D[5] < D[cont])
        {
            D[5] = D[cont];
            arm = cont;
        }
    }
    D[arm] = aux;
}

void escreverArranjo (int D[])
{
   for (int cont = 0;cont <= 5;cont++)
   {
       printf("O %i valor do array e %i", cont,D[cont]);
   }
}

