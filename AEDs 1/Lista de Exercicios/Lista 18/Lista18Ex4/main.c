#include <stdio.h>
#include <stdlib.h>

int main()
{
    FILE *arq;
    char buff[255];
    arq = fopen("exemplo.dat", "r");
    if (arq == 0)//null
        printf("\n Erro na criacao do arquivo.");
    fgets(buff, 255, (FILE*)arq);
    printf("1: %s\n", buff );
    fgets(buff, 255, (FILE*)arq);
    printf("2: %s\n", buff );
    fgets(buff, 255, (FILE*)arq);
    printf("3: %s\n", buff );
    fclose(arq);
    return 0;
}
