#include <stdio.h>
#include <stdlib.h>

typedef struct DB
{
    char nome[30];
    int DataNascimento;
    int MesNascimento;
} Cadas;

Cadas tabela;

int main()
{
    tabela.DataNascimento = 15;
    printf("%s", tabela.DataNascimento);
    return 0;
}
