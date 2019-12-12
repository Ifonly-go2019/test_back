#include <stdio.h>
#define maxlen 30

typedef struct
{
		int elem[maxlen];
		int lenth;		//存放顺序表中元素个数
} sqlisttp;

void demo(sqlisttp *L)
{
	int i = 1, j = 0;
	while ( _________ )
	{
		if (L->elem[i] != L->elem[j])
		{
			________;
			________;
		}
		i++;
	}
	_________;
}

int main(void)
{
	int i;
	sqlisttp L;

	for (i = 0; i <= 15; i++)
	{
		L.elem[i] = i / 2;
	}
	L.lenth = i;

	demo(&L);
	for (i = 0; i <= L.lenth; i++)
	{
		printf("%d, ", L.elem[i]);
	}
	printf("\n");
	return 0;
}