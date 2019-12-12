#include <stdio.h>

#define MAX 1000
int a[MAX], s[MAX];

void preorder(int a[], int n);

int main(void)
{
	int i, n;

	scanf("%d", &n);
	
	for (i = 1; i <= n; i++)
	{
		a[i] = i;
	}
	preorder(a, n);
	return 0;
}

void preorder(int a[], int n)
{
	int top = 0, t = 1;

	while (t <= n || ________)
	{
		while (t <= n)
		{
			printf("%d ", a[t]);
			top++;
			s[top] = t;
			t = ________;
		}
		if (top > 0)
		{
			t = s[top] * 2 + 1;
			top = ________;
		}
	}
}