#include <stdio.h>
#include <stdlib.h>

int fib(int num,int x, int y)
{
  if(num == 0)
    return 0;
  if(num> 1)
    return y + fib(num - 1, y, x + y);
  else
    return 1;
}

int main()
{
  int num = 0;
  printf("Termo desejado: ");
  scanf("%i",&num);
  printf("O valor do %i termo dos numeros fibonacci e %d\n",num,fib(num,1,0));
  return 0;
}
