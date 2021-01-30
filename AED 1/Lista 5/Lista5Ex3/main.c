#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{
    int aluno,alunocopia;
    float nota,snota,mainota = 0,mennota = 100;
    printf("\n Algoritmo nota.");
    printf("\n Digite o numero de alunos:");
    scanf("%d", &aluno);
    alunocopia = aluno;
    do
    {
        bool ero1;
        do
        {

            printf("\n Digite a nota do aluno:");
            scanf("%f", &nota);
            ero1 = nota < 0 || nota > 100;
            if (ero1)
                printf("\n Nota invalida, era esperado uma nota entre 0 e 100");
        }while (ero1);
        aluno = aluno - 1;
        if (nota < 60)
            printf("\n O foi reprovado.");
        else
            printf("\n O aluno foi aprovado.");
        //soma das notas
        snota = snota + nota;
        //maior nota possivel
        if (mainota < nota)
            mainota = nota;
        //menot nota possivel
        if (mennota > nota)
            mennota = nota;
    }while (aluno != 0);
    snota = snota / alunocopia;
    printf("\n A media das notas e %f", snota);
    printf("\n A maior nota dos alunos e %f", mainota);
    printf("\n A menor nota dos alunos e %f", mennota);
    return 0;
}
