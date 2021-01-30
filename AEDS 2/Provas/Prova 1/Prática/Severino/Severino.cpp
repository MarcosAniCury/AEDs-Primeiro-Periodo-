#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    int n = 0;
    while (scanf("%i", &n) != EOF)
    {
        float array[n];
        for(int i = 0;i < n;i++)
        {
            scanf("%f", &array[i]);
        }
        for(int i = 1;i<n;i++)
        {
            float tmp = array[i];
            int j=i-1;
            while((j >=0) && (array[j] > tmp))
            {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = tmp;
        }
        for (int i=0;i<n;i++)
        {
            printf("%04.f\n", array[i]);
        }   
    }
    return 0;
}