#include <stdio.h>
#define N 15

char a[20] = "OABCDEFGOOHOIJKL";

print(int i)
{
	if (i <= N && a[i] != 'O')
	{
		print(2*i);
		printf("%c", a[i]);
		print(2*i+1);
	}
}

main()
{
	print(1);
}