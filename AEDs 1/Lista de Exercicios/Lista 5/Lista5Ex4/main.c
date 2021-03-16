#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{
    int voto,chapa1 = 0,chapa2 = 0,nulo = 0,vtotal = 0;
    float por;
    bool menu = 0;
    printf("Algoritmo de votacao do D.A.");
    do
    {
        printf("\n Digite a opcao desejada \n 0-Sair do programa \n 1-Chapa 1 \n 2-Chapa 2 \n 3-Voto branco ou nulo:");
        scanf("%d", &voto);
        switch (voto)
        {
            case 0: menu = 1;
                    break;
            case 1: chapa1 = chapa1 + 1;
                    vtotal = vtotal + 1;
                    break;
            case 2: chapa2 = chapa2 + 1;
                    vtotal = vtotal + 1;
                    break;
            case 3: nulo = nulo + 1;
                    vtotal = vtotal + 1;
                    break;
            default: printf("\n Valor invalido digite novamente.");
        }
    }while (!menu);
    if (chapa1 > chapa2)
        printf("\n O vencedor e a chapa 1.");
    else if (chapa1 < chapa2)
        printf("\n O vencedor e a chapa 2.");
    else
        printf("\n Foi declarado empate.");
    //O numero de votos
    printf("\n O numero de votos para a chapa 1 foi %d \n O numero de votos para a chapa 2 foi %d \n O numero de votos em branco ou nulo foi %d", chapa1,chapa2,nulo);
    por = ((float)chapa1*100)/(float)vtotal;
    printf("\n O percentual de votos para a chapa 1 e %f porcento", por);
    por = ((float)chapa2*100)/(float)vtotal;
    printf("\n O percentual de votos para a chapa 2 e %f porcento", por);
    por = ((float)nulo*100)/(float)vtotal;
    printf("\n O percentual de votos brancos ou nulos e %f porcento", por);
    return 0;
}
