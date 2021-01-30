#include <stdio.h>
#include <stdlib.h>

int main()
{
    FILE *arq;
    arq = fopen("exemplo.dat", "a");
    if (arq == 0)//null
        printf("\n Erro na criacao do arquivo.");
    fprintf(arq,"\n 18");
    fprintf(arq,"\n 47");
    fprintf(arq,"\n 41");
    fclose(arq);
    return 0;
}
