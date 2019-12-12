#include <stdio.h>

int f(________)
{
	int i = 0, j = 0;
	while (s[j])
	{
		________;
	}
	for (j--; i < j && s[i] == s[j]; i++, j--)
	{
		;
	}
	return ________;
}

int main(void)
{
	printf("%d\n", f("abba"));
	printf("%d\n", f("abab"));
	return 0;
}