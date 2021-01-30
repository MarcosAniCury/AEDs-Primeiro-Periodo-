#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <ctype.h>

int main()
{
    int nualu,idaalu,marc,maiida,menida,tgen = 0,tida = 0,tgenm = 0;
    float por;
    char gen = 'l';
    printf("\n Algoritmo de perfil da turma.");
    printf("\n Digite o numero de alunos na sala:");
    scanf("%d", &nualu);
    marc = nualu;
    for (nualu;nualu > 0;nualu--)
    {
        bool ero,ero0;
        do
        {
            printf("\n Digite a idade do(a) aluno(a):");
            scanf("%d", &idaalu);
            ero = idaalu > 100 || idaalu < 1;
            if  (ero)
                printf("\n Valor invalido digite novamente.");
            if (!ero)
            {
                if (idaalu >= 18)
                    tida++;
            }
        }while(ero);
        do
        {
            fflush(stdin);
            printf("\n Digite o genero do(a) aluno(a) (para masculino digite M e para feminino digite F):");
            scanf("%c", &gen);
            gen = toupper(gen);
            ero0 = gen == 'M' || gen == 'F';
            if(!ero0)
                printf("\n Valor invalido digite novamente.");
            if (ero0)
            {
                tgen++;
                if (gen == 'M')
                    tgenm++;
            }
        }while (!ero0);
        if(marc == nualu)
        {
           maiida = idaalu;
           menida = idaalu;
        }
        if (maiida < idaalu)
            maiida = idaalu;
        if (menida > idaalu)
            menida = idaalu;
    }
    printf("\n O aluno mais velho possui:%d", maiida);
    printf("\n O aluno mais novo possui:%d", menida);
    por = (float)tida * 100 / (float)marc;
    printf("\n A porcentagem de alunos maiores de idade:%f", por);
    por = (float)tgenm * 100 / (float)tgen;
    printf("\n A porcentagem de alunos do genero masculino:%f", por);
    por = 100 - por;
    printf("\n A porcentagem de alunos do genero feminino:%f", por);
    return 0;
}
