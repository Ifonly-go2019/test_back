#include <stdio.h>

#define N 10

void Josef(int a[N+1], int s, int m)
{
	int i, j, w, s1;

	for (i = 1; i <= N; i++)
	{
		a[i] = i;
	}
	s1 = s;
	for (i = N; i>= 2; i--)
	{
		s1 = ________;		//�����Ȧ����
		if (s1== 0)
		{
			________;
		}
		w = a[s1];			//a[s1]��Ȧ
		for (j = ________; j++)
		{
			a[j] = a[j+1];
		}
		a[i]=w;
	}

	printf("��Ȧ����Ϊ��");
	for (i = N; i>=1;i--)
	{
		printf("%d ", a[i]);
	}
	printf("\n");
}

int main(void)
{
	int a[N+1];
	Josef(a, 1, 3);
	return 0;
}