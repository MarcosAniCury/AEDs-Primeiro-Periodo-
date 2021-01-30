#include <stdio.h>
#include <stdlib.h>

void fibonati (int A[]);

int main()
{
    int A[100];
    fibonati(A);
    return 0;
}

void fibonati (int A[])
{
    int fib = 1, temp, fib2 = 0;
    for (int ter = 0; ter != 100; ter++)
    {
        A[ter] = fib;
        temp = fib;
        fib = fib + fib2;
        fib2 = temp;
        printf("\n %d termo do arranjo e %d", ter, A[ter]);
    }
}
