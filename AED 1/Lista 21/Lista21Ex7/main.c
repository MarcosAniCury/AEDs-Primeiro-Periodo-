#include <stdio.h>
#include <stdlib.h>

const int NUM_LIN = 3;
const int NUM_COL = 3;

float SomaDaColuna(float A[NUM_LIN][NUM_COL],int coluna);
void Resultado(float soma);

int main()
{
    float A[3][3] = {{6,1,2},{20,3.5,7},{20,20,40}}, soma;
    int col;
    printf("\n Digite a coluna que deseja obter a soma:");
    scanf("%d", &col);
    soma = SomaDaColuna(A,col + 1);
    Resultado(soma);
    return 0;
}

float SomaDaColuna(float A[NUM_LIN][NUM_COL],int coluna)
{
    int cont;
    float soma = 0;
    for (cont = 0;cont < NUM_LIN;cont++)
    {
        soma += A[cont][coluna];
    }
    return soma;
}

void Resultado(float soma)
{
    printf("\n A soma dos valores da coluna requisitada e %f", soma);
}
