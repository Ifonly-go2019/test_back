#include <stdio.h>

#define L 5
#define M 4
#define N 9

void sort(int a[], int b[], int c[])
{
	int i, j, k, x;
	int d[M];

	for (i = 0; i < M; i++)
	{
		d[i] = ________;
	}
	i = 0;
	j = 0;
	k = 0;
	while (i < L && j < M)
	{
		if (a[i] > d[j])
		{
			________;
			________;
		}
		else
		{
			________;
			________;
		}
		c[k] = x;
		________;
	}
	while (________)
	{
		c[k] = a[i];
		k++;
		i++;
	}
	while (________)
	{
		c[k] = d[j];
		k++;
		j++;
	}
}

int main(void)
{
	int i;
	int a[L] = {12, 10, 5, 3, 1};
	int b[M] = {4, 6, 8, 15};
	int c[N];

	sort(a, b, c);

	for (i = 0; i < N; i++)
	{
		printf("%d ", c[i]);
	}
	printf("\n");
	return 0;
}