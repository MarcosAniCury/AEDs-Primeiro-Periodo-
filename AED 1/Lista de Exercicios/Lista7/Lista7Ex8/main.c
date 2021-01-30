#include <stdio.h>
#include <stdlib.h>

int main()
{
    int fib = 1,ter,fib2 = 0,temp;
    printf("\n Algoritmo utlizando a seguencia de fibonacci.");
    printf("\n Digite os termos de fibonacci:");
    scanf("%d", &ter);
    for (ter; ter >= 1; ter--)
    {
        printf("\n A seguencia de fibonacci e %d", fib);
        temp = fib;
        fib = fib + fib2;
        fib2 = temp;
    }
    return 0;
}
