#include <stdio.h>

#define NMAX 10

int main(void)
{
	int i, j, n, k, p, q, m;
	int a[NMAX][NMAX]={0};
	
	scanf("%d", &n);
	m = 1;
	for (k = 1; ________; k++)
	{
		if (k < n)
		{
			q = k;
		}
		else
		{
			________;
		}
		for (p = 1; p <= q; p++)
		{
			if (________)
			{
				i = q-p+1;
				j=p;
			}
			else
			{
				i = p;
				j = q-p+1;
			}
			if (________)
			{
				i = i+n-q;
				j=j+n-q;
			}
			a[i][j] = m;
			________;
		}
		
	}
	for (i = 1; i <= n; i++)
	{
		for (j = 1; j <= n; j++)
		{
			printf("%4d", a[i][j]);
		}
		printf("\n");
	}
}