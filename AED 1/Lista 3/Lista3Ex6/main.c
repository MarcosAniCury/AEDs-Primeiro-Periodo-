#include <stdio.h>
#include <stdlib.h>

int main()
{
    float nota1,nota2,cal;
    printf("\n Algoritmo de avaliacao.");
    printf("\n Digite a primeira nota(Max:50):");
    scanf("%f", &nota1);
    printf("\n Digite a segunda nota(Max:50):");
    scanf("%f", &nota2);
    cal = nota1 + nota2;
    if (cal >= 60)
    {
        printf("\n O aluno esta aprovado.");
    }
    else if (cal >= 40)
    {
        printf("\n O aluno esta em reavaliacao.");
    }
    else
    {
        printf("\n O aluno esta reprovado.");
    }
    return 0;
}
