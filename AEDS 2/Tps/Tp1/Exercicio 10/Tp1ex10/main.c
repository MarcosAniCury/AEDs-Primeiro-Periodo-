#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void main()
{
    int n = 0;
    scanf("%i", &n);
    double valores[n];
    for (int i = 0; i < n;i++)
        scanf("%lf", &valores[i]);
    FILE *arq = fopen("bancodedados.txt", "w");
    if (arq == 0)//null
        printf("\n Erro na criacao do arquivo.");
    for (int i = 0; i < n; i++)
        fprintf(arq,"%lf\n", valores[i]);
    fclose(arq);
    FILE *arq1 = fopen("bancodedados.txt","r");
    fseek(arq1, 0, SEEK_END); //ir para o fim do arquivo
    double verifica = ftell(arq); //assumir a posição como fim
    char ch[1000];
    while(verifica >= 0)
    {
        fseek(arq, verifica, SEEK_SET); //reposicionar de acordo com a posicao
        fgets(ch,strlen(ch),arq1);
        printf("%s\n",ch);
        verifica--; //andar uma posição para trás
    }
    fclose(arq1);
}

