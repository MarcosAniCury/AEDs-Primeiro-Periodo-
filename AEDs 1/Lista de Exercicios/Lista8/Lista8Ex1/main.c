#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int main()
{
    int cru = 0,atl = 0,out = 0;
    char time;
    const int flag = 'S';
    printf("\n Algoritmo Time preferido.");
    printf("\n Digite qual o maior time de minas \n C - Cruzeiro \n A - Atletico \n O - Outros:");
    scanf("%c", &time);
    time = toupper(time);
    if(time != flag)
    {
        do
        {
            fflush(stdin);
            if (time == 'C')
                cru++;
            else if (time == 'A')
                atl++;
            else if (time == 'O')
                out++;
            printf("\n Digite qual o maior time de minas \n C - Cruzeiro \n A - Atletico \n O - Outros:");
            scanf("%c", &time);
            time = toupper(time);
        }while (time != flag);
        if (cru > atl && cru > out)
            printf("\n O maior time e o cruzeiro.");
        else if (atl > cru && atl > out)
            printf("\n O maior time e o atletico.");
        else if (out > cru && out > atl)
            printf("\n O maior time de minas nao e nem o atletico nem o cruzeiro.");
        else if (cru == atl)
            printf("\n Atletico e cruzeiro ficaram empatados como maiores times de minas.");
    }
    return 0;
}
