#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n = 0;
    scanf("%i", &n);
    int vagoes[n];
    for(int i = 0; i < n;i++)
        vagoes[i] = 0;
    int m = 0;
    scanf("%i", &m);
    for (int i = 0;i < m;i++)
    {
        int oper = 0;
        int contpessoas = 0;
        scanf("%i", &oper);
        if (oper == 1)
        {
            int x = 0;
            int y = 0;
            scanf("%i", &x);
            scanf("%i", &y);
            vagoes[x] += y;
            printf("%i\n", vagoes[x]);
        }
        else
        {
            int valores[4];
            for (int i = 0;i < 4;i++)
                scanf("%i", &valores[i]);    
            if ((valores[1] >= valores[2] && valores[0] < valores[3]) && !(valores[0] == valores[1] && valores[2] == valores[3]))
            {
                int menor = valores[0];
                int maior = menor;
                for (int i = 1; i < 4;i++)
                {
                    if (menor > valores[i])
                        menor = valores[i];
                    if (maior < valores[i])
                        maior = valores[i];
                }
                for(int i = menor;i <= maior;i++)
                {
                    contpessoas += vagoes[i];
                }
                printf("%i\n", contpessoas);
            }
            else
            {
                if (valores[0] != valores[1])
                {
                    for(int i = valores[0];i <= valores[1];i++)
                        contpessoas += vagoes[i];
                }
                else
                {
                    contpessoas += vagoes[valores[0]];
                }
                if (valores[2] != valores[3])
                {
                    for(int i = valores[2];i <= valores[3];i++)
                        contpessoas += vagoes[i];
                }
                else
                {
                    contpessoas += vagoes[valores[2]];
                }
                
                printf("%i\n", contpessoas);
            }
        }
    }
    return 0;
}