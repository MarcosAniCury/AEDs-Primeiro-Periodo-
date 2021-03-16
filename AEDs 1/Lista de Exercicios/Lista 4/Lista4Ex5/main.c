#include <stdio.h>
#include <stdlib.h>

int main()
{
    int alu,ida,sida = 0,med,alu1;
    printf("\n Algoritmo media aluno.");
    printf("\n Digite o numero de alunos:");
    scanf("%i", &alu);
    alu1 = alu;
    while (alu != 0)
    {
        alu = alu - 1;
        printf("\n Digite a idade do aluno:");
        scanf("%i", &ida);
        sida = sida + ida;
    }
    med = sida / alu1;
    printf("\n A media das idades e %i", med);
    return 0;
}
