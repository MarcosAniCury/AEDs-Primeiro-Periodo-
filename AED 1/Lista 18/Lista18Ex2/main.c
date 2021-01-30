#include <stdio.h>
#include <stdlib.h>

int main()
{
    FILE *arq;
    arq = fopen("exemplo.dat", "w");
    if (arq == 0)//null
        printf("\n Erro na criacao do arquivo.");
    fprintf(arq,"18");
    fclose(arq);
    return 0;
}
